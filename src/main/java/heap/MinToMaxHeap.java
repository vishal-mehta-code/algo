package heap;

import java.util.Arrays;

public class MinToMaxHeap {

	public static void main(String[] args) {
		int[] array = { 3, 5, 9, 6, 8, 20, 10, 12, 18, 9 };
		buildMaxHeap(array);
		System.out.println(Arrays.toString(array));
	}

	private static void buildMaxHeap(int[] array) {
		int i = (array.length - 2) / 2;

		while (i >= 0) {
			maxHeapify(array, i);
			i--;
		}
	}

	private static void maxHeapify(int[] array, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int b = i;

		if (l < array.length && array[l] > array[b]) {
			b = l;
		}
		if (r < array.length && array[r] > array[b]) {
			b = r;
		}

		if (b != i) {
			swap(array, b, i);
			maxHeapify(array, b);
		}
	}

	private static void swap(int[] array, int b, int i) {
		int tmp = array[b];
		array[b] = array[i];
		array[i] = tmp;
	}
}
