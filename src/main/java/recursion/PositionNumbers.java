package recursion;

public class PositionNumbers {

	private static int N = 4;
	private static int[] sol = new int[2 * N];

	public static void main(String[] args) {
		if (positionNumbers(1))
			printSolution();
		else
			System.out.println("no solution exists");
	}

	private static boolean positionNumbers(int num) {

		if (!anyUnAssighned())
			return true;

		for (int i = 0; i <= 2 * N; i++) {

			if (isSafe(num, i)) {

				sol[i] = num;
				sol[i + num + 1] = num;

				if (positionNumbers(num + 1))
					return true;
				else {
					sol[i] = 0;
					sol[i + num + 1] = 0;
				}
			}

		}

		return false;
	}

	private static boolean anyUnAssighned() {
		for (int i = 0; i < 2 * N; i++) {
			if (sol[i] == 0)
				return true;
		}
		return false;
	}

	private static boolean isSafe(int num, int i) {
		return (i + num + 1 < 2 * N) && sol[i] == 0 && sol[i + num + 1] == 0;
	}

	private static void printSolution() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2 * N; i++) {
			sb.append(sol[i] + " ");
		}
		System.out.println(sb.toString());
	}
}
