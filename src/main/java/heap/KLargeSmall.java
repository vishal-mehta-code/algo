package heap;

import java.util.Arrays;

public class KLargeSmall {

    public static void main(String[] args) {
        int[] array = {1, 13, 15, 4, 2};
        int k = 3;
        findKLarge(array, k);
        findKSmall(array, k);
    }

    private static void findKSmall(int[] array, int k) {
        int[] maxHeap = new int[k];

        for (int i = 0; i < k; i++) {
            maxHeap[i] = array[i];
        }

        createMaxHeap(maxHeap, k);

        for (int i = k; i < array.length; i++) {
            if (array[i] < maxHeap[0]) {
                maxHeap[0] = array[i];
                maxHeapify(maxHeap, 0);
            }
        }

        System.out.println("k small are : " + Arrays.toString(maxHeap));
    }

    private static void createMaxHeap(int[] maxHeap, int k) {
        int i = (k - 2) / 2;
        while (i >= 0) {
            maxHeapify(maxHeap, i);
            i--;
        }

    }

    private static void maxHeapify(int[] maxHeap, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int b = i;

        if (l < maxHeap.length && maxHeap[l] > maxHeap[b]) {
            b = l;
        }
        if (r < maxHeap.length && maxHeap[r] > maxHeap[b]) {
            b = r;
        }

        if (b != i) {
            swap(maxHeap, b, i);
            maxHeapify(maxHeap, b);
        }

    }

    private static void findKLarge(int[] array, int k) {
        int[] minHeap = new int[k];

        for (int i = 0; i < k; i++) {
            minHeap[i] = array[i];
        }

        createMinHeap(minHeap, k);

        for (int i = k; i < array.length; i++) {
            if (array[i] > minHeap[0]) {
                minHeap[0] = array[i];
                minHeapify(minHeap, 0);
            }
        }

        System.out.println("k large are : " + Arrays.toString(minHeap));
    }

    private static void createMinHeap(int[] minHeap, int k) {
        int i = (k - 2) / 2;
        while (i >= 0) {
            minHeapify(minHeap, i);
            i--;
        }
    }

    private static void minHeapify(int[] minHeap, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int s = i;

        if (l < minHeap.length && minHeap[l] < minHeap[s]) {
            s = l;
        }
        if (r < minHeap.length && minHeap[r] < minHeap[s]) {
            s = r;
        }

        if (s != i) {
            swap(minHeap, s, i);
            minHeapify(minHeap, s);
        }

    }

    private static void swap(int[] minHeap, int i, int j) {
        int tmp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = tmp;
    }

}
