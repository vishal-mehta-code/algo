package heap;

import java.util.Arrays;

/**
 * Following are the steps : a) Create k MinHeapNodes by taking first element from k arrays b) Create min heap c) Iterate
 * from 0 to k * n) In each iteration pick the min in the heap e) Replace the min node by next element from the same
 * array f) Min heapify g) If there the corresponding array ended then add Integer max value
 */
public class SortKArrays {

    public static final class MinHeapNode {
        public int element;
        public int i;
        public int j;

        public MinHeapNode(int element, int i, int j) {
            super();
            this.element = element;
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "MinHeapNode [element=" + element + ", i=" + i + ", j=" + j + "]";
        }

    }

    private static int[][] arr = {{2, 6, 12, 34}, {2, 9, 20, 1000}, {2, 2000, 2500, 3000}, {1, 15, 25, 30}};
    private static int k = 4;
    private static int n = 4;

    private static int[] output = new int[n * k];

    public static void main(String[] args) {

        MinHeapNode[] minHeapNodesArray = new MinHeapNode[k];

        for (int i = 0; i < k; i++) {
            MinHeapNode minHeapNode = new MinHeapNode(arr[i][0], i, 1);
            minHeapNodesArray[i] = minHeapNode;
        }

        createMinHeap(minHeapNodesArray, k);

        for (int i = 0; i < k * n; i++) {

            MinHeapNode root = minHeapNodesArray[0];

            output[i] = root.element;

            if (root.j < n) {
                root.element = arr[root.i][root.j];
                root.j = root.j + 1;
            } else {
                root.element = Integer.MAX_VALUE;
            }

            System.out.println(Arrays.toString(minHeapNodesArray));

            minHeapify(minHeapNodesArray, 0);
        }

        System.out.println(Arrays.toString(output));

    }

    private static void createMinHeap(MinHeapNode[] minHeapNodesArray, int k) {
        int i = (k - 2) / 2;
        while (i >= 0) {
            minHeapify(minHeapNodesArray, i);
            i--;
        }
    }

    private static void minHeapify(MinHeapNode[] minHeapNodesArray, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int s = i;

        if (l < k && minHeapNodesArray[l].element < minHeapNodesArray[s].element)
            s = l;
        if (r < k && minHeapNodesArray[r].element < minHeapNodesArray[s].element)
            s = r;

        if (s != i) {
            swap(minHeapNodesArray, i, s);
            minHeapify(minHeapNodesArray, s);
        }
    }

    private static void swap(MinHeapNode[] minHeapNodesArray, int i, int s) {
        MinHeapNode temp = minHeapNodesArray[i];

        minHeapNodesArray[i] = minHeapNodesArray[s];
        minHeapNodesArray[s] = temp;

    }

}
