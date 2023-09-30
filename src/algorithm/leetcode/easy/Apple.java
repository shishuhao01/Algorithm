package algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.Scanner;

public class Apple {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] arr = new int[3];
//        for (int i = 0; i < 3; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        System.out.println("请输入身高");
//        int height = scanner.nextInt();
//        System.out.println(getApple(height+30,arr));


        System.out.println(is("race a car"));
    }
//    public static int getApple (int height, int[] arr) {
//        int rets = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (height > arr[i]) {
//                rets ++;
//            }
//        }
//        return rets;
//    }

    public static boolean is (String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        char[] c = s.toCharArray();
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] > 'A' && c[i] < 'Z') {
                c[i] += 32;
            }
            if ((c[i] > 'a' && c[i] < 'z') || (c[i] > '0' && c[i] < '9')) {
                len ++;
            }
        }
        char[] rets = new char[len];
        len = 0;
        for (int i = 0; i < c.length; i++) {
            if ((c[i] > 'A' && c[i] < 'Z') || (c[i] > 'a' && c[i] < 'z') || (c[i] > '0' && c[i] < '9')) {
                rets[len++] = c[i];
            }
        }
        for (int i = 0 , j = rets.length - 1; i < rets.length / 2; i++,j--) {
            if (rets[i] != rets[j]) {
                return false;
            }
        }
        return true;

    }
}
