package array;

/**
 * Maximum difference between two elements such that larger element appears after the smaller number.
 */
public class MaxPositiveDiff {

	private static int[] array = { -1, 5, 6, 9, 3, 10 };

	public static void main(String[] args) {
		findMaxPositiveDiff();
	}

	private static void findMaxPositiveDiff() {
		int max_diff = array[1] - array[0];
		int min_so_far = array[0];

		for (int i = 1; i < array.length; i++) {
			if (array[i] - min_so_far > max_diff) {
				max_diff = array[i] - min_so_far;
			}
			if (array[i] < min_so_far) {
				min_so_far = array[i];
			}
		}

		System.out.println("max diff : " + max_diff);
	}

}
