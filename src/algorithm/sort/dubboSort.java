package algorithm.sort;

import java.util.Arrays;

public class dubboSort {
    public static void main(String[] args) {
        int[] arr = {1,234,2344,54,32,2,1,5,64,3};
        dubboSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void dubboSort(int[] arr){
        int temp = 0;
        boolean flag = true;
        for(int i = 0; i < arr.length; i++){
             for(int j = 0; j < arr.length-1-i; j++){
                 if(arr[j] > arr[j+1]){
                     flag = false;
                     temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
                 }
             }
             if(flag){
                 break;
             }else{
                 flag = true;
             }
        }
    }
}
