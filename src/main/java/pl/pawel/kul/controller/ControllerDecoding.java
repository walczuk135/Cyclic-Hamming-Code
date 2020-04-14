package pl.pawel.kul.controller;

import pl.pawel.kul.model.FunctionTwo;
import pl.pawel.kul.model.GeneratingFunction;
import pl.pawel.kul.service.DecodingMessage;
import pl.pawel.kul.service.utill.ArrayToData;
import pl.pawel.kul.service.utill.DataToArray;

import java.util.Arrays;

public class ControllerDecoding {

    private GeneratingFunction generatingFunction;

    private DecodingMessage decodingMessage;
    private final String data;

    public ControllerDecoding(String data) {
        this.generatingFunction=new FunctionTwo();
        this.data = data;
        this.decodingMessage = new DecodingMessage(new FunctionTwo(), data);
    }

    public String decoding() {
        StringBuilder sb = new StringBuilder();
        for (int[] s1 : generatingFunction.getMatrixFunction()) {
            sb.append(Arrays.toString(s1)).append('\n');
        }
        String s = sb.toString();

        int[] dataTable = DataToArray.convertToTable(data);
        int[] newSyndrome = decodingMessage.calculateNewSyndrome();
        int[] oldSyndrome = decodingMessage.calculateOldSyndrome();
        int[] xorResult = decodingMessage.xorResultSyndromeOldSyndrome();
        String calculatingYr = "Yr1 = " + generatingFunction.getMatrixFunction()[0][0] + "*" + dataTable[0] + " XOR " + generatingFunction.getMatrixFunction()[0][1] + "*" + dataTable[1] + " XOR " + generatingFunction.getMatrixFunction()[0][2] + "*" + dataTable[2] + " XOR " + generatingFunction.getMatrixFunction()[0][3] + "*" + dataTable[3] + "=" + newSyndrome[0] + "\n"
                + "Yr2 = " + generatingFunction.getMatrixFunction()[1][0] + "*" + dataTable[0] + " XOR " + generatingFunction.getMatrixFunction()[1][1] + "*" + dataTable[1] + " XOR " + generatingFunction.getMatrixFunction()[1][2] + "*" + dataTable[2] + " XOR " + generatingFunction.getMatrixFunction()[1][3] + "*" + dataTable[3] + "=" + newSyndrome[1] + "\n"
                + "Yr3 = " + generatingFunction.getMatrixFunction()[2][0] + "*" + dataTable[0] + " XOR " + generatingFunction.getMatrixFunction()[2][1] + "*" + dataTable[1] + " XOR " + generatingFunction.getMatrixFunction()[2][2] + "*" + dataTable[2] + " XOR " + generatingFunction.getMatrixFunction()[2][3] + "*" + dataTable[3] + "=" + newSyndrome[2] + "\n";

        String syndrome = "Syndrome = " + Arrays.toString(oldSyndrome) + " XOR " + Arrays.toString(newSyndrome) + " = " + Arrays.toString(xorResult);

        String result = s + "*\n"
                + "       [ " + dataTable[0] + " ]\n"
                + "       [ " + dataTable[1] + " ]\n"
                + "       [ " + dataTable[2] + " ]\n"
                + "       [ " + dataTable[3] + " ]\n"
                + "       [Yr1]\n"
                + "       [Yr2]\n"
                + "       [Yr3]\n"
                + "=\n[0]\n[0]\n[0]"
                + "\n" + calculatingYr
                + "\n" + syndrome;

        if (decodingMessage.validXor()) {
            result = result.concat("\nA message without errors!");
        } else {
            int i = decodingMessage.calculateErrorBit();
            int[] vectorError = decodingMessage.fillVectorZeroErrorBit(i);
            int[] message = decodingMessage.resultCorrectMessage(i);
            result = result.concat("\nAn error occurred on the " + i + "th bit."
                    + "\nEn = " + Arrays.toString(vectorError))
                    + "\nCorrecting the result : \n"
                    + "Yn = " + Arrays.toString(vectorError) + " XOR " + Arrays.toString(dataTable) + " = " + Arrays.toString(message)
                    + "\nCorrect message = " + ArrayToData.convert(message);
        }
        return result;
    }

    public void setGeneratingFunction(GeneratingFunction generatingFunction,String message) {
        this.generatingFunction=generatingFunction;
        this.decodingMessage = new DecodingMessage(generatingFunction,message);
    }
}
