package recursion;

public class Sudoku {

	static final class Cell {
		int row;
		int column;
	}

	private static int N = 9;

	// 0 means unassigned cells
	private static int[][] grid = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
			{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

	public static void main(String[] args) {

		if (solveSudoku()) {
			printSolution();
		} else {
			System.out.println("no sol exists");
		}

	}

	private static boolean solveSudoku() {

		Cell cell = new Cell();
		if (!findUnAssighnedCells(cell))
			return true;

		int row = cell.row;
		int column = cell.column;

		for (int i = 1; i <= 9; i++) {
			if (isSafe(row, column, i)) {
				grid[row][column] = i;

				if (solveSudoku())
					return true;
				else
					grid[row][column] = 0;

			}

		}

		return false;
	}

	private static boolean isSafe(int row, int column, int item) {

		for (int j = 0; j < N; j++) {
			if (grid[row][j] == item) {
				return false;
			}
		}

		for (int i = 0; i < N; i++) {
			if (grid[i][column] == item) {
				return false;
			}
		}

		for (int i = row / 3 * 3; i <= row / 3 * 3 + 2; i++) {
			for (int j = column / 3 * 3; j <= column / 3 + 2; j++) {
				if (grid[i][j] == item) {
					return false;
				}

			}
		}

		return true;
	}

	private static boolean findUnAssighnedCells(Cell cell) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 0) {
					cell.row = i;
					cell.column = j;
					return true;
				}
			}
		}
		return false;
	}

	private static void printSolution() {

		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < N; j++) {
				sb.append(grid[i][j] + " ");
			}
			sb.append("\n");
			System.out.println(sb.toString());
		}

	}
}
