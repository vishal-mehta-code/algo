package heap;

import java.util.Arrays;

/**
 * Following are the steps : a) Create k + 1 MinHeapNodes by taking the first k + 1 elements from the array b) Create
 * min heap c) Iterate over array i = k + 1 d) get min heap and keep on replacing the array elements e) If i have
 * reached n then extract min from heap (get min and reduce the size of heap)
 */
public class SortNearlySortedArray {

	public static final class MinHeapNode {

		private int element;

		public MinHeapNode(int element) {
			super();
			this.element = element;
		}

		public int getElement() {
			return element;
		}

		@Override
		public String toString() {
			return "MinHeapNode [element=" + element + "]";
		}

	}

	private static int k = 3;
	private static int heapsize = k + 1;
	private static int[] arr = { 2, 6, 3, 12, 56, 8 };
	private static int n = arr.length;
	private static MinHeapNode[] minHeapNodesArray = new MinHeapNode[k + 1];

	public static void main(String[] args) {

		for (int i = 0; i <= k; i++) {
			MinHeapNode minHeapNode = new MinHeapNode(arr[i]);
			minHeapNodesArray[i] = minHeapNode;
		}

		createHeap(minHeapNodesArray, heapsize);

		int count = 0;
		for (int i = k + 1; i < n; i++) {

			arr[count++] = minHeapNodesArray[0].getElement();

			minHeapNodesArray[0].element = arr[i];
			minHeapify(minHeapNodesArray, 0);
		}

		// Get rest of the elements from the heap.
		for (int i = 0; i <= k; i++) {
			arr[count++] = minHeapNodesArray[0].getElement();
			minHeapNodesArray[0].element = Integer.MAX_VALUE;
			minHeapify(minHeapNodesArray, 0);
		}

		System.out.println("array is : " + Arrays.toString(arr));
	}

	private static void createHeap(MinHeapNode[] minHeapNodesArray, int heapsize) {
		int i = (heapsize - 2) / 2;
		while (i >= 0) {
			minHeapify(minHeapNodesArray, i);
			i--;
		}
	}

	private static void minHeapify(MinHeapNode[] minHeapNodesArray, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int s = i;

		if (l < heapsize && minHeapNodesArray[l].getElement() < minHeapNodesArray[s].getElement())
			s = l;

		if (r < heapsize && minHeapNodesArray[r].getElement() < minHeapNodesArray[s].getElement())
			s = r;

		if (s != i) {
			swap(i, s);
			minHeapify(minHeapNodesArray, s);
		}

	}

	private static void swap(int i, int s) {

		MinHeapNode tmp = minHeapNodesArray[i];

		minHeapNodesArray[i] = minHeapNodesArray[s];
		minHeapNodesArray[s] = tmp;
	}
}
