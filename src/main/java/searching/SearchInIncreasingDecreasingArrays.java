package searching;

public class SearchInIncreasingDecreasingArrays {

    // Increasing and decreasing
    private static int[] array1 = {10, 9, 7, 6};

    // decreasing and then increasing
    private static int[] array2 = {10, 9, 8};

    private static int length1 = array1.length;
    private static int length2 = array2.length;

    public static void main(String[] args) {

        System.out.println("pivot is : " + findPivotInIncreasingDecreasingArray(0, length1 - 1));

        System.out.println("pivot is : " + findPivotInDecreasingIncreasingArray(0, length2 - 1));
    }

    private static int findPivotInDecreasingIncreasingArray(int start, int end) {

        if (start <= end) {

            if (start == end)
                return array2[start];

            int mid = start + (end - start) / 2;

            if (array2[mid - 1] > array2[mid] && array2[mid + 1] > array2[mid])
                return array2[mid];

            if (array2[mid - 1] > array2[mid] && array2[mid + 1] < array2[mid])
                return findPivotInDecreasingIncreasingArray(mid + 1, end);

            if (array2[mid - 1] < array2[mid] && array2[mid + 1] > array2[mid])
                return findPivotInDecreasingIncreasingArray(start, mid - 1);

        }

        return -1;

    }

    private static int findPivotInIncreasingDecreasingArray(int start, int end) {

        if (start <= end) {

            if (start == end)
                return array1[start];

            if (start + 1 == end && array1[start] < array1[end])
                return array1[end];

            if (start + 1 == end && array1[start] > array1[end])
                return array1[start];

            int mid = start + (end - start) / 2;

            if (array1[mid - 1] < array1[mid] && array1[mid + 1] < array1[mid])
                return array1[mid];
            if (array1[mid - 1] < array1[mid] && array1[mid + 1] > array1[mid])
                return findPivotInIncreasingDecreasingArray(mid + 1, end);
            if (array1[mid - 1] > array1[mid] && array1[mid + 1] < array1[mid])
                return findPivotInIncreasingDecreasingArray(start, mid - 1);

        }

        return -1;

    }

}
