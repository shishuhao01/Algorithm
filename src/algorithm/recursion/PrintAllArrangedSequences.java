package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllArrangedSequences {
    // 打印一个字符串的所有可能的序列 abc  acb bac bca cab cba
    public static void main(String[] args) {
        String s = "abca";
        List<String> list = Permutation(s);
        for (String i:list){
            System.out.println(i);
        }

    }
    public static ArrayList<String> Permutation (String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        char[] rets = str.toCharArray();
        process(rets,0,list);
        return list;
    }

    public static void process (char[] str, int i, ArrayList<String> list) {
        if (i == str.length) {
            list.add(String.valueOf(str));
            return ;
        }
        boolean[] isVisited = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!isVisited[str[j] - 'a']) {
                isVisited[str[j] - 'a'] = true;
                swap(str, i, j);
                process(str, i + 1, list);
                swap(str, j, i);
            }
        }

    }

    public static void swap (char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

}
