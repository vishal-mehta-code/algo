package searching;

public class Search2DSortedArray {

    public static void main(String[] args) {
        int[][] mat = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50},};

        search(mat, 15);
    }

    private static void search(int[][] mat, int item) {
        int m = mat.length;
        int n = mat[0].length;

        int i = 0;
        int j = n - 1;

        while (i < m && j >= 0) {
            if (mat[i][j] == item) {
                System.out.println("found at row : " + i + " column : " + j);
                break;
            }
            if (mat[i][j] > item)
                j--;
            else
                i++;
        }
    }
}
