package dateStruct.stack.stack;

import java.util.Queue;
import java.util.LinkedList;

public class QueueToStack {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    Queue<Integer> temp = new LinkedList<Integer>();

    public void push(int a) {
        queue1.offer(a);
    }

    public int pop() {
        if (queue1.size() == 0) {
            throw new RuntimeException("队列没有元素");
        }
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
        int res = queue1.poll();
        queue1 = queue2;
        queue2 = new LinkedList<Integer>();
        return res;
    }


}
