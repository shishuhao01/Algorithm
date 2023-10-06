package dateStruct.stack.singleStack;

import java.util.Stack;

public class ReceivingRainwater {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,0,1};
        System.out.println(receivingRainwater(arr));

    }
    public static int receivingRainwater (int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int rets = 0;
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                    int temp = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    } else {
                        int height = Math.min(arr[stack.peek()], arr[i]);
                        rets += (i - stack.peek() - 1) * (height - arr[temp]);
                    }
                }
                stack.push(i);
            }
        }
        return rets;





    }
}
