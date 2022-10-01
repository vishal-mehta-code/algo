package dp;

public class LongestEditDistance {

	public static void main(String[] args) {
		String str1 = "saturday";
		String str2 = "sunday";
		System.out.println("longest edit distance : " + longestEditDistance(str1.toCharArray(), str2.toCharArray()));
	}

	private static int longestEditDistance(char[] str1, char[] str2) {
		int n = str1.length;
		int m = str2.length;
		int[][] LED = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0) {
					LED[i][j] = j;
				} else if (j == 0) {
					LED[i][j] = i;
				} else if (str1[i - 1] == str2[j - 1]) {
					LED[i][j] = LED[i - 1][j - 1];
				} else {
					LED[i][j] = Math.min(LED[i - 1][j - 1], Math.min(LED[i][j - 1], LED[i - 1][j])) + 1;
				}
			}
		}

		return LED[n][m];
	}
}
