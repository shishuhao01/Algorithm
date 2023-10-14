package algorithm.DytmanicFurmlate;

import java.util.Arrays;

public class MinimumPath {
    //给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    //说明：每次只能向下或者向右移动一步。
    public static void main(String[] args) {
        int[][] grid =  {{1,3,1}, {1,5,1},{4,2,1}};
        DynamicFormulate(grid);

    }

    // 递归  m = grid.length-1 ; n = grid[0].length - 1; num = 0;
    public int Recursion(int[][] grid, int m, int n, int num) {
        if (m == 0 && n == 0) {
            return grid[0][0] + num;
        }
        if (m < 0 || n < 0) {
            return 10000;
        }
        return Math.min(Recursion(grid, m - 1, n, num + grid[m][n]), Recursion(grid, m, n - 1, num + grid[m][n]));
    }

    public static int DynamicFormulate (int[][] grid){
        int m = grid.length - 1 ;
        int n = grid[0].length - 1;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = grid[0][0];
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1]+grid[0][i];
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1],dp[i-1][j]);
            }
        }
        for (int [] ids: dp) {
            System.out.println(Arrays.toString(ids));
        }


        return dp[m][n];
    }
}
