package pl.pawel.kul.service.utill;

import java.util.stream.IntStream;

public class DeleteElementFromArray {
    public static int[] deleteItem(int item,int[] arr){
        return IntStream.range(0, arr.length)
                .filter(i -> i != item)
                .map(i -> arr[i])
                .toArray();
    }
}
