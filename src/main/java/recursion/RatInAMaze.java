package recursion;

public class RatInAMaze {

    private static int[][] maze = {{1, 1, 1, 1},
            {0, 1, 1, 0},
            {1, 0, 1, 1},
            {0, 1, 1, 1}};

    private static int startx = 0;
    private static int starty = 0;

    private static int rows = maze.length;
    private static int cols = maze[0].length;

    private static int endx = rows - 1;
    private static int endy = cols - 1;

    private static int[][] sol = new int[rows][cols];

    private static int[] xDirs = {0, -1, 0, 1};
    private static int[] yDirs = {-1, 0, 1, 0};

    public static void main(String[] args) {
        if (findAPath(startx, starty)) {
            printSol();
        } else {
            System.out.println("no path exists");
        }
    }

    private static boolean findAPath(int i, int j) {
        sol[i][j] = 1;

        if (i == endx && j == endy) {
            return true;
        }

        for (int k = 0; k < 4; k++) {
            int row = i + xDirs[k];
            int col = j + yDirs[k];

            if (row >= 0 && row < rows && col >= 0 && col < cols && maze[row][col] == 1 && sol[row][col] == 0) {
                if (findAPath(row, col)) {
                    return true;
                } else {
                    sol[row][col] = 0;
                }
            }
        }

        return false;
    }

    private static void printSol() {
        StringBuilder builder = new StringBuilder("printing sol");
        builder.append("\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                builder.append(sol[i][j]);
                builder.append(" ");
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }

}
