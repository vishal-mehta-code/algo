package array;

import java.util.Arrays;

public class SmallestMissing {

	public static void main(String[] args) {
		int[] array1 = { 1, 4, 2, 6, 5, 9, 7, 8 };
		System.out.println("smallest missing in an unsorted array of positive numbers : "
				+ smallestMissingInUnsortedArrayWithPositiveElements(array1));

		int[] array2 = { -1, 4, 2, 6, 5, -9, 7, -8 };
		System.out.println("smallest missing in an unsorted array of negative and positive numbers : "
				+ smallestMissingInUnsortedArray(array2));

		int[] array3 = { 0, 2, 3 };
		System.out.println("smallest missing in a sorted array : "
				+ smallestMissingInSortedArray(array3, 0, array3.length - 1));
	}

	private static int smallestMissingInSortedArray(int[] array, int start, int end) {
		if (start > end) {
			return end + 1;
		}

		if (start != array[start]) {
			return start;
		}

		int mid = start + (end - start) / 2;
		if (array[mid] == mid) {
			return smallestMissingInSortedArray(array, mid + 1, end);
		}
		return smallestMissingInSortedArray(array, start, mid - 1);
	}

	
	private static int smallestMissingInUnsortedArrayWithPositiveElements(int[] array) {
		int length = array.length;

		for (int i = 0; i < length; i++) {
			if (Math.abs(array[i]) - 1 < length && array[Math.abs(array[i]) - 1] > 0) {
				array[Math.abs(array[i]) - 1] = -array[Math.abs(array[i]) - 1];
			}
		}

		for (int i = 0; i < length; i++) {
			if (array[i] > 0) {
				return i + 1;
			}
		}

		return length + 1;
	}

	private static int smallestMissingInUnsortedArray(int[] array) {
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] <= 0) {
				if (j != i) {
					swap(array, j, i);
				}
				j++;
			}
		}
		
		if (j == array.length) {
			return 1;
		} 
		return smallestMissingInUnsortedArrayWithPositiveElements(Arrays.copyOfRange(array, j, array.length));
	}

	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
