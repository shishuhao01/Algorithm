package algorithm.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintAllSubsequences {
    public static void main(String[] args) {
        String s = "abc";
//        process(s.toCharArray(), 0, new ArrayList<Character>());
        process2(s.toCharArray(),0);
    }

    //第一种方法
    // 当前来到i位置，要和不要，走两条路
    // res之前的选择 所形成的列表
    public static void process (char[] str, int i, List<Character> res) {
        if (i == str.length) {
            printList(res);
            return;
        }
        List<Character> Need = copy(res);
        Need.add(str[i]);
        process(str,i+1,Need);  //要当前字符串
        List<Character> noNeed = copy(res);
        process(str,i+1,noNeed); //不要当前字符串
    }
    // 打印字符
    public static void printList (List<Character> res) {
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
        }
        System.out.println();
    }
    public static List<Character> copy(List<Character> list) {
        List<Character> rets = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            rets.add(list.get(i));
        }
        return rets;
    }






    // 第二种方法
    public static void process2 (char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
            return;
        }
        process2(str,i + 1); //要这个字符串
        char temp = str[i];
        str[i] = ' ';
        process2(str,i+1);   //不要这个字符串
        str[i] = temp;
    }

}
