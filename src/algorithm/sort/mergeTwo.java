package algorithm.sort;

import java.util.Arrays;

public class mergeTwo {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5,7,9,11,0,0,0,0};
        int[] nums2 = {2,4,6,8};
        merge(nums1,6,nums2,4);
        System.out.println(Arrays.toString(nums1));


    }

    public static void merge(int[] arr1, int m, int[] arr2, int n){
        int index = m+n-1;
        n--;
        m--;
        while(n >= 0){
            if(m >= 0 && arr1[m] > arr2[n]){
                arr1[index--] = arr1[m--];
            }else{
                arr1[index--] = arr2[n--];
            }
        }


    }
}
