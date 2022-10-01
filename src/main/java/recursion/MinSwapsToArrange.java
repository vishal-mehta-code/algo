package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/minimum-number-of-swaps-required-for-arranging-pairs-adjacent-to-each-other/
 */
public class MinSwapsToArrange {

	public static class Pair {
		public int i;
		public int j;

		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if ((i == other.i && j == other.j) || (i == other.j && j == other.i))
				return true;

			return false;
		}

	}

	public static void main(String[] args) {
		int[] array = { 3, 5, 6, 4, 1, 2 };

		Pair pair1 = new Pair(1, 3);
		Pair pair2 = new Pair(2, 6);
		Pair pair3 = new Pair(4, 5);

		pairs.add(pair1);
		pairs.add(pair2);
		pairs.add(pair3);

		minSwaps(array, 0, array.length - 1, 0);
		System.out.println("min is : " + min);

	}

	private static int min = Integer.MAX_VALUE;
	private static List<Pair> pairs = new ArrayList<>();

	private static void minSwaps(int[] array, int start, int end, int swaps) {

		if (paired(array, start, end)) {
			if (swaps < min) {
				min = swaps;
			}
			return;
		}

		for (int i = start; i < end; i = i + 2) {
			if (!paired(array, i, i + 1)) {
				int partnerIndex = getPartnerIndex(array, array[i]);

				swap(array, i + 1, partnerIndex);
				minSwaps(array, i + 2, end, swaps + 1);
				swap(array, i + 1, partnerIndex);

				partnerIndex = getPartnerIndex(array, array[i + 1]);
				swap(array, i, partnerIndex);
				minSwaps(array, i + 2, end, swaps + 1);
				swap(array, i, partnerIndex);
				
				return;
			}
		}
	}

	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	private static int getPartnerIndex(int[] array, int element) {
		int pairedElement = 0;

		for (Pair pair : pairs) {
			if (pair.i == element) {
				pairedElement = pair.j;
				break;
			}
			if (pair.j == element) {
				pairedElement = pair.i;
				break;
			}
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] == pairedElement) {
				return i;
			}
		}

		return 0;
	}

	private static boolean paired(int[] array, int start, int end) {

		for (int i = start; i < end; i = i + 2) {
			if (!pairs.contains(new Pair(array[i], array[i + 1]))) {
				return false;
			}
		}

		return true;
	}
}
