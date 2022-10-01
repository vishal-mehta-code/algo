package searching;

/**
 * Class <code>Search</code> deals with searching in a sorted array. Complexity
 * of solution is O(logn) because we would be searching in half of the array at
 * each iteration level.
 * 
 * @author v.a.mehta
 * 
 */
public class BinarySearch {

	/**
	 * main method.
	 * 
	 * @param args
	 *            string args
	 */
	public static void main(String[] args) {
		// sample array
		int[] array = { 1 };
		System.out.println("index is : " + search(array, 0, array.length));

	}

	/**
	 * Searches in the given array where the transition from 0 to 1 happened.
	 * 
	 * @param array
	 *            given array
	 * @param start
	 *            start index
	 * @param end
	 *            end index
	 */
	private static int search(int[] array, int start, int end) {

		if (start <= end) {

			if (start == end) {
				return -1;
			}

			if (start + 1 == end) {
				return (array[start] == 0 && array[end] == 1) ? end : -1;
			}

			int mid = start + (end - start) / 2;

			if (array[mid] == 1) {

				if (array[mid - 1] == 0)
					return mid;

				if (array[mid - 1] == 1)
					return search(array, start, mid - 1);

			}

			if (array[mid] == 0) {

				if (array[mid + 1] == 1)
					return mid + 1;
				if (array[mid + 1] == 0)
					return search(array, mid + 1, end);

			}

		}
		return -1;

	}

}
