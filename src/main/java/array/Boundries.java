package array;

public class Boundries {

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 4, 4, 4};
        int i1 = getLastIndex(array, 0, array.length - 1, array[0]);
        int i2 = getLastIndex(array, i1 + 1, array.length - 1, array[i1 + 1]);
        System.out.println("{" + i1 + "," + i2 + "}");
    }

    private static int getLastIndex(int[] array, int start, int end, int k) {
        // There should be at least two elements.
        if (start < end) {
            if (start + 1 == end) {
                return start;
            }

            int mid = start + (end - start) / 2;

            if (array[mid] == k) {
                if (array[mid + 1] != k) {
                    return mid;
                } else {
                    return getLastIndex(array, mid + 1, end, k);
                }
            } else {
                if (array[mid - 1] == k) {
                    return mid - 1;
                } else {
                    return getLastIndex(array, start, mid - 1, k);
                }
            }
        }

        return -1;
    }
}
