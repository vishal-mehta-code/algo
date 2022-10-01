package recursion;

public class NQueen {

	// Matrix size
	private static int N = 4;

	private static int[][] sol = new int[N][N];

	public static void main(String[] args) {

		// initialize solution matrix
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sol[i][j] = 0;
			}
		}

		if (nQueen(0)) {
			printSolution();
		} else {
			System.out.println("no sol exists");
		}
	}

	private static boolean nQueen(int column) {

		if (column == N)
			return true;

		for (int i = 0; i < N; i++) {
			if (isSafe(i, column)) {

				sol[i][column] = 1;
				if (nQueen(column + 1))
					return true;
				else
					sol[i][column] = 0;
			}
		}
		return false;
	}

	private static boolean isSafe(int row, int column) {
		for (int j = 0; j < column; j++) {

			if (sol[row][j] == 1)
				return false;

		}

		for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {

			if (sol[i][j] == 1)
				return false;
		}

		for (int i = row + 1, j = column - 1; i < N && j >= 0; i++, j--) {

			if (sol[i][j] == 1)
				return false;
		}

		return true;
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

}
