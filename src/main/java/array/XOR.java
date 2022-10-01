package array;

public class XOR {

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 3, 4, 4, 4, 2, 1, 5, 5 };

		int res = 0;
		for (int i = 0; i < array.length; i++) {
			res = res ^ array[i];
		}
		System.out.println(res);
	}
}
