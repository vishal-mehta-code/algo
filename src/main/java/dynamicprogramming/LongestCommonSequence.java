package dp;

public class LongestCommonSequence {

    public static void main(String[] args) {
        String str1 = "abcabcaa";
        String str2 = "acbacba";

        System.out.println(longestCommonSequence(str1, str2));
    }

    private static int longestCommonSequence(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int m = s1.length;
        int n = s2.length;

        int[][] lcs = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if (s1[i - 1] == (s2[j - 1])) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }
        return lcs[m][n];
    }
}
