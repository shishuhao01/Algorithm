package algorithm.sort;

import java.util.Arrays;

public class ChooseSort {
    //也属于内部排序法， 不稳定， 时间复杂度为 n的平方， 空间额外复杂度是1;
    public static void main(String[] args) {
        int[] arr = {25,423,5,345,345,432,234,1,2,23};
        chooseSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void chooseSort(int[] arr) {

         for(int i = 0; i < arr.length; i++){
               int min = arr[i];
               int minIndex = i;
               for(int j = i+1; j < arr.length; j++){
                   if(min < arr[j]){
                       min = arr[j];
                       minIndex = j;
                   }
               }
               if(minIndex != i){
                   arr[minIndex] = arr[i];
                   arr[i] = min;
               }
         }
    }
}
