package array;

/**
 * Given an array of integers and a number x, find the smallest sub array with sum greater than the given value.
 */
public class SmallestSubWithSum {

	private static final int[] arr = { 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 };
	private static final int sum = 280;

	public static void main(String[] args) {
		int min = Integer.MAX_VALUE;

		int start = 0, end = 0, cumsum = 0;
		while (end < arr.length) {

			while (cumsum <= sum && end < arr.length) {
				cumsum = cumsum + arr[end++];
			}

			while (cumsum > sum && start < arr.length) {
				if (end - start < min) {
					min = end - start;
				}

				cumsum = cumsum - arr[start++];
			}
		}

		System.out.println("min is : " + min);
	}

}
