package recursion;

import java.util.HashSet;
import java.util.Set;

public class Boggle {

    private static int m = 3;
    private static int n = 3;
    private static String[][] boggle = {{"G", "I", "Z"}, {"U", "E", "K"}, {"Q", "S", "E"}};
    private static boolean[][] visited = new boolean[m][n];
    private static Set<String> dictionary = new HashSet<>();

    public static void main(String[] args) {
        dictionary.add("GEEKS");
        dictionary.add("QUIZ");
        dictionary.add("GO");
        dictionary.add("SEEK");
        dictionary.add("USE");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boggle(boggle[i][j], i, j);
            }
        }
    }

    private static void boggle(String str, int i, int j) {

        visited[i][j] = true;

        if (dictionary.contains(str)) {
            System.out.println("valid word found : " + str);
        }

        for (int row = i - 1; row <= i + 1 && row < m; row++) {
            for (int column = j - 1; column <= j + 1 && column < n; column++) {
                if (row >= 0 && column >= 0 && !visited[row][column]) {
                    boggle(str + boggle[row][column], row, column);
                }
            }
        }

        visited[i][j] = false;
    }
}
