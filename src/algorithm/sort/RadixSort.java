package algorithm.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214,214,45,6,54,7,56,8,67,8,56,54,34,43242};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void radixSort(int[] arr){
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //取一个数的位数   int m = (max+"").length();
        int m = 1;
        while(max != 0){
            for(int i = 0; i < arr.length; i++) {
                int k = arr[i] /m % 10;
                bucket[k][bucketElementCounts[k]] = arr[i];
                bucketElementCounts[k]++;
            }
            int index = 0;
            for(int i = 0; i < bucket.length; i++) {
                if(bucketElementCounts[i] != 0){
                    for(int j = 0; j < bucketElementCounts[i]; j++){
                        arr[index++] = bucket[i][j];
                    }
                }
                bucketElementCounts[i] = 0;
            }
            m *= 10;
            max = max / 10;
        }
    }
}
