package algorithm.recursion;

import java.util.Stack;

public class ReverseStack {
    //递归 解决不用其他数据结构实现逆序栈
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }


    }
    //取栈最底部的元素
    public static int R (Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
             int last = R (stack);
             stack.push(result);
             return last;
        }
    }

    public static void Reverse (Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return ;
        }
        int temp = R(stack);
        Reverse(stack);
        stack.push(temp);
    }
}
