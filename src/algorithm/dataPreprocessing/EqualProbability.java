package algorithm.dataPreprocessing;

public class EqualProbability {
    // 一个函数，等概率1-5，怎么等概率1-7

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.print(get3059()+" ");

        }

    }


    //等概率返回1-5的函数
    public static int f15() {
        return (int) (Math.random() * 5) + 1;
    }

    //先等概率返回0-1
    public static int get01 () {
        int rets = 0;
        do {
            rets = f15();
        }while (rets == 3);
        return rets < 3 ? 0 : 1;
    }


    //将1-2返回为1-7 加三次 0-7需要3个二进制位
    //已经得到1个二进制位
    public static int get17() {
        int rets = 0;
        do {
            rets = (get01() << 2) +(get01() << 1) + get01();
        }while (rets == 7);
            return rets + 1;
    }

    //以p概率0（1-p)概率1
    //弄两次，如果是01 和10 才算，其他情况概率不同，01 代表0,10代表1；OK



    //同理给你13-21 现将其分为两部分，13-16,17-20
    public static int set1321() {
        return (int) (Math.random() * 9) + 13;
    }
    public static int set21() {
        int rets = 0;
        do {
            rets = set1321();
        }while (rets == 21);
        return rets <= 16 ? 0 : 1;
    }

    public static int get3059() {
        // 0 - 29 需要5位
        int rets = 0;
        do{
            rets = (set21() << 4) +(set21() << 3)+(set21() << 2)+(set21() << 1)+set21();
        }while (rets == 30 || rets == 31);
        return rets + 30;
    }







}
