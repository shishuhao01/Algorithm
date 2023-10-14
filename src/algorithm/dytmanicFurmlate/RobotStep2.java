package algorithm.dytmanicFurmlate;

public class RobotStep2 {
//    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//    问总共有多少条不同的路径？
    public static void main(String[] args) {
        System.out.println(get(3,7,1,1));

    }

    //暴力递归
    public static int get (int m,int n,int x,int y) {
        if (x > m || y > n) {
            return 0;
        }
        if (x == m && y == n) {
            return 1;
        }
        return get(m,n,x + 1,y) + get(m,n,x,y+1);
    }


    //缓存法
    public int get (int m,int n,int x,int y,int[][] dp) {
        if (x > m || y > n) {
            return 0;
        }
        if (x == m && y == n) {
            return 1;
        }
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        int rets = get(m,n,x+1,y,dp) + get(m,n,x,y+1,dp);
        dp[x][y] = rets;
        return dp[x][y];
    }

    //动态规划
    public int get (int m,int n) {
        int[][] dp = new int [m+1][n+1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] += dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }

}
