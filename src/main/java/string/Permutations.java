package string;

import java.util.LinkedHashSet;
import java.util.Set;

public class Permutations {

	public static void main(String[] args) {
		// permutations("", "abc");
		lexographicPermutations("12321");
	}

	private static void lexographicPermutations(String str) {
		char[] charArray = str.toCharArray();
		sort(charArray, 0, str.length() - 1);

		String sortedString = new String(charArray);
		System.out.println(sortedString);
		permutations("", sortedString);
		System.out.println(set);
	}

	private static void sort(char[] str, int start, int end) {
		if (start < end) {
			int p = partition(str, start, end);
			sort(str, start, p - 1);
			sort(str, p + 1, end);
		}
	}

	private static int partition(char[] str, int start, int end) {
		char x = str[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (str[j] <= x) {
				i++;
				swap(str, i, j);
			}
		}
		swap(str, i + 1, end);
		return i + 1;
	}

	private static void swap(char[] str, int i, int j) {
		char tmp = str[i];
		str[i] = str[j];
		str[j] = tmp;
	}

	private static Set<String> set = new LinkedHashSet<>();
	private static void permutations(String prefix, String str) {
		if (str.length() == 0) {
			// for collecting unique permutations
			set.add(prefix);
			// System.out.println("permutation : " + prefix);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			permutations(prefix + str.substring(i, i + 1), str.substring(0, i) + str.substring(i + 1, str.length()));
		}
	}

}
