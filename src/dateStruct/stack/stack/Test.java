package dateStruct.stack.stack;

import algorithm.leetcode.easy.Queue;

public class Test {
    public static void main(String[] args) {
//        StackToQueue stackToQueue = new StackToQueue();
//        stackToQueue.push(1);
//        stackToQueue.push(2);
//        stackToQueue.push(3);
//        stackToQueue.push(4);
//        stackToQueue.push(5);
//        System.out.println(stackToQueue.pop());
//        stackToQueue.push(6);
//        System.out.println(stackToQueue.pop());
//        System.out.println(stackToQueue.pop());
//        System.out.println(stackToQueue.pop());
//        System.out.println(stackToQueue.pop());
//        System.out.println(stackToQueue.pop());
//        System.out.println(stackToQueue.pop());

        QueueToStack queueToStack = new QueueToStack();
        queueToStack.push(1);
        queueToStack.push(2);
        queueToStack.push(3);
        queueToStack.push(4);
        queueToStack.push(5);

        System.out.println(queueToStack.pop());
        System.out.println(queueToStack.pop());
        queueToStack.push(6);
        System.out.println(queueToStack.pop());






    }
}
