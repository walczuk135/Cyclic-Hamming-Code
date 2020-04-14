package pl.pawel.kul.controller;

import pl.pawel.kul.model.FunctionTwo;
import pl.pawel.kul.model.GeneratingFunction;
import pl.pawel.kul.service.DecodingService;
import pl.pawel.kul.service.utill.ArrayToData;
import pl.pawel.kul.service.utill.DataToArray;

import java.util.Arrays;

public class ControllerDecoding {

    private GeneratingFunction generatingFunction;

    private DecodingService decodingService;
    private final String data;

    public ControllerDecoding(String data) {
        this.generatingFunction=new FunctionTwo();
        this.data = data;
        this.decodingService = new DecodingService(new FunctionTwo(), data);
    }

    public String decoding() {
        StringBuilder sb = new StringBuilder();
        for (int[] s1 : generatingFunction.getMatrixFunction()) {
            sb.append(Arrays.toString(s1)).append('\n');
        }
        String s = sb.toString();

        int[] dataTable = DataToArray.convertToTable(data);
        int[] newSyndrome = decodingService.calculateNewSyndrome();
        int[] oldSyndrome = decodingService.calculateOldSyndrome();
        int[] xorResult = decodingService.xorResultSyndromeOldSyndrome();
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

        if (decodingService.validXor()) {
            result = result.concat("\nA message without errors!");
        } else {
            int i = decodingService.calculateErrorBit();
            int[] vectorError = decodingService.fillVectorZeroErrorBit(i);
            int[] message = decodingService.resultCorrectMessage(i);
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
        this.decodingService = new DecodingService(generatingFunction,message);
    }
}
