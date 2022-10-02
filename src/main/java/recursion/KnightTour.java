package recursion;

public class KnightTour {

    // Matrix size
    private static int N = 8;

    private static int[][] sol = new int[N][N];

    public static void main(String[] args) {

        // initialize solution matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }

        // since the knight is initially at this position
        sol[0][0] = 0;

        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        if (knightTour(0, 0, xMove, yMove, sol, 1)) {
            System.out.println("Sol exists");
            printSolution();
        } else {
            System.out.println("no sol exists");
        }

    }

    private static void printSolution() {

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                sb.append(sol[i][j] + " ");
            }
            sb.append("\n");
            System.out.println(sb.toString());
        }

    }

    private static boolean knightTour(int x, int y, int[] xMove, int[] yMove, int[][] sol, int moveI) {
        if (moveI == N * N) {
            return true;
        }

        for (int i = 0; i < N; i++) {

            int nextX = x + xMove[i];
            int nextY = y + yMove[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && sol[nextX][nextY] == -1) {

                sol[nextX][nextY] = moveI;

                if (knightTour(nextX, nextY, xMove, yMove, sol, moveI + 1)) {
                    return true;
                } else {
                    sol[nextX][nextY] = -1;
                }

            }

        }

        return false;
    }

}
