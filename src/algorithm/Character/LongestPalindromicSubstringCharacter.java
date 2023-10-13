package algorithm.Character;

public class LongestPalindromicSubstringCharacter {
    //这个是求最长子序列
    //同Monacher算法一样，这次是将最大的圈记录在一个变量里面，若还有比他大的值，则覆盖掉这个变量
    public static void main(String[] args) {
        System.out.println(monacher("baaaaaac"));

    }
    public static String monacher (String s) {
            char[] str = getChar(s);
            StringBuilder s1 = new StringBuilder();
            int[] pArr = new int[str.length];// 半径圆数组
            int C = -1;
            int C1 = 0;
            int R1 = 0;
            int R = -1;
            int rets = 0;
            for (int i = 0; i < str.length; i++) {
                if (R <= i) {
                    int j = 0;
                    while (i + j < str.length && i - j > -1 && str[i + j] == str[i - j]) {
                        j++;
                    }
                    if (R < i + j - 1) {
                        R  = i + j -1;
                        C = i;
                    }
                    pArr[i] = j - 1;
                    if (rets <= pArr[i]) {
                        C1 = i;
                        R1 = pArr[i];
                        rets = pArr[i];
                    }
                } else {
                    if (pArr[C - (i - C)] < (R - i)) {
                        pArr[i] = pArr[C - (i - C)];
                    } else if (pArr[C -(i - C)] > (R - i)) {
                        pArr[i] = (R - i);
                    } else if (pArr[C - (i - C)] == (R- i)) {
                        int j = 0;
                        while (i + j < str.length && i - j > -1 && str[i + j] == str[i - j]) {
                            j++;
                        }
                        if (R < i + j - 1) {
                            R = i + j - 1;
                            C = i;
                        }
                        pArr[i] = j - 1;
                        if (rets <= pArr[i]) {
                            C1 = i;
                            R1 = pArr[i];
                            rets = pArr[i];
                        }
                    }
                }
            }
            int  k = C1 - R1;
            for (int i = k; i < C1 + pArr[C1] ;i++) {
                if (str[i] != '#') {
                    s1.append(str[i]);
                }
            }
            return new String(s1);
        }


        public static   char[] getChar (String s) {
            char[] rets = new char[s.length() * 2 + 1];
            int index = 0;
            for (int i = 0; i < rets.length; i++) {
                if (i % 2 != 0) {
                    rets[i] = s.charAt(index++);
                } else {
                    rets[i] = '#';
                }
            }
            return rets;
        }

}
