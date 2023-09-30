package algorithm.leetcode.easy;

import java.util.Scanner;

public class Mate2 {
    public static void main(String[] args) {
        System.out.println("请输入要匹配多少个字符");
        Scanner scanner = new Scanner(System.in);
        double count = scanner.nextDouble();

        System.out.println("请输入字符串1");
        String s1 = scanner.next();
        System.out.println("请输入字符串2");
        String s2 = scanner.next();
        System.out.println(getResult(count, s1, s2));

    }
    public static boolean getResult (double count, String s1, String s2) {
        double k = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (i == s2.length()) {
                break;
            }else {
                if (s1.charAt(i) == s2.charAt(i)) {
                    k++;
                }
            }
        }
        double rets = k / s1.length();
        System.out.println(rets);
        if (rets > count) {
            return true;
        } else {
            return false;
        }
    }
}
