package algorithm.leetcode.easy;

public class Swimming {
    public static void main(String[] args) {
        System.out.println(getSteps(4.3,2));

    }
    public static int getSteps (double meters, double firstStep) {
        int rets = 1;
        double all = firstStep;
        double nowStep = firstStep;
        while (all <  meters) {
            rets += 1;
            all += nowStep;
            nowStep = nowStep * 0.98;
        }

        return rets;

    }
}
