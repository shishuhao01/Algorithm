package algorithm.Character;

public class LongestPalindromicSubstring {
    //判断最长回文串
    public static void main(String[] args) {
        String s ="fewvbabacababvgwrvcsdcxbvc";


        System.out.println(maxLength2(s));

    }
    public static char[] mString (String s) {
        char[] arr = s.toCharArray();
        char[] rets = new char[2 * arr.length + 1];
        int index = 0;
        for (int i = 0; i < rets.length; i++) {
            if (i % 2 == 0) {
                rets[i] = '#';
            } else {
                rets[i] = arr[index++];
            }
        }
        return rets;
    }

//    public static int maxLength (String str) {
//        if (str == null || str.length() == 0) {
//            return 0;
//        }
//        char[] arr = mString(str);
//        int[] pArr = new int[arr.length]; //回文半径数组
//        int R = -1;
//        int C = -1;
//        int rets = Integer.MIN_VALUE;
//        for (int i = 0; i < pArr.length; i++) {
//            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
//            while (i + pArr[i] < arr.length && i - pArr[i] > -1) {
//                if (arr[i + pArr[i]] == arr[i - pArr[i]]) {
//                    pArr[i] ++;
//                } else {
//                    break;
//                }
//            }
//            if (i + pArr[i] > R) {
//                R = i + pArr[i];
//                C = i;
//            }
//            rets = Math.max(rets,pArr[i]);
//        }
//        return rets - 1;
//    }


//    public static int maxLength2 (String str) {
//        if (str == null || str.length() == 0) {
//            return 0;
//        }
//        char[] arr = mString(str);
//        int[] pArr = new int[arr.length]; //回文半径数组
//        int R = -1;
//        int C = -1;
//        int rets = Integer.MIN_VALUE;
//        for (int i = 0; i < pArr.length; i++) {
//            if (R <= i) {
//                int j = 0;
//                while (j + i < arr.length && i - j > -1) {
//                    if (arr[i + j] == arr[i - j]) {
//                        j++;
//                    } else {
//                        break;
//                    }
//                }
//                if (R < i + j) {
//                    R = j + i - 1;
//                    C = i;
//                }
//                pArr[i] = j - 1;
//                rets = Math.max(rets,pArr[i]);
//            } else {
//                if (pArr[C - (i - C)] < (R - i)) {
//                    pArr[i] = pArr[C - (i - C)];
//                } else if (pArr[C - (i - C)] > (R - i)) {
//                    pArr[i] = (R - i);
//                } else if (pArr[C - (i - C)] == (R - i)) {
//                    int j = R - i;
//                    while (j + i < arr.length && i - j > -1) {
//                        if (arr[i + j] == arr[i - j]) {
//                            j++;
//                        } else {
//                            break;
//                        }
//                    }
//                    if (R < i + j) {
//                        R = j + i - 1;
//                        C = i;
//                    }
//                    pArr[i] = j - 1;
//                }
//                rets = Math.max(rets, pArr[i]);
//            }
//        }
//        System.out.println(Arrays.toString(pArr));
//        return rets ;
//
//
//    }

    public static int maxLength2 (String s) {
        char[] str = mString(s);
        int[] pArr = new int[str.length];// 半径圆数组
        int C = -1;
        int R = -1;
        int rets = Integer.MIN_VALUE;


        for (int i = 0; i < str.length; i++) {
            if (R <= i) {
                int j = 0;
                while (i + j < str.length && i - j > -1) {
                    if (str[i + j]  == str[i - j]) {
                        j++;
                    } else {
                        break;
                    }
                }
                if (R < i + j - 1) {
                    R  = i + j -1;
                    C = i;
                }
                pArr[i] = j - 1;
                rets = Math.max(rets,pArr[i]);
            } else {
                if (pArr[C - (i - C)] < (R - i)) {
                    pArr[i] = pArr[C - (i - C)];
                } else if (pArr[C -(i - C)] > (R - i)) {
                    pArr[i] = (R - i);
                } else if (pArr[C - (i - C)] == (R- i)) {
                    int j = 0;
                    while (j + i < str.length && i - j > -1) {
                        if (str[i + j] == str[i - j]) {
                            j++;
                        } else {
                            break;
                        }
                    }
                    if (R < i + j - 1) {
                        R = i + j - 1;
                        C = i;
                    }
                    pArr[i] = j - 1;
                }
                rets = Math.max(rets, pArr[i]);
            }
        }
        return rets;
    }





























}
