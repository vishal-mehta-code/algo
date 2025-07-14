package array;

public class OnceInArray {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 2, 3, 3, 4, 4};
        System.out.println("missing in a sorted array  : " + onceInSortedArray(array1, 0, array1.length - 1));

        int[] array2 = {1, 2, 1, 1};
        onceInUnsortedArray(array2);
    }

    private static void onceInUnsortedArray(int[] array2) {

        // Initialize result
        int result = 0;

        int x, sum;
        // Iterate through every bit
        for (int i = 0; i < 32; i++) {
            // Find sum of set bits at ith position in all
            // array elements
            sum = 0;
            x = (1 << i);
            for (int j = 0; j < array2.length; j++) {
                if ((array2[j] & x) > 0)
                    sum++;
            }

            // The bits with sum not multiple of 3, are the
            // bits of element with single occurrence.
            if ((sum % 3) > 0)
                result |= x;
        }

        System.out.println(result);

    }

    /**
     * Given a sorted array in which all elements appear twice (one after one) and one element appears only once. Find that element in O(log n) complexity.
     */
    private static int onceInSortedArray(int[] array, int start, int end) {
        if (start <= end) {
            if (start == end) {
                return array[start];
            }

            int mid = start + (end - start) / 2;

            if (array[mid] != array[mid - 1] && array[mid] != array[mid + 1]) {
                return mid;
            }

            if (array[mid] == array[mid + 1]) {
                if (mid % 2 == 0) {
                    return onceInSortedArray(array, mid + 2, end);
                }
                return onceInSortedArray(array, start, mid - 1);
            } else if (array[mid] == array[mid - 1]) {
                if (mid % 2 == 0) {
                    return onceInSortedArray(array, start, mid - 2);
                }
                return onceInSortedArray(array, mid + 1, end);
            }
        }
        return -1;

    }

}
