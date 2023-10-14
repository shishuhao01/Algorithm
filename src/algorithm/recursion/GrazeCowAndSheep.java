package algorithm.recursion;

public class GrazeCowAndSheep {
    public static void main(String[] args) {


    }
    public static String win (int n) {
        // 0   1  2    3    4
        // 后  先  后   先   先
        if (n < 5) {
            return (n == 0 || n == 1) ? "后手":"先手";
        }
        int base = 0;
        while (base <= n) {
            //先手从1,4,16,64一个一个试 都赢不了后手赢  先手先吃base在下一个环节是后手，如果返回的是后手则先手赢，如果不是后手赢
            if (win(n - base).equals("后手")) {
                return "先手";
            }
            if (base > n/4) {//防止溢出
                break;
            }
            base *= 4;
        }
        return "后手";
    }

    //打表法
    public static String best (int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "后手";
        } else {
            return "先手";
        }
    }







}
