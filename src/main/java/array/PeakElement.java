package array;

public class PeakElement {

    public static void main(String[] args) {
        int[] array = {1, 3, 20, 4, 1, 0, 7};

        System.out.println("peak element is : " + peakElement(array, 0, array.length - 1));
    }

    private static int peakElement(int[] array, int start, int end) {

        if (start > end) {
            return -1;
        }
        if (start == end) {
            return array[start];
        }

        if (start + 1 == end) {
            return array[start] > array[end] ? array[start] : array[end];
        }

        int mid = start + (end - start) / 2;

        if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
            return array[mid];
        }
        if (array[mid] < array[mid - 1]) {
            return peakElement(array, start, mid - 1);
        }
        return peakElement(array, mid + 1, end);
    }

}
