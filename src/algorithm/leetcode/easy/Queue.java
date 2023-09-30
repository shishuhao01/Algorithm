package algorithm.leetcode.easy;
import java.util.Arrays;
import java.util.Scanner;

public class Queue {
    public static void main(String[] args) {

       lineUp();
    }
    public static void lineUp () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入学生的数目");
        int number = scanner.nextInt();
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = scanner.nextInt();
        }
        int odd = 0;
        int even = 0;
        for (int i = 0; i < number; i++) {
            if (arr[i] % 2 == 1) {
                odd++;
            }else {
                even++;
            }
        }

        int[] arr1 = new int[odd];
        int[] arr2 = new int[even];

        odd = 0;
        even = 0;
        QuickSort(arr,0,arr.length - 1);
        reverse(arr);

        for (int i = 0; i < number; i++) {
            if (arr[i] % 2 == 0) {
                arr1[odd++] = arr[i];
            }else {
                arr2[even++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }


    public static void QuickSort (int[] arr, int left, int right) {
        int temp = arr[(left + right) / 2];
        int l = left;
        int r = right;
        while (l < r) {
            while (arr[l] < temp) {
                l++;
            }
            while (arr[r] > temp) {
                r--;
            }
            if (l == r) {
                break;
            }
            int k = arr[l];
            arr[l] = arr[r];
            arr[r] = k;
            if (arr[l] == temp) {
                r--;
            }
            if (arr[r] == temp) {
                l++;
            }
        }
        if (l < right) {
            QuickSort(arr,l + 1, right);
        }
        if (r > left) {
            QuickSort(arr,left,r - 1);
        }


    }

    public static void reverse (int[] arr) {
        int r = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
            r --;
        }
    }
}
