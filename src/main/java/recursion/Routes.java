package recursion;

public class Routes {

	private static int n = 4;
	private static int[][] sol = new int[n][n];

	public static void main(String[] args) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sol[i][j] = 0;
			}
		}
		routes(0, 0);
		System.out.println("no of sol : " + count);
	}

	private static int count  = 0;
	private static void routes(int i, int j) {
		sol[i][j] = 1;

		if (i == (n - 1) && j == (n - 1)) {
			count++;
			printSol();
		}

		for (int row = i; row <= i + 1 && row < n; row++) {
			for (int col = j; col <= j + 1 && col < n; col++) {
				if (sol[row][col] != 1 && ((row == i && col == j + 1) || (row == i + 1 && col == j))) {
					routes(row, col);
				}
			}
		}
		
		sol[i][j] = 0;
	}

	private static void printSol() {
		StringBuilder builder = new StringBuilder("printing one of the sol");
		builder.append("\n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				builder.append(sol[i][j]);
				builder.append(" ");
			}
			builder.append("\n");
		}

		System.out.println(builder.toString());
	}
}
