package array;

import java.util.Arrays;

/**
 * Write a function rotate(ar[], d) that rotates arr[] by d elements.
 */
public class Rotate {

	private static int[] array = { 1, 2, 3, 4, 5, 6, 7 };
	private static int length = array.length;
	private static int d = 2;

	public static void main(String[] args) {
		rotateFromLeft();
		rotateFromRight();
	}

	private static void rotateFromRight() {
		for (int i = 0; i < d; i++) {
			int tmp = array[length - 1];

			for (int j = length - 1; j > 0; j--) {
				array[j] = array[j - 1];
			}
			array[0] = tmp;
		}

		System.out.println(Arrays.toString(array));
	}

	private static void rotateFromLeft() {
		for (int i = 0; i < d; i++) {
			int temp = array[0];

			for (int j = 1; j < length; j++) {
				array[j - 1] = array[j];
			}
			array[length - 1] = temp;
		}
		System.out.println(Arrays.toString(array));
	}
}
