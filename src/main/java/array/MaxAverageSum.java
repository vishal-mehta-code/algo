package array;

public class MaxAverageSum {

	private static int arr[] = { 1, 12, -5, -6, 50, 3, 52 };
	private static int n = arr.length;
	private static int k = 4;
	private static int[] cumSum = new int[n];

	public static void main(String[] args) {

		cumSum[0] = arr[0];
		for (int i = 1; i < n; i++) {
			cumSum[i] = cumSum[i - 1] + arr[i];
		}

		int max = cumSum[k - 1];
		int maxIndex = 0;

		for (int i = k; i < n; i++) {
			if (cumSum[i] - cumSum[i - k] > max) {
				max = cumSum[i] - cumSum[i - k];
				maxIndex = i - k + 1;
			}
		}

		System.out.println("max is :  " + max);
		System.out.println("max index  is :  " + maxIndex);
	}
}
