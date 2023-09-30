package algorithm.sort;

import java.util.Arrays;

public class MergeSort {
      // 内部排序  时间复杂度nlog2n 空间复杂度n 稳定排序
    public static void main(String[] args) {

        int[] arr = {423,54,3,25,43,6754,3245,342,432,654,3};
        int[] temp = new int[arr.length];
        merge(arr,0, arr.length-1,temp);
        System.out.println(Arrays.toString(arr));


    }
    public static void merge(int[] arr,int left, int right,int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            merge(arr,left,mid,temp);
            merge(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
         int l = left;
         int r = mid + 1;
         int index = 0;
         while(l <= mid && r <= right){
            if(arr[l] < arr[r]){
                temp[index++] = arr[l++];
            }else{
                temp[index++] = arr[r++];
            }
        }
        while (l <= mid){
            temp[index++] = arr[l++];
        }
        while (r <= right){
            temp[index++] = arr[r++];
        }
        index= 0 ;
        for(int i = left; i <= right; i++){
            arr[i] = temp[index++];
        }
    }
}
