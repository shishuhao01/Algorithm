package algorithm.DytmanicFurmlate;

import java.util.Arrays;

public class BackQuestion {
    public static void main(String[] args) {
        int back = 4;
        int[] weights = {1,3,4,4};
        int[] values = {10,20,25,50};
        System.out.println(DynamicProcess(weights,values,back));

    }


    public static int DynamicProcess (int[] weights, int[] value,int backWeight) {
        int[][] dp = new int[weights.length][backWeight+1];
        int rets = 0;
        for (int i = 0; i < dp[0].length; i++) {
            if (i >= weights[0]) {
                dp[0][i] = value[0];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j - weights[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + value[i]);
                }
                rets = Math.max(rets,dp[i][j]);
            }
        }            

        for (int[] in:dp) {
            System.out.println(Arrays.toString(in));
        }

        return rets;
    }
}
