package misc;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    public static void main(String[] args) {
        int[][] array = {{1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}};

        int rows = array.length;
        int cols = array[0].length;

        // We need to start from 0s that are not visited
        int totalHouses = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == 1) {
                    totalHouses++;
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == 0) {
                    int d = bfs(array, rows, cols, i, j, totalHouses);
                    minDistance = Math.min(minDistance, d);
                }
            }
        }

        System.out.println(minDistance);
    }

    private static int bfs(int[][] array, int rows, int cols, int i, int j, int totalHouses) {
        boolean[][] visited = new boolean[rows][cols];

        int[] xDirs = {0, 0, -1, 1};
        int[] yDirs = {-1, 1, 0, 0};

        int steps = 0;
        int d = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        int noOfHousesVisited = 0;

        while (!queue.isEmpty() && noOfHousesVisited < totalHouses) {
            for (int k = queue.size(); k > 0; k--) {
                int[] currPos = queue.poll();

                if (array[currPos[0]][currPos[1]] == 1) {
                    noOfHousesVisited++;
                    d += steps;
                    continue;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int currRow = currPos[0] + xDirs[dir];
                    int currCol = currPos[1] + yDirs[dir];

                    if (currRow >= 0 && currRow < rows && currCol >= 0 && currCol < cols && !visited[currRow][currCol] && array[currRow][currCol] != 2) {
                        visited[currRow][currCol] = true;
                        queue.add(new int[]{currRow, currCol});
                    }
                }
            }

            steps++;
        }

        if (noOfHousesVisited == totalHouses) {
            return d;
        } else {
            return Integer.MAX_VALUE;
        }
    }
}
