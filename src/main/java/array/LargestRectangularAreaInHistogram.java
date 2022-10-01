package array;

public class LargestRectangularAreaInHistogram {

	public static void main(String[] args) {
		int[] array = { 6, 2, 5, 4, 5, 1, 6 };

		largestArea(array);
	}

	private static void largestArea(int[] array) {
		int max = 0;

		for (int i = 0; i < array.length; i++) {

			int j = i, k = i;

			while (j > 0 && array[j - 1] >= array[i]) {
				j--;
			}
			while (k < array.length - 1 && array[k + 1] >= array[i]) {
				k++;
			}

			int area = array[i];

			if (j != i) {
				area = area + (i - j) * array[i];
			}
			if (k != i) {
				area = area + (k - i) * array[i];
			}

			if (area > max) {
				max = area;
			}

		}

		System.out.println("max area : " + max);
	}
}
