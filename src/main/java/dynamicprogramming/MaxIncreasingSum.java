package dp;

public class MaxIncreasingSum {

    private static int[] array = {1, 101, 2, 3, 100, 4, 5};
    private static int length = array.length;

    private static int[] tbl = new int[length];
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        for (int i = 0; i < length; i++) {
            tbl[i] = array[i];
        }

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[j] > array[i] && tbl[j] < tbl[i] + array[j]) {
                    tbl[j] = tbl[i] + array[j];

                    if (tbl[j] > max) {
                        max = tbl[j];
                    }
                }
            }
        }
        System.out.println("max is : " + max);
    }
}
