package algorithm.recursion;

public class Hanluota {
    //汉罗塔问题
    public static void main(String[] args) {
        hanluta(3);

    }
    public static void func (int i, String start, String end, String other) {
        if (i == 1) {
            System.out.println("Move 1 from  " + start +"  to  " +end);
        } else {
            // 第一步 先把 1 ~ i -1 的圆盘从 from 移到 other 去
            func(i - 1, start, other, end);
            // 第二步将 i 从 from 移到 end 去
            System.out.println("Move " + i + " from  " + start + "  to  " +end);
            // 第三步将 i - 1 从 other 移到 end去
            func(i - 1, other, end, start);
        }
    }

    public static void hanluta (int n) {
        if (n > 0) {
            func(n,"左","中","右");
        }
    }
}
