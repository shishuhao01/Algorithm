package algorithm.leetcode.easy;

public class ReverseCharacter {
    public static void main(String[] args) {
        System.out.println(isReverseCharacter("zxcvbnnbvcxz"));
    }
    public static boolean isReverseCharacter (String str) {
        for (int l = 0, r = str.length() - 1; l < str.length() / 2; l ++, r--) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
        }
        return true;



    }
}
