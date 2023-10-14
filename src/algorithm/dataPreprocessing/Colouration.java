package algorithm.dataPreprocessing;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class Colouration {
    //给定一个染好色的数组，只有R和G两种颜色 规定左边只能染成R，右边只能染成G，最少染多少个
    public static void main(String[] args) {
        String[] color = {"R","G","R"};
        System.out.println(minimal(color));

    }
    public static int minimal (String[] color) {
        int[] RedRight = new int[color.length];
        int[] GreenLeft = new int[color.length];
        GreenLeft[0] = color[0] == "G"? 1:0 ;
        RedRight[color.length - 1] = color[color.length - 1] == "R" ? 1:0;
        //对数据进行预处理，要不然会成n平方复杂度
        for (int i = 1; i < color.length; i++) {
            //找左边有多少个G，要染成R
            if(color[i] == "G") {
                GreenLeft[i] = GreenLeft[i - 1] + 1;
            } else {
                GreenLeft[i] = GreenLeft[i - 1];
            }
        }
        for (int j = color.length - 2; j >= 0; j--) {
            //找右边有多个R，染成G
            if (color[j] == "R") {
                RedRight[j] = RedRight[j + 1] + 1;
            } else {
                RedRight[j] = RedRight[j + 1];
            }
        }
        System.out.println("左边染R"+Arrays.toString(GreenLeft));
        System.out.println("右边染G"+Arrays.toString(RedRight));

        int[] colorReturn = new int[color.length];
        int rets = 999;
        int k = 0;
        //for循环，遍历每一个点将左右分开，进行判断
        for (int i = 0; i < color.length ; i++) {
            if (i == colorReturn.length - 1) {
                colorReturn[i] = GreenLeft[i - 1] + RedRight[i];
            }else {
                colorReturn[i] = GreenLeft[i] + RedRight[i + 1];
            }
            if (rets > colorReturn[i] ) {
                rets = colorReturn[i];
                k = i ;
            }

        }
        System.out.println(Arrays.toString(colorReturn));
        System.out.println("在下标"+k);
        return rets;






    }
}
