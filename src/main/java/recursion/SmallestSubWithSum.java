package recursion;

public class SmallestSubWithSum {

	private static final int[] arr = { 1, 10, 5, 2, 7 };
	private static final int sum = 9;

	public static void main(String[] args) {
		smallestSubWithSum(0, arr.length - 1, 0, 0);
		System.out.println("min is : " + min);
	}

	static int min = Integer.MAX_VALUE;

	private static void smallestSubWithSum(int start, int end, int tmpsum, int n) {
		if (tmpsum > sum) {
			if (n < min) {
				min = n;
			}
			return;
		}

		for (int i = start; i <= end; i++) {
			smallestSubWithSum(start + 1, end, tmpsum + arr[i], n + 1);
		}
	}
}
