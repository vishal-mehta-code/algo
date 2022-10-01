package array;

import java.util.Arrays;

/**
 * We are given two sorted array. We need to merge these two arrays such that the initial numbers (after complete sorting) are in the first array and the remaining numbers are in the second array.
 * Extra space allowed in O(1).
 *
 */
public class MergeSortedArrays {

	private static int[] array1 = { 1, 5, 7, 15 };
	private static int[] array2 = { 2, 4, 6, 8, 9, 11 };

	public static void main(String[] args) {
		mergeSortedArrays();
	}

	private static void mergeSortedArrays() {

		for (int i = 0; i < array1.length; i++) {
			if (array1[i] > array2[0]) {
				int tmp = array1[i];
				array1[i] = array2[0];
				array2[0] = tmp;

				int k = 0;

				while (k + 1 < array2.length && array2[k + 1] < array2[0]) {
					k++;
				}

				if (k > 0) {
					moveElements(array2, k);
				}
			}
		}

		System.out.println("array1 : " + Arrays.toString(array1));
		System.out.println("array2 : " + Arrays.toString(array2));
	}

	private static void moveElements(int[] array, int k) {
		int tmp = array[0];

		for (int i = 0; i < k; i++) {
			array[i] = array[i + 1];
		}

		array[k] = tmp;
	}
}
