package algorithm.DytmanicFurmlate;

import java.util.Arrays;

public class CoinsQuestion {
    //同硬币问题，这次的硬币可以多次使用
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        System.out.println(DynamicFormulate(arr,5));
        System.out.println(Best(arr,5));

    }
    //正确，但时间太长
    public static int recursion (int[] arr, int index, int rest) {
        if (index == arr.length) { //判断如果index == length 时候，如果剩余货币为0，则记为一种方法
            return rest == 0 ? 1 : 0;
        }
        int result = 0;
        for (int i = 0; arr[index] * i <= rest; i++) {
            result += recursion(arr,index+1,rest - arr[index] * i);
        }
        return result;
    }


    //非优化行为
    public static int DynamicFormulate (int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int dp[][] = new int[N + 1][aim + 1];
        dp[N][0] = 1;          // 对应这一步  if (index == arr.length) { return rest == 0 ? 1 : 0; }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {  //这边可以优化· 之前rest行算过之前index+1 rest
                    ways += dp[index + 1][rest - arr[index] * zhang];
                }
                dp[index][rest] = ways;
            }
        }
        for(int[] ar : dp) {
            System.out.println(Arrays.toString(ar));
        }
        return dp[0][aim];
    }


    //优化版本
    public static int Best (int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int dp[][] = new int[N + 1][aim + 1];
        dp[N][0] = 1;          // 对应这一步  if (index == arr.length) { return rest == 0 ? 1 : 0; }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index+1][rest];  //他的下一个就是他
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest-arr[index]];
                }
            }
        }
        for(int[] ar : dp) {
            System.out.println(Arrays.toString(ar));
        }
        return dp[0][aim];
    }



}
