package pl.pawel.kul.service.utill;

import java.util.stream.Stream;

public class DataToArray {
    public static int[] convertToTable(String data){
        return Stream.of(data.replaceAll("[\\[\\]\\, ]", "").split("")).mapToInt(Integer::parseInt).toArray();
    }
}
