package dp;

public class NoOfInsertionsToCreateAPalindrome {

    public static void main(String[] args) {
        System.out.println("no of insertions to create a palindrome : "
                + noOfInsertionsToCreateAPalindrome("aaacbcaa".toCharArray()));
    }

    private static int noOfInsertionsToCreateAPalindrome(char[] str) {
        int n = str.length;
        int[][] p = new int[n][n];

        for (int gap = 1; gap < n; gap++) {
            for (int l = 0; l < n - gap; l++) {
                int h = l + gap;

                if (str[l] == str[h]) {
                    p[l][h] = p[l + 1][h - 1];
                } else {
                    p[l][h] = Math.min(p[l + 1][h], p[l][h - 1]) + 1;
                }
            }
        }
        return p[0][n - 1];
    }
}
