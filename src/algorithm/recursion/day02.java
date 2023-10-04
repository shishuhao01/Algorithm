package algorithm.recursion;

import java.util.Arrays;

public class day02 {
    //两个人聪明绝顶，在一个数组中只能拿两头的数，求最大的
    public static void main(String[] args) {
        int[] arr = {1,100,1,2,5,6};

        System.out.println(way1(arr,0,arr.length-1));
        System.out.println(way3(arr,0,arr.length-1));

    }
    public static int way1(int[] arr, int L, int R) {
        int first = k(arr,0,arr.length-1);
        int second = g(arr,0,arr.length-1);
        return Math.max(first, second);
    }
    //先手
    public static int k (int[] arr, int L, int R) {
        if(L == R) {
            return arr[L];
        }
        int p1 = arr[L] + g(arr,L+1,R); //先拿左边的
        int p2 = arr[R] + g(arr,L,R-1); //先拿右边的
        return Math.max(p1,p2); //求最大值
    }
    //后手函数
    public static int g (int[] arr, int L, int R) {
        if(L == R) {
            return 0;
        }
        int p1 = k(arr,L+1,R); // 先手的拿的是左边
        int p2 = k(arr,L,R-1); // 先手的拿的是右边
        return Math.min(p1,p2);   // 后手的只能拿到最小的
    }


    public static int way2(int[] arr, int L, int R) {
        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fmap[i][j] = -1;
                gmap[i][j] = -1;
            }
        }
        int first = k2(arr,0,arr.length-1,fmap,gmap);
        int second = g2(arr,0,arr.length-1,fmap,gmap);
        return Math.max(first, second);
    }


    //先手
    public static int k2 (int[] arr, int L, int R,int[][] fmap, int[][] gmap) {
        if (fmap[L][R] != -1) {
            return fmap[L][R];
        }
        int ans = 0;
        if(L == R) {
            ans = arr[L];
        }else {
            int p1 = arr[L] + g2(arr,L+1,R,fmap,gmap);
            int p2 = arr[R] + g2(arr,L,R-1,fmap,gmap);
            ans = Math.max(p1,p2);
        }
        fmap[L][R] = ans;
        return ans;
    }

    public static int g2 (int[] arr, int L, int R,int[][] fmap, int[][] gmap) {
        if (gmap[L][R] != -1) {
            return gmap[L][R];
        }
        int ans = 0;
        if(L != R) {
           int p1 = k2(arr,L+1,R,fmap,gmap);
           int p2 = k2(arr,L,R-1,fmap,gmap);
           ans = Math.min(p1,p2);
        }
        return ans;
    }







    public static int way3 (int[] arr, int L, int R) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            fmap[i][i] = arr[i];
        }
        for (int startCol = 1; startCol < N ; startCol++) {
            int l = 0;
            int r = startCol;
            while (r < N ) {
                fmap[l][r] = Math.max(arr[l] + gmap[l+1][r],arr[r] + gmap[l][r-1]);
                gmap[l][r] = Math.min(fmap[l+1][r],fmap[l][r-1]);
                l++;
                r++;
            }
        }
        for(int[] ids :fmap) {
            System.out.println(Arrays.toString(ids));
        }
        System.out.println();
        for(int[] ids :gmap) {
            System.out.println(Arrays.toString(ids));
        }
        return Math.max(fmap[0][N - 1],gmap[0][N - 1]);





    }



}
