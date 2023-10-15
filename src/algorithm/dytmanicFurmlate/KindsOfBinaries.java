package algorithm.dytmanicFurmlate;

public class KindsOfBinaries {
    public static void main(String[] args) {
        int n = 3;
        int[] arr = new int[3 + 1];
        System.out.println(Recursion2(n, arr));
        ;
    }

    public static int Recursion(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int rets = 0;
        for (int i = 0; i <= n - 1; i++) {
            int left = Recursion(i);
            int right = Recursion(n - 1 - i);
            rets += left * right;
        }
        return rets;
    }


    public static int Recursion2(int n, int[] arr) {

        if (n < 0) {
            return 0;
        }
        if (arr[n] != 0) {
            return arr[n];
        } else {
            if (n == 0) {
                arr[n] = 1;
            } else if (n == 1) {
                arr[n] = 1;
            } else if (n == 2) {
                arr[n] = 2;
            } else {
                for (int left = 0; left <= n - 1; left++) {
                    int leftWay = Recursion2(left, arr);
                    int rightWay = Recursion2(n - 1 - left, arr);
                    arr[n] += leftWay * rightWay;
                }
            }
        }
        return arr[n];
    }


    public static int DynamicFormulate(int n) {
        if (n < 2) {
            return 1;
        }
        int[] rets = new int[n + 1];
        rets[0] = 1;
        rets[1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i + 1; j++) {
                rets[i] += rets[j] * rets[i - j];
            }
        }
        return rets[n];
    }


}
