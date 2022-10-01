package string;

public class Anagrams {

	public static void main(String[] args) {
		String s1 = "abad";
		String s2 = "bdaa";

		System.out.println(isAnagrams(s1.toCharArray(), s2.toCharArray()));
	}

	private static boolean isAnagrams(char[] s1, char[] s2) {
		int NO_OF_CHARCTERS = 256;
		int[] count1 = new int[NO_OF_CHARCTERS];
		int[] count2 = new int[NO_OF_CHARCTERS];

		for (int i = 0; i < s1.length; i++) {
			count1[s1[i]]++;
			count2[s2[i]]++;
		}

		for (int i = 0; i < NO_OF_CHARCTERS; i++) {
			if (count1[i] != count2[i])
				return false;
		}
		return true;
	}
}
