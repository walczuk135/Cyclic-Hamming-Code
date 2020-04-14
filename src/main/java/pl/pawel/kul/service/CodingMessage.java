package pl.pawel.kul.service;

import pl.pawel.kul.model.GeneratingFunction;
import pl.pawel.kul.service.utill.ArrayToData;
import pl.pawel.kul.service.utill.DataToArray;

import java.util.stream.IntStream;

public class CodingMessage {
    private GeneratingFunction generatingFunction;
    private final String data;
    private final String remainder;

    public CodingMessage(GeneratingFunction generatingFunction, String data) {
        this.generatingFunction = generatingFunction;
        this.data=data;
        this.remainder=ArrayToData.convert(remainder());
    }

    public String coding() {
        return concatMessageAndRemainder(data);
    }

    private String concatMessageAndRemainder(String data) {
        return data.concat(remainder);
    }

    private int[] remainder() {
        int[] old_data = DataToArray.convertToTable(data);
        int[] divisor = DataToArray.convertToTable(generatingFunction.getGeneratingFunction());
        int[] remainder;
        int[] data = new int[old_data.length + divisor.length];
        System.arraycopy(old_data, 0, data, 0, old_data.length);
        remainder = new int[divisor.length];
        System.arraycopy(data, 0, remainder, 0, divisor.length);

        for (int i = 0; i < old_data.length; i++) {
            if (remainder[0] == 1) {
                IntStream.range(1, divisor.length).forEach(j -> remainder[j - 1] = exor(remainder[j], divisor[j]));
            } else {
                IntStream.range(1, divisor.length).forEach(j -> remainder[j - 1] = exor(remainder[j], 0));
            }
            remainder[divisor.length - 1] = data[i + divisor.length];
        }
        return IntStream.range(0, remainder.length)
                .filter(i -> i != remainder.length - 1)
                .map(i -> remainder[i])
                .toArray();

    }

    private int exor(int a, int b) {
        if (a == b) {
            return 0;
        }
        return 1;
    }

    public GeneratingFunction getGeneratingFunction() {
        return generatingFunction;
    }

    public String getData() {
        return data;
    }

    public String getMultiplyMessage() {
        return "1000";
    }

    public String getRemainder() {
        return remainder;
    }
}
