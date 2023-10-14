package algorithm.dytmanicFurmlate;

public class RobotStep3 {
//    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
//    现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//    网格中的障碍物和空位置分别用 1 和 0 来表示。
    public static void main(String[] args) {

    }
    //纯递归
    public int getAll (int[][] arr,int m, int n) {
        if (m >= arr.length || n >= arr[0].length) {
            return 0;
        }
        if (arr[m][n] == 1) {
            return 0;
        }             
        if (m == arr.length - 1 && n == arr[0].length -1){
            return 1;
        }
        return getAll(arr,m+1,n) + getAll(arr,m,n+1);
    }

    //缓存法
    public int getAll (int[][] arr,int m, int n,int[][] dp) {
        dp[0][0] = 1;
        if (m >= arr.length || n >= arr[0].length) {
            return 0;
        }else if (arr[m][n] == 1){
            dp[m][n] = 0;
            return 0;
        } else if (dp[m][n] == 1) {
            return dp[m][n];
        } else  if (m == arr.length - 1 && n == arr[0].length -1) {
            dp[m][n] = 1;
        } else {
            dp[m][n] = getAll(arr,m+1,n,dp) + getAll(arr,m,n+1,dp) ;
        }
        return dp[m][n];

    }


    //动态规划版本
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j]==1)
                    dp[i][j]=0;
                else{
                    if(i-1>=0)
                        dp[i][j]+=dp[i-1][j];
                    if(j-1>=0)
                        dp[i][j]+=dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];

    }
}
