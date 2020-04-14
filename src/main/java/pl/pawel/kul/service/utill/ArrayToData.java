package pl.pawel.kul.service.utill;

import java.util.Arrays;

public class ArrayToData {
    public static String convert(int[] table){
        return Arrays.toString(table).replaceAll("\\[|\\]|,|\\s", "");
    }
}
