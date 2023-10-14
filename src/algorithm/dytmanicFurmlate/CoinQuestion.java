package algorithm.dytmanicFurmlate;

import java.util.Arrays;

public class CoinQuestion {
    //硬币 [2,7,3,5,3] 得到10块  最小硬币数
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int index = 0;
        int aim = 9;
        System.out.println(f(arr,index,aim));

        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = -2;
            }
        }
        System.out.println(f2(arr,index,aim,dp));
        for(int[] ar : dp) {
            System.out.println(Arrays.toString(ar));
        }
        System.out.println("=============");
        System.out.println(minCoins(arr,aim));
    }

    //普通暴力递归
    public static int f(int[] arr, int index, int aim) {
        if (aim < 0) { //没办法，
            return -1;
        }
        if (aim == 0) { //不用做决定了
            return 0;
        }
        if (index == arr.length) { //硬币没了，还剩钱
            return -1;
        }
        //选择当前硬币       硬币数目加1           和         不选择当前硬币
        int p1 = f(arr,index + 1,aim);  //不选择当前的
        int p2Next = f(arr,index + 1,aim-arr[index])  ; //选择当前的硬币
        if (p1 == -1 && p2Next == -1) {  //两个都没办法
            return -1;
        } else {
            if (p1 == -1) {
                return 1 + p2Next;  //不选择当前硬币没办法 ，只能选择当前硬币来作为返回值
            }
            if (p2Next == -1) {     //选择当前硬币没办法，只能不选择当前硬币
                return p1;
            }
            return Math.min(p1, p2Next + 1);  //两种都有办法 返回最小的
        }
    }

    //记忆化搜索
    public static int f2 (int[] arr, int index, int aim,int[][] dp) {
        if (aim < 0) {
            return -1;
        }
        if (dp[index][aim] != -2) {
            return dp[index][aim];
        }
        if (aim == 0) {
            dp[index][aim] = 0;
        } else if (index == arr.length){
            dp[index][aim] = -1;
        } else {
            int p1 = f2(arr,index + 1,aim,dp);  //不选择当前硬币
            int p2 = f2(arr, index + 1,aim - arr[index], dp);
            if (p1 == -1 && p2 == -1) {
               dp[index][aim] = -1;
            } else {
                if (p1 == -1) {
                    dp[index][aim] = p2 + 1;  //要当前硬币
                } else if (p2 == -1){
                    dp[index][aim] = p1;     //不要当前硬币
                } else {
                    dp[index][aim] = Math.min(p1,p2+1);
                }
            }
        }
        return dp[index][aim];
    }
    public static int minCoins (int[] arr,int aim) {
        int N = arr.length;
        int[][] dp = new int[N + 1][aim+1];
        for (int row = 0; row <= N; row++) {
            dp[row][0] = 0;
        }
        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }
        for (int index = N - 1; index >= 0; index --) {
            for (int rest = 1; rest <= aim; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 =  -1;
                if (rest - arr[index] >= 0) {
                    p2 = dp[index + 1][rest - arr[index]];
                }
                if (p1 == -1 && p2 == -1) {
                    dp[index][rest] = -1;
                } else {
                    if (p1 == -1) {
                        dp[index][rest] = p2 + 1;
                    } else if (p2 == -1) {
                        dp[index][rest] = p1;
                    } else {
                        dp[index][rest] = Math.min(p1, p2 + 1);
                    }
                }
            }
        }
        for(int[] ar : dp) {
            System.out.println(Arrays.toString(ar));
        }
        return dp[0][aim];



    }







}
