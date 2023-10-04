package algorithm.recursion;

public class NQueenQuestion {
    public static void main(String[] args) {
        System.out.println(process(0,new int[8],8));

    }
    public  static int process (int i, int[] record, int n) {
        if (n == i) {
            return 1;
        }
        int rets = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record,i,j)) {
                record[i] = j;
                rets += process(i + 1, record, n);
            }
        }
        return rets;

    }
    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

}
