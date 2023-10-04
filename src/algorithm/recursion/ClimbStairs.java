package algorithm.recursion;

public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climb(3));
    }
    public static int climb(int n) {
        int[] arr = new int[n+1];
        return climb(n,arr);
    }
    public static int climb (int n, int[] arr) {
       if (n == 1) {
           arr[1] = 1;
           return arr[1];
       }
       if (n == 2) {
           arr[2] = 2;
           return arr[2];
       }
       arr[1] = 1;
       arr[2] = 2;
       for (int i = 3; i <= n; i++) {
           arr[i] = arr[n-1] + arr[n-2];
       }
       return arr[n];
    }
}
