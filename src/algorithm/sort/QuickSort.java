package algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,2134,423,5,645,76,5435,7446,635,24,4,65,7,34,5,65,876,86,43};
        quickSort(arr,0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
    public static void quickSort (int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int mid = arr[(left + right) / 2];
        while (l < r) {
            while (arr[l] < mid) {
                l++;
            }
            while (arr[r] > mid) {
                r--;
            }
            if (r == l) {
                break;
            }
            int temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            if (arr[l] == mid) {
                r--;
            }
            if (arr[r] == mid) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }
        if (l < right) {
            quickSort(arr,l,right);
        }
        if (r > left) {
            quickSort(arr,left,r);
        }






    }
}
