package algorithm.leetcode.mid;

public class KuoHao {
    //只有（） 问一个至少需要多少个括号才能正确
    public static void main(String[] args) {

    }


    public static int get(char[] s) {

        int count = 0;
        int answer = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') {
                count ++;
            } else {
                if (count == 0) {
                    answer += 1;
                } else {
                    count --;
                }
            }
        }
        return answer + count;




    }




}
