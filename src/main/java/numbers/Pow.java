package numbers;

public class Pow {

	public static void main(String[] args) {
		int n = 2;
		int m = 4;
		System.out.println("output : " + pow(n, m));
	}

	private static int pow(int n, int m) {

		if (m == 0) {
			return 1;
		}

		int pow;
		if (m % 2 == 0) {
			pow = pow(n, m / 2);
			pow = pow * pow;
			return pow;
		}

		pow = pow(n, m / 2);
		pow = n * pow * pow;
		return pow;
	}
}
