package algorithm.leetcode.easy;

import java.util.HashMap;

public class K {
    //给一个数组，去除插值为K的几对
    public static void main(String[] args) {

    }
    public static int getKey (int[] arr) {
        HashMap<Integer, Integer> ins = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            ins.put(arr[i], arr[i]);
        }
        int rets = 0;
        for (Integer key : ins.keySet()) {
            if (ins.containsKey(key+2) ) {
                rets++;
            }
            if (ins.containsKey(key-2)) {
                rets++;
            }
        }
        return rets;


    }


}
