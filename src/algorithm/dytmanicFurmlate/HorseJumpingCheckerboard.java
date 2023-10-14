package algorithm.dytmanicFurmlate;

public class HorseJumpingCheckerboard {
    //三维动态规划表
    //象棋中的马跳到某个点(x,y)上面，只能跳Step步 返回方法数
    public static void main(String[] args) {
        System.out.println(recursion(7,7,10));
        System.out.println(dynamic(7,7,10));

    }
    //9*9的棋盘
    public static int recursion (int x, int y,int step) {
        if (x < 0 || y > 9 || x > 8 || y < 0 || step < 0) {
            return 0;
        }
        if (step == 0) {
            return (x == 0 && y == 0) ? 1 : 0;
        }

        return recursion(x + 2 ,y + 1,step - 1) +
                recursion(x + 2 ,y - 1,step - 1) +
                recursion(x - 2 ,y - 1,step - 1) +
                recursion(x - 2 ,y + 1,step - 1) +
                recursion(x + 1 ,y + 2,step - 1) +
                recursion(x + 1 ,y - 2,step - 1) +
                recursion(x - 1 ,y + 2,step - 1) +
                recursion(x - 1 ,y - 2,step - 1) ;
    }



    //三维数组动态规划
    public static int dynamic (int x, int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9 || step < 0) {
            return 0;
        }
        int[][][] dp = new int[9][10][step+1];
        dp[0][0][0] = 1;
        for (int k = 1; k <= step; k++) { //代表层高 即第三个参数
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 10; j++) {
                    dp[i][j][k] += getValue (dp,i+2,j+1,k -1);
                    dp[i][j][k] += getValue (dp,i+2,j-1,k -1);
                    dp[i][j][k] += getValue (dp,i+1,j+2,k -1);
                    dp[i][j][k] += getValue (dp,i+1,j-2,k -1);
                    dp[i][j][k] += getValue (dp,i-2,j-1,k -1);
                    dp[i][j][k] += getValue (dp,i-2,j+1,k -1);
                    dp[i][j][k] += getValue (dp,i-1,j-2,k -1);
                    dp[i][j][k] += getValue (dp,i-1,j+2,k -1);
                }
            }
        }
        return dp[x][y][step];
    }

    public static int getValue (int[][][] dp, int x,int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9) {
            return 0;
        }
        return dp[x][y][step];
    }












}
