package array;

public class MaxSum {

	private static int[] array = { 12, -2, 6, 5, 4 };
	// private static int[] array = { 1, 2, 3, -1, 6, -1, 1, 0, 0, -19 };
	// private static int[] array = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
	// private static int[] array = {-6,-2,-3,-4,-1,-5,-5};

	private static int length = array.length;

	public static void main(String[] args) {
		kadane();
	}

	public static void kadane() {

		int maxStart = 0;
		int maxEnd = 0;
		int max = Integer.MIN_VALUE;

		int localstart = 0;
		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum = sum + array[i];

			if (sum < 0) {
				sum = 0;
				localstart = i + 1;
			} else if (sum > max) {
				max = sum;
				maxStart = localstart;
				maxEnd = i;
			}

		}

		System.out.println("Max sum         : " + max);
		System.out.println("Max start index : " + maxStart);
		System.out.println("Max end index   : " + maxEnd);
	}
}
