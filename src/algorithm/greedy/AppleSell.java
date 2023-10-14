package algorithm.greedy;

public class AppleSell {

    //袋子只能6个苹果和8个，返回最小袋子数目
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i+":  "+getMin(i));
        }

    }

    //普通解法，暴力枚举
    public static int getMin(int N) {
        if (N % 2 == 1) {
            return -1;
        }
        int m = N/8;

        for (int i = m; i >= 0;i--) {
            int rest = N - 8*i;
            if (rest > 24) {  //大于24的时候，已经大于最小公倍数了，用8个袋子解决24,每次都减少8个
                return -1;
            } else {
                if (rest % 6 == 0) {
                    return rest/6 + i;
                }
            }
        }
        return -1;
    }



    //打表法
    public static int Best (int apple) {
        if ((apple & 1) != 0) { //奇数
            return -1;
        }
        if (apple < 18) {
            if (apple == 0) {
                return 0;
            }
            if (apple == 6 || apple == 8) {
                return 1;
            } if (apple == 14 || apple == 12 || apple == 16) {
                return 2;
            }
            return -1;
        }
        return (apple - 18) /8 + 3;
    }




}
