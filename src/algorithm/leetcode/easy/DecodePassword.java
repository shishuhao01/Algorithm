package algorithm.leetcode.easy;

import java.util.Scanner;

public class DecodePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(decode(str));

    }
    public static String decode (String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                if (chars[i] == 'a') {
                    chars[i] = 'z';
                } else {
                    chars[i]--;
                }
            }else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                if (chars[i] == 'A') {
                    chars[i] = 'Z';
                } else {
                    chars[i]--;
                }
            }
        }

        String rets = new String(chars);
        return rets;

    }
}
