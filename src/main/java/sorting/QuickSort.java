package sorting;

import java.util.Arrays;

public class QuickSort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {1, 6, 2, 6};
        sort(array);

        // After sort
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        if (start < end) {
            int p = partition(array, start, end);

            sort(array, start, p - 1);
            sort(array, p + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int x = array[end], i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (array[j] < x) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
