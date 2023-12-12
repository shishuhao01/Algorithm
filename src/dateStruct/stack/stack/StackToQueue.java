package dateStruct.stack.stack;

import java.util.Stack;

public class StackToQueue {
    /**
     * 用栈实现队列
     */
    private Stack<Integer> stackIn = new Stack<>();
    private Stack<Integer> stackOut = new Stack<>();

    public void push (int a) {
        stackIn.push(a);
    }

    public int pop() {
        if (!stackOut.isEmpty()) {
            return stackOut.pop();
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        if (stackOut.isEmpty()) {
            System.out.println("栈没有元素了");
            throw new RuntimeException("没有了");
        }
        return stackOut.pop();

    }



}
