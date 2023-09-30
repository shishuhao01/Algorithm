package algorithm.leetcode.easy;

import java.util.Scanner;

public class Mate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入字符串");
        String str = scanner.next();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A') {
                stringBuilder.append('G');
            } else if (str.charAt(i) == 'G') {
                stringBuilder.append('A');
            }else if (str.charAt(i) == 'U'){
                stringBuilder.append('C');
            }else {
                stringBuilder.append('U');
            }
        }
        System.out.println(stringBuilder);


    }
}
