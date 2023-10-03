package dateStruct.queue.Deque;


import java.util.Arrays;
import java.util.LinkedList;

public class deques {
    //双端队列，黑盒问题  滑动窗口为3记录每个窗口的最大值
    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        System.out.println(Arrays.toString(getMaxWindow(arr,3)));

    }
    //important！！！
    public static int[] getMaxWindow (int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        //使用一个双端队列
        int[] rets = new int[arr.length - w + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) { // 保持队列的头是最大值 而且之后的是下标在其后面，且值小
                queue.pollLast();
            }
            queue.add(i);
            if (queue.peekFirst() == i - w) { //证明下标过期了，需要弹出
                queue.pollFirst();
            }
            if (i >= w - 1) { //形成窗口
                rets[index++] = arr[queue.peekFirst()];
            }
        }
        return rets;
    }
}
