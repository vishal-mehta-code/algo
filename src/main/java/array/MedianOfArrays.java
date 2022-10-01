package array;

public class MedianOfArrays {

	private static int ar1[] = { 1, 5, 7, 9 };
	private static int ar2[] = { 2, 4, 6, 10 };

	public static void main(String[] args) {
		System.out.println("Median is : " + findMedian(0, ar1.length - 1, 0, ar2.length - 1, ar1.length));
	}

	private static int findMedian(int s1, int e1, int s2, int e2, int n) {

		if (n == 1) {
			return (ar1[s1] + ar2[s2]) / 2;
		}
		if (n == 2) {
			return (Math.max(ar1[s1], ar2[s2]) + Math.min(ar1[e1], ar2[e2])) / 2;
		}

		int m1 = median(ar1, n);
		int m2 = median(ar2, n);

		if (m1 == m2) {
			return m1;
		}

		if (m1 < m2) {
			return findMedian(n % 2 == 0 ? n / 2 - 1 : n / 2, e1, s2, n / 2, n % 2 == 0 ? n / 2 : n / 2 + 1);
		}

		return findMedian(s1, n % 2 == 0 ? n / 2 - 1 : n / 2, n / 2, e2, n % 2 == 0 ? n / 2 : n / 2 + 1);
	}

	private static int median(int[] array, int n) {
		if (n % 2 == 0)
			return (array[n / 2 - 1] + array[n / 2]) / 2;

		return array[n / 2];
	}
}
