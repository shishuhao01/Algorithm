package algorithm.leetcode.easy;

import java.util.Scanner;

public class Pharmacy {
    public static void main(String[] args) {
//        System.out.println(getPharmacy());
        // 遍历字符串
        String str = "abcsdhbvjhwedbvfjhsdfvfdf";
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
    }

    public static int getPharmacy () {

        Scanner scanner = new Scanner(System.in);
        int rets = 0;
        System.out.println("请输入总药数");
        int have = scanner.nextInt();

        System.out.println("请输入看病的病人的人数");
        int number = scanner.nextInt();
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            int a = scanner.nextInt();
            if (a > have) {
                rets ++;
                continue;
            }else {
                have -= a;
            }
        }
        return rets;





    }
}
