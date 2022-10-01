package heap;

public class KthLargeSmall {

	public static void main(String[] args) {
		int[] array = { 1, 13, 15, 4, 2 };
		int k = 4;
		System.out.println("kth smallest : " + findKthSmallUsingMinHeap(array, k));
		System.out.println("kth smallest : " + findKthSmallUsingMaxHeap(array, k));
		System.out.println("kth largest : " + findKthLargestUsingMinHeap(array, k));
		System.out.println("kth largest : " + findKthLargestUsingMaxHeap(array, k));
	}

	private static int findKthLargestUsingMaxHeap(int[] array, int k) {
		int[] maxHeapArray = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			maxHeapArray[i] = array[i];
		}

		createMaxHeap(maxHeapArray, array.length);

		for (int i = 1; i < k; i++) {
			maxHeapArray[0] = Integer.MIN_VALUE;
			maxHeapify(maxHeapArray, 0);
		}

		return maxHeapArray[0];
	}

	private static int findKthLargestUsingMinHeap(int[] array, int k) {
		int[] minHeapArray = new int[k];

		for (int i = 0; i < k; i++) {
			minHeapArray[i] = array[i];
		}

		createMinHeap(minHeapArray, k);

		for (int i = k; i < array.length; i++) {
			if (array[i] > minHeapArray[0]) {
				minHeapArray[0] = array[i];
				minHeapify(minHeapArray, 0);
			}
		}

		return minHeapArray[0];
	}

	/**
	 * Approach is to create a max heap of k elements which takes O(k) time and O(k) space. Now iterate for rest (n - k)
	 * elements. If a bigger element then root is found then ignore otherwise replace root with the element and max
	 * heapify again which would take O(logk) time. hence the overall solution is going to cost O(k + (n - k)logk)
	 */
	private static int findKthSmallUsingMaxHeap(int[] array, int k) {
		int[] minHeapArray = new int[k];

		for (int i = 0; i < k; i++) {
			minHeapArray[i] = array[i];
		}

		createMaxHeap(minHeapArray, k);

		for (int i = k; i < array.length; i++) {
			if (array[i] < minHeapArray[0]) {
				minHeapArray[0] = array[i];
				maxHeapify(minHeapArray, 0);
			}
		}

		return minHeapArray[0];
	}

	private static void createMaxHeap(int[] array, int n) {
		int i = (n - 2) / 2;

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

	/**
	 * Approach is to create a min heap in O(n) time and O(n) space and then for k times replace the root with max_value
	 * and then min heapify which takes O(logn) time. overall solution takes O (n + klogn) time.
	 */
	private static int findKthSmallUsingMinHeap(int[] array, int k) {
		int[] minHeapArray = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			minHeapArray[i] = array[i];
		}

		createMinHeap(minHeapArray, minHeapArray.length);

		for (int i = 1; i < k; i++) {
			minHeapArray[0] = Integer.MAX_VALUE;
			minHeapify(minHeapArray, 0);
		}

		return minHeapArray[0];
	}

	private static void createMinHeap(int[] array, int n) {
		int i = (n - 2) / 2;
		while (i >= 0) {
			minHeapify(array, i);
			i--;
		}
	}

	private static void minHeapify(int[] array, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int s = i;

		if (l < array.length && array[l] < array[s]) {
			s = l;
		}
		if (r < array.length && array[r] < array[s]) {
			s = r;
		}

		if (s != i) {
			swap(array, s, i);
			minHeapify(array, s);
		}
	}

	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}
