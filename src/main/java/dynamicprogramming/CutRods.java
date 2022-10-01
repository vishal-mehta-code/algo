package dp;

public class CutRods {

	public static void main(String[] args) {
		int maxValue = 0;
		int[] array = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int n = array.length;
		int[] val = new int[n + 1];

		val[0] = 0;

		for (int i = 1; i <= n; i++) {
			int max = 0;

			for (int j = 0; j < i; j++) {
				max = Math.max(max, val[j] + array[i - j - 1]);
			}

			val[i] = max;

			if (max > maxValue) {
				maxValue = max;
			}
		}

		System.out.println(maxValue);
	}
}
