package pl.pawel.kul.service;

import pl.pawel.kul.model.GeneratingFunction;
import pl.pawel.kul.service.utill.DataToArray;

import java.util.Arrays;

public class DecodingMessage {
    private final GeneratingFunction generatingFunction;
    private final int[][] matrixFunction;
    private final String data;

    
    public DecodingMessage(GeneratingFunction generatingFunction, String data ) {
        this.generatingFunction = generatingFunction;
        this.matrixFunction = generatingFunction.getMatrixFunction();
        this.data=data;
    }

    public String decoding(){
        StringBuilder sb = new StringBuilder();
        for(int[] s1 : matrixFunction){
            sb.append(Arrays.toString(s1)).append('\n');
        }
        String s = sb.toString();

        int[] dataTable=DataToArray.convertToTable(data);
        int[] newSyndrome = calculateNewSyndrome();
        int[] oldSyndrome = calculateOldSyndrome();
        int[] xorResult = xorResultSyndromeOldSyndrome();
        String calculatingYr="Yr1 = "+matrixFunction[0][0]+"*"+dataTable[0]+" XOR " +matrixFunction[0][1]+"*"+dataTable[1]+" XOR " +matrixFunction[0][2]+"*"+dataTable[2]+" XOR " +matrixFunction[0][3]+"*"+dataTable[3]+"=" +newSyndrome[0]+"\n"
                +"Yr2 = "+matrixFunction[1][0]+"*"+dataTable[0]+" XOR " +matrixFunction[1][1]+"*"+dataTable[1]+" XOR " +matrixFunction[1][2]+"*"+dataTable[2]+" XOR " +matrixFunction[1][3]+"*"+dataTable[3]+"=" +newSyndrome[1]+"\n"
                +"Yr3 = "+matrixFunction[2][0]+"*"+dataTable[0]+" XOR " +matrixFunction[2][1]+"*"+dataTable[1]+" XOR " +matrixFunction[2][2]+"*"+dataTable[2]+" XOR " +matrixFunction[2][3]+"*"+dataTable[3]+"=" +newSyndrome[2]+"\n";

        String syndrome="Syndrome = "+Arrays.toString(oldSyndrome)+" XOR "+Arrays.toString(newSyndrome)+" = "+Arrays.toString(xorResult);

        String result=s+"*\n"
                +"       [ "+dataTable[0]+" ]\n"
                +"       [ "+dataTable[1]+" ]\n"
                +"       [ "+dataTable[2]+" ]\n"
                +"       [ "+dataTable[3]+" ]\n"
                +"       [Yr1]\n"
                +"       [Yr2]\n"
                +"       [Yr3]\n"
                +"=\n[0]\n[0]\n[0]"
                +"\n"+calculatingYr
                +"\n"+syndrome;

        if (validXor()){
            result = result.concat("\nA message without errors!");
        }else {
            int i = calculateErrorBit();
            int[] vectorError = fillVectorZeroErrorBit(i);
            int[] message = resultCorrectMessage(i);
            result = result.concat("\nAn error occurred on the "+i+ "th bit."
            +"\nEn = "+Arrays.toString(vectorError))
            +"\nCorrecting the result : \n"
            +"Yn = "+Arrays.toString(vectorError)+" XOR "+ Arrays.toString(dataTable)+" = " + Arrays.toString(message)
            +"\nCorrect message = "+Arrays.toString(message);
        }
        return result;
    }

    public boolean validXor(){
        return Arrays.equals(xorResultSyndromeOldSyndrome(), new int[]{0, 0, 0});
    }

    public int calculateErrorBit(){
        int[] checkVector = new int[3];
        int numberError=0;
        for (int i = 0; i < 7; i++) {
            checkVector[0]=matrixFunction[0][i];
            checkVector[1]=matrixFunction[1][i];
            checkVector[2]=matrixFunction[2][i];

            if(Arrays.equals(xorResultSyndromeOldSyndrome(),checkVector)){
                numberError=i;
                break;
            }
        }
        if (numberError==0){
            return 0;
        }
        return ++numberError;
    }

    public int[] xorResultSyndromeOldSyndrome(){
        int [] resultXor=new int[3];
        for (int i = 0; i < 3; i++) {
            resultXor[i]=calculateNewSyndrome()[i]^ calculateOldSyndrome()[i];
        }
        return resultXor;
    }

    public int[] calculateNewSyndrome() {
        int[] ints = DataToArray.convertToTable(data.substring(0, 4));
        int[] items = new int[3];
        for (int i = 0; i < 3; i++) {
            items[i] = matrixFunction[i][0] * ints[0]
                    ^ matrixFunction[i][1] * ints[1]
                    ^ matrixFunction[i][2] * ints[2]
                    ^ matrixFunction[i][3] * ints[3];
        }

        return items;
    }

    public int[] calculateOldSyndrome(){
        return DataToArray.convertToTable(data.substring(4));
    }

    public int[] fillVectorZeroErrorBit(int i){
        int[] array=new int[]{0,0,0,0,0,0,0};
        array[i-1]=1;
        return array;
    }

    public int[] resultCorrectMessage(int j){
        int[] result=new int[7];
        int[] message=DataToArray.convertToTable(data);
        for (int i = 0; i < message.length; i++) {
            result[i]=message[i]^fillVectorZeroErrorBit(j)[i];
        }
        return result;
    }

    public GeneratingFunction getGeneratingFunction() {
        return generatingFunction;
    }

}
