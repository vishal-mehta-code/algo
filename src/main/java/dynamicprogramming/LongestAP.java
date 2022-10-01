package dp;

public class LongestAP {

	public static void main(String[] args) {
		int array[] = { 4, 7, 10, 13, 27, 29 };
		lap(array);
	}

	private static void lap(int[] array) {
		int n = array.length;

		boolean[][] LAP = new boolean[n][n];
		int maxLenth = 2;
		int maxStart = 0;

		// for length = 1
		for (int i = 0; i < n; i++) {
			LAP[i][i] = true;
		}

		// for length = 2
		for (int i = 1; i < n; i++) {
			LAP[i - 1][i] = true;
		}

		// for length >= 3
		for (int k = 3; k <= n; k++) {
			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;

				if (LAP[i + 1][j - 1] == true) {
					if (array[i] + (array[i + 1] - array[i]) * (k - 1) == array[j]) {
						LAP[i][j] = true;

						if (k > maxLenth) {
							maxLenth = k;
							maxStart = i;
						}
					}
				}
			}
		}

		System.out.println("max start : " + maxStart + " max length : " + maxLenth);
	}

}
