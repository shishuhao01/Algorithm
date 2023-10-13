package algorithm.recursion;

import java.util.Arrays;

public class RobotStep {

    public static void main(String[] args) {

        System.out.println(sway1(5,2,4,6));
        System.out.println(sway2(5,2,4,6));
        System.out.println(process3(2,4,5,6));


    }

    public static int sway1(int N,int start,int end,int Step) {
        return process1(N,start,end,Step);
    }
    public static int process1(int N,int cur, int aim, int rest) {
        if (rest == 0) {
            return cur == aim ? 1:0;
        }
        if(cur == 1) {
            return process1(N,2,aim,rest-1);
        }
        if(cur == N) {
            return process1(N,  N- 1,aim,rest - 1);
        }
        return process1(N, cur-1,aim,rest - 1) + process1(N, cur+1,aim,rest - 1);
    }




    public static int sway2(int N,int start,int end,int Step) {
        int[][] dp =  new int[N+1][Step+1];
        for(int i = 0; i <= N; i++) {
            for (int j = 0; j <= Step; j++) {
                dp[i][j] = -1;
            }
        }

        return process2(N,start,end,Step,dp);
    }
    public static int process2(int N,int cur, int aim, int rest,int[][] dp) {
       if(dp[cur][rest] != -1) {
           return dp[cur][rest];
       }
       int ans = 0;
       if(rest == 0) {
            ans = aim == cur ? 1:0;
       }else if(cur == 1) {
            ans = process2(N,2,aim,rest-1,dp);
       }else if(cur == N) {
            ans = process2(N,N-1,aim,rest-1,dp);
       }else {
            ans = process2(N,cur-1,aim,rest-1,dp) +  process2(N,cur+1,aim,rest-1,dp);
       }
        dp[cur][rest] = ans;
        return ans;
    }


    public static int process3(int start, int end, int N, int Step) {
        int[][] dp = new int[N+1][Step+1];
        dp[end][0] = 1;
        for (int rest = 1; rest <= Step; rest++) {
            dp[1][rest] = dp[2][rest-1];
            for (int cur = 2; cur < N; cur++) {
                dp[cur][rest] = dp[cur + 1][rest-1] + dp[cur - 1][rest - 1];
            }
            dp[N][rest] = dp[N-1][rest-1];
        }
        for(int[] ids:dp) {
            System.out.println(Arrays.toString(ids));
        }
        return dp[start][Step];
    }





}
