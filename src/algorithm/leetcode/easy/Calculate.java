package algorithm.leetcode.easy;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        int length = (a+"").length();
        int rets = 0;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                rets +=  a % 10 ;
            }else {
                rets +=  a / (Math.pow(10,i)) % 10 ;
            }

        }
        System.out.println(rets);

    }
}
