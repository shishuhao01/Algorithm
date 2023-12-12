package dateStruct.stack.stack;

import java.util.Stack;

public class myStack {
    private Stack<Integer> date = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    /**
     * 实现一个特殊的栈结构，在实现栈的基本功能上面，再实现返回最小的元素的操作
     * 1.pop、push、getMin时间复杂度都是O(1)  2.可以使用现有的栈
     */
    public void push(int number) {
        date.push(number);
        if (min.isEmpty()) {
            min.push(number);
            return;
        }
        if (number < min.peek()) {
            min.push(number);
        } else {
            min.push(min.peek());
        }
    }


    public int pop() {
        min.pop();
        return date.pop();
    }

    public int getMin() {
        if (min.isEmpty()) {
            System.out.println("栈内还没有元素");
            throw new RuntimeException("空指针");
        }
        return min.peek();
    }

}
