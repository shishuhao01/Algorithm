package algorithm.leetcode.easy;

public class Ball {
    public static void main(String[] args) {
        System.out.println(getHeight(20,10));
    }
    public static double getHeight (int height, int count) {
        double rets = height;

        double nowHeight = height;
        for (int i = 0; i < count - 1; i++) {
            nowHeight = nowHeight / 2;
            rets += nowHeight * 2;
        }
        System.out.println(nowHeight / 2);
        return rets;

    }
}
