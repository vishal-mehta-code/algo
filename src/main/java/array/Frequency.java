package array;

import java.util.Arrays;

public class Frequency {

	public static void main(String[] args) {
		int[] array = { 1, 2, 2 };
		int n = array.length;

		// Use every element arr[i] as index and add 'n' to
		// element present at arr[i]%n to keep track of count of
		// occurrences of arr[i]
		for (int i = 0; i < n; i++)
			array[array[i] % n] = array[array[i] % n] + n;

		// To print counts, simply print the number of times n
		// was added at index corresponding to every element
		for (int i = 0; i < n; i++) {
			System.out.println(i + " ->  " + array[i] / n);
		}

		// fixing the array again
		for (int i = 0; i < n; i++) {
			array[i] = array[i] % n;
		}

		System.out.println(Arrays.toString(array));
	}
}
