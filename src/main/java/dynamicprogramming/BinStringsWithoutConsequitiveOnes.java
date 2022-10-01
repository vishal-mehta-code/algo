package dp;

/**
 * http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
 */
public class BinStringsWithoutConsequitiveOnes {

	public static void main(String[] args) {
		int n = 3;

		int[] a = new int[n];
		int[] b = new int[n];

		a[0] = b[0] = 1;

		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] + b[i - 1];
			b[i] = a[i - 1];
		}

		System.out.println(a[n - 1] + b[n - 1]);
	}
}
