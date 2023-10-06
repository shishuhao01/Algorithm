package dateStruct.stack.singleStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaximumRectangularArea {
    public static void main(String[] args) {
        int[] arr = {0,1,0};
        System.out.println(max(arr));

    }
    public static int max (int[] arr) {
        int[] nums = new int[arr.length + 2];
        int index = 1;
        nums[0] = 0;
        nums[nums.length - 1] = 0;
        for (int i = 0; i < arr.length;i++) {
            nums[index++] = arr[i];
        }
        System.out.println(Arrays.toString(nums));

        Stack<Integer> stack = new Stack<>();
        int rets = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                       int temp = stack.pop();
                       if (stack.isEmpty()) {
                           rets = Math.max(rets,(i - temp + 1) * nums[temp]);
                           break;
                       } else {
                           rets = Math.max (rets,(i - stack.peek() - 1) * nums[temp]);
                       }
                }
                stack.push(i);
            }
        }

        return rets;

    }
}
