package array;

/**
 * 
 * An Array element is Leader if all the elements after that array element is
 * lesser than or equal to it.
 * 
 */
public class Leaders {

	private static int[] array = { 13, 17, 5, 6, 6, 2 };

	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;

		for (int i = array.length - 1; i >= 0; i--) {

			if (array[i] >= max) {
				System.out.println("Leader : " + array[i]);
				max = array[i];
			}
		}
	}
}
