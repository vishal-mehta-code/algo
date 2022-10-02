package array;

public class MaxOnesInARow {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}, {0, 0, 0, 0}};
        int rows = grid.length;
        int maxNoOfOnes = 0;
        int rowWithMaxOnes = -1;

        for (int i = 0; i < rows; i++) {

            int[] row = grid[i];
            int length = row.length;

            int index = findIndex(row, 0, length - 1);

            int noOfOnesInARow = 0;
            if (index > -1) {
                noOfOnesInARow = length - index;
                if (noOfOnesInARow > maxNoOfOnes) {
                    maxNoOfOnes = noOfOnesInARow;
                    rowWithMaxOnes = i;
                }
            }

            System.out.println("no of ones in the row : " + noOfOnesInARow);

        }

        System.out.println("maxNoOfOnes : " + maxNoOfOnes);
        System.out.println("rowWithMaxOnes : " + rowWithMaxOnes);
    }

    /**
     * Find index of first 1. If there is no ones in the row then return -1.
     */
    private static int findIndex(int[] array, int start, int end) {

        if (start <= end) {
            if (start == end) {
                return array[start] == 1 ? start : -1;
            } else if (start + 1 == end) {
                return array[start] == 1 ? start : array[end] == 1 ? end : -1;
            } else {

                int mid = start + (end - start) / 2;
                if (array[mid] == 0) {
                    if (array[mid + 1] == 1) {
                        return mid + 1;
                    } else {
                        return findIndex(array, mid + 1, end);
                    }
                } else {
                    if (array[mid - 1] == 0) {
                        return mid;
                    } else {
                        return findIndex(array, start, mid - 1);
                    }
                }
            }
        }

        return -1;
    }
}
