package algorithm.Character;

public class KmpAlgorithm {
    public static void main(String[] args) {
        String str1 = "aaabaaabbbbaa";

        String str2 = "abcda";
        int[] next = KmpNext(str2);
        System.out.println(kmpSearch(str1,str2,next));


    }

    public static int kmpSearch (String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;

    }

    public static int[] KmpNext (String dest) {
          int[] next = new int[dest.length()];
          for (int i = 1,j = 0; i < next.length; i++) {
              while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                  j = next[j - 1];
              }
              if (dest.charAt(i) == dest.charAt(j)) {
                  j++;
              }
              next[i] = j;
          }
          return next;


    }
}
