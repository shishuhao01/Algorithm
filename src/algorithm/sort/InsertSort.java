package algorithm.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1100,34,24,2,55,3465,3434,654,765,2};
        insert(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void insert(int[] arr){
        for(int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 == i){
            }else{
                arr[++insertIndex] = insertVal;
            }
        }
    }
}
