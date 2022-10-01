package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Class <code>OddAppearances</code> for finding element/s that appear odd times in an array.
 */
public class OddAppearances {

	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 3, 4, 2, 5, 7, 10, 12, 10 };
		findOddAppearancesWithMaps(array);
	}

	/**
	 * Finds Elements that appear odd no of times in given array.
	 * <P>
	 * Maintain a map. Iterate over the array and add elements in the map keyed on item and its no of appearances. If an element is already in map update the counter. Iterate over the map and find the
	 * elements that appears odd no of times.
	 * </p>
	 * 
	 * @param array
	 */
	private static void findOddAppearancesWithMaps(int[] array) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {
			Integer item = array[i];
			if (map.containsKey(item)) {
				map.put(item, map.get(item) + 1);
			} else {
				map.put(item, 1);
			}

		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				System.out.println(entry.getKey() + " appears odd no of times");
			}
		}
	}
}
