package array;

import sorting.QuickSort;

public class TripletsSum {

	private static int[] array = { 2, 3, -3, 5, 6, -2, -4 };
	private static int sum = 0;

	public static void main(String[] args) {
		findTripletsWithSum();
	}

	private static void findTripletsWithSum() {
		QuickSort.sort(array);

		int n = array.length - 1;
		for (int i = 0; i <= n; i++) {

			int j = i + 1;
			int k = n;

			while (j < k) {
				if (array[i] + array[j] + array[k] == sum) {
					System.out.println(i + " : " + j + " : " + k);
					break;
				} else if (array[i] + array[j] + array[k] > sum) {
					k--;
				} else {
					j++;
				}
			}
		}
	}
}
