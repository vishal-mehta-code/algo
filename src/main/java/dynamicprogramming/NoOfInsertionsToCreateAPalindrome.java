package dp;

public class NoOfInsertionsToCreateAPalindrome {

    public static void main(String[] args) {
       String s = "aaacbcaa";
       String r = new StringBuilder(s).reverse().toString();
       int n = lcs(s, r, s.length());
       System.out.println(s.length() - n);
    }

    private static int lcs(String s, String r, int n) {
        int[][] lcs = new int[n+1][n+1];

        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if (s.charAt(i-1) == r.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        return lcs[n][n];
    }
}
