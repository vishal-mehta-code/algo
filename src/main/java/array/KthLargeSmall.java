package array;

public class KthLargeSmall {

    private static int[] array = {1, 3, 5, 4, 2};
    private static int k = 2;

    public static void main(String[] args) {
        System.out.println(k + "nd smallest is :  " + array[getKthSmallInArray(0, array.length - 1)]);
        System.out.println(k + "nd large is : " + array[getKthLargeInArray(0, array.length - 1)]);
    }

    private static int getKthLargeInArray(int start, int end) {

        if (start <= end) {
            int p = partition(start, end);

            if (array.length - p == k)
                return p;

            if (array.length - p > k)
                return getKthLargeInArray(p + 1, end);

            return getKthLargeInArray(start, p - 1);
        }

        return -1;

    }

    private static int getKthSmallInArray(int start, int end) {

        if (start <= end) {
            int p = partition(start, end);

            if (p + 1 == k) {
                return p;
            }

            if (p + 1 < k)
                return getKthSmallInArray(p + 1, end);

            return getKthSmallInArray(start, p - 1);

        }

        return -1;
    }

    private static int partition(int start, int end) {
        int x = array[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (array[j] < x) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, end);
        return i + 1;

    }

    private static void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
