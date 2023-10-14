package algorithm.slidingWindow;

import java.util.Arrays;

public class StripeMaxPoints {
    //给定一个有序数组arr,代表数轴上面从左到右有n个点arr[0],arr[1]...
    //给一个正数L，代表一根长度为L的绳子，求绳子最多覆盖几个点
    //滑动窗口
    public static void main(String[] args) {
        int[] arr = {2,4,5,9,10,11,12,13,14};
        int len = 5;
        System.out.println(getMax(arr,len));
    }
    public static int getMax (int[] arr, int L) {
        int[] max = new int[arr.length];
        int rets = 0;
        int left = 0;
        int right = 1;
        for (int i = 0; i < arr.length; i++) {
            while (right <= arr.length - 1 && arr[right] - arr[left] <= L) {
                right ++;
            }
            max[i] = (right - left);
            rets = Math.max(rets,max[i]);
            left++;
        }
        System.out.println(Arrays.toString(max));
        return rets;
    }

}
