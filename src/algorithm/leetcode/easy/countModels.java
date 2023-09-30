package algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.Scanner;

public class countModels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入天数");
        int days = scanner.nextInt();
        System.out.println(Arrays.toString(getModels(days)));

    }
    public static int[] getModels (int days) {
        int[] rets = new int[3];
        Scanner scanner = new Scanner(System.in);
        while (days != 0) {
            System.out.println("请输入第"+days+"金牌数");
            int gold = scanner.nextInt();
            System.out.println("请输入第"+days+"银牌数");
            int silver = scanner.nextInt();
            System.out.println("请输入第"+days+"铜牌数");
            int tong = scanner.nextInt();
            rets[0] += gold;
            rets[1] += silver;
            rets[2] += tong;
            days -= 1;
        }
        return rets;




    }
}
