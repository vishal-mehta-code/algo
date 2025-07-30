package dp;

public class MaxIncreasingSequence {

    private static int[] array = {1, 4, 2, 3, 5, 6, 4};
    private static int length = array.length;

    public static void main(String[] args) {
        maxIncreasingSequence();
    }

    private static void maxIncreasingSequence() {
        int max = Integer.MIN_VALUE;
        int[] lsi = new int[length];

        for (int i = 0; i < length; i++) {
            lsi[i] = 1;
        }

        for (int i = 0; i < length - 1; i++) {
            for (int j = i; j < length; j++) {
                if (array[j] > array[i] && lsi[j] < lsi[i] + 1) {
                    lsi[j] = lsi[i] + 1;
                }

                if (lsi[j] > max)
                    max = lsi[j];
            }
        }

        System.out.println("length of max increasing sequence is : " + max);

    }
}
