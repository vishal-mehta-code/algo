package array;

public class SpiralPrinting {

    private static int[][] array = {{1, 2, 3},
            {9, 10, 11},
            {13, 14, 15},
            {16, 17, 18}};

    public static void main(String[] args) {
        printJalebi();
    }

    private static void printJalebi() {
        int lowx = 0;
        int lowy = 0;

        int highx = array.length - 1;
        int highy = array[0].length - 1;

        while (lowx <= highx && lowy <= highy) {

            for (int i = lowy; i <= highy; i++) {
                System.out.println(array[lowx][i]);
            }
            lowx++;

            for (int i = lowx; i <= highx; i++) {
                System.out.println(array[i][highy]);
            }
            highy--;

            for (int i = highy; i >= lowy; i--) {
                System.out.println(array[highx][i]);
            }
            highx--;

            for (int i = highx; i >= lowx; i--) {
                System.out.println(array[i][lowy]);
            }
            lowy++;
        }

    }

}
