package dp;

public class LongestPalindrome {

	public static void main(String[] args) {
		System.out.println(findLongestPalindrome("forgeeksskeegfor"));

	}

	private static String findLongestPalindrome(String str) {

		char[] array = str.toCharArray();
		int n = array.length;
		boolean[][] LP = new boolean[n][n];
		int maxLength = 1;
		int startIndex = 0;

		// all sub strings of length == 1 are palindrome
		for (int i = 0; i < n; i++) {
			LP[i][i] = true;
		}

		// check for all substrings of length == 2
		for (int i = 0; i < n - 1; i++) {
			if (array[i] == array[i + 1]) {
				startIndex = i;
				LP[i][i + 1] = true;
				maxLength = 2;
			}
		}

		// check for all substrings of length >= 3
		for (int k = 3; k <= n; k++) {

			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;

				if (LP[i + 1][j - 1] == true && array[i] == array[j]) {

					LP[i][j] = true;

					if (k > maxLength) {
						maxLength = k;
						startIndex = i;
					}
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		for (int i = startIndex; i < startIndex + maxLength; i++) {
			builder.append(array[i]);
		}

		return builder.toString();
	}
}
