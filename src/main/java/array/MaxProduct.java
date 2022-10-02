package array;

public class MaxProduct {

    private static int[] array = {2, -8, -4, -10};
    private static int length = array.length;

    public static void main(String[] args) {
        System.out.println("max product : " + getMaxProduct(0, length));

    }

    private static int getMaxProduct(int start, int end) {
        int currmin = 1, currmax = 1, max = 1;
        for (int i = 0; i < end; i++) {
            if (array[i] == 0) {
                currmin = 0;
                currmax = 0;
            } else if (array[i] > 0) {
                currmax = currmax * array[i];
                currmin = Math.min(currmin * array[i], 1);
            } else {
                int tmpMax = currmax;
                currmax = Math.max(currmin * array[i], 1);
                currmin = Math.min(1, tmpMax * array[i]);
            }

            if (currmax > max)
                max = currmax;

        }

        return max;

    }
}
