package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HasSum {

	public static void main(String[] args) {
		findPairsWithGivenSum();
	}

	/**
	 * Finds all indexes which could give the sum.
	 */
	private static void findPairsWithGivenSum() {
		int[] array = { 5, 1, 2, 6, 5, 5, 6 };
		int sum = 11;

		HashMap<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < array.length; ++i) {
			if (map.containsKey(array[i])) {
				for (int index : map.get(array[i])) {
					System.out.println("indexes are : " + index + " and : " + i);
				}
			}
			if (map.containsKey(sum - array[i])) {
				List<Integer> list = map.get(sum - array[i]);
				list.add(i);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(sum - array[i], list);
			}
		}
	}
}
