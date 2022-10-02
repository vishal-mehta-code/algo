package searching;

public class SearchInRotatedArrays {

    private static int[] array = {5, 7, 8, 9, 1, 2, 3, 4};
    private static int length = array.length;

    public static void main(String[] args) {

        System.out.println("max is : " + findMax(0, length));
        System.out.println("min is : " + findMin(0, length));

    }

    private static int findMin(int start, int end) {

        if (start <= end) {

            if (start == end)
                return array[start];
            if (start + 1 == end)
                return array[start] > array[end] ? array[end] : array[start];

            int mid = start + (end - start) / 2;

            if (array[mid - 1] > array[mid])
                return array[mid];

            if (array[start] > array[mid])
                return findMin(start, mid - 1);

            if (array[mid] > array[start])
                return findMin(mid + 1, end);

        }
        return -1;
    }

    private static int findMax(int start, int end) {

        if (start <= end) {
            if (start == end)
                return array[start];
            if (start + 1 == end)
                return array[start] > array[end] ? array[start] : array[end];

            int mid = start + (end - start) / 2;

            if (array[mid + 1] < array[mid])
                return array[mid];

            if (array[start] > array[mid])
                return findMax(start, mid - 1);

            if (array[mid] > array[start])
                return findMax(mid + 1, end);
        }

        return -1;
    }

}
