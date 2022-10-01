package string;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	private static Set<String> dictionary = new HashSet<>();

	public static void main(String[] args) {
		createDictionary();
		String str = "ilikeicecream";
		System.out.println("word could be breaked in valid words : " + wordBreak(str));

		printAllValidWords(str, "");
	}

	private static void printAllValidWords(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
		}

		for (int i = 1; i <= str.length(); i++) {
			String prefix = str.substring(0, i);
			if (dictionary.contains(prefix)) {
				printAllValidWords(str.substring(i, str.length()), result + prefix + " ");
			}
		}
	}

	private static boolean wordBreak(String str) {
		int n = str.length();
		boolean[] words = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {

			if (words[i] == false && dictionary.contains(str.substring(0, i))) {
				words[i] = true;
			}

			if (words[i] == true) {
				for (int j = i + 1; j <= n; j++) {
					if (dictionary.contains(str.substring(i, j))) {
						words[j] = true;
					}
				}
			}
		}

		return words[n];
	}

	private static void createDictionary() {
		dictionary.add("i");
		dictionary.add("love");
		dictionary.add("like");
		dictionary.add("ice");
		dictionary.add("cream");
		dictionary.add("icecream");
		dictionary.add("nyesha");
	}

}
