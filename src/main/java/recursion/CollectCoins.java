package recursion;

public class CollectCoins {

    private static char[][] arr = {{'E', 'C', 'C', 'C', 'C'},
            {'C', '#', 'C', '#', 'E'},
            {'#', 'C', 'C', '#', 'C'},
            {'C', 'E', 'E', 'C', 'E'},
            {'C', 'E', '#', 'C', 'E'}
    };

    private static int rows = arr.length - 1;
    private static int cols = arr[0].length - 1;

    public static void main(String[] args) {

        int startx = 0;
        int starty = 0;

        int endx = rows;
        int endy = cols;

        collectCoins(arr, startx, starty, endx, endy, arr[startx][starty] == 'E' ? 0 : 1, 1);
        System.out.println("max coins : " + max);
    }

    private static int max = 0;
    private static int dirs = 2;
    private static int[] x1Dirs = {0, 1};
    private static int[] y1Dirs = {1, 0};

    private static int[] x2Dirs = {0, 1};
    private static int[] y2Dirs = {-1, 0};

    private static void collectCoins(char[][] arr, int i, int j, int endx, int endy, int coins, int dir) {

        if (coins > max) {
            max = coins;
        }

        if (dir == 1) {
            for (int k = 0; k < dirs; k++) {
                int row = i + x1Dirs[k];
                int col = j + y1Dirs[k];

                if (row >= 0 && row <= rows && col >= 0 && col <= cols && arr[row][col] != '#') {
                    collectCoins(arr, row, col, endx, endy, coins + (arr[row][col] == 'C' ? 1 : 0), k == 0 ? 1 : 0);
                }
            }
        } else {
            for (int k = 0; k < dirs; k++) {
                int row = i + x2Dirs[k];
                int col = j + y2Dirs[k];

                if (row >= 0 && row <= rows && col >= 0 && col <= cols && arr[row][col] != '#') {
                    collectCoins(arr, row, col, endx, endy, coins + (arr[row][col] == 'C' ? 1 : 0), k == 0 ? 0 : 1);
                }
            }
        }
    }
}
