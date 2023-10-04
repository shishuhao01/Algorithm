package algorithm.recursion;

public class Transition {
    // 111 可以 转化为 AA1 AAA 1AA KA     K = 11   问一个字符只有数字有多少种转化
    // 和爬梯问题相似
    public static void main(String[] args) {
        String s = "11";
        System.out.println(process(s.toCharArray(),0));

    }
    public static int process (char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (str[i] == '0') {
            return 0;
        }

        if (str[i] == '1') {
            int rets = process(str,i + 1); //自己算成一个字母
            if (i + 1 < str.length) {
                rets += process(str,i + 2); //自己算成一个字母加上下一个字母 算出结果
            }
            return rets;
        }

        if (str[i] == '2') {
            int rets = process(str,i + 1);
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                rets += process(str,i + 2);
            }
            return rets;
        }
        // i== 3 ~ 9 无法和其他组成字母 的情况
        return process(str,i + 1);

    }
}
