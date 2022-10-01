package recursion;

public class MaxNoBySwapping {

	private static String str = "7599";
	private static String max = str;
	private static int k = 2;

	public static void main(String[] args) {
		maxNoBySwapping(str.toCharArray(), 0, 0, 0);
		System.out.println("max is : " + max);
	}

	private static void maxNoBySwapping(char[] str, int i, int j, int swaps) {
		if (new String(str).compareTo(max) > 0) {
			max = new String(str);
		}

		if (swaps == k) {
			return;
		}

		for (int p = 0; p < str.length - 1; p++) {
			for (int q = p + 1; q < str.length; q++) {
				if (str[p] < str[q]) {
					swap(str, p, q);
					maxNoBySwapping(str, p, q, swaps + 1);
					swap(str, p, q);
				}
			}
		}

	}

	private static void swap(char[] str, int i, int j) {
		char tmp = str[i];
		str[i] = str[j];
		str[j] = tmp;
	}
}
