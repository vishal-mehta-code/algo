package string;

public class RemoveAdjDups {

	public static void main(String[] args) {
		String str = "geeksforgeeg";
		System.out.println(removeAdjDups(str, 0));
	}

	private static String removeAdjDups(String str, int i) {

		if (str.length() <= 1) {
			return str;
		}
		if (i == str.length() - 1) {
			return str;
		}

		if (str.charAt(i) == str.charAt(i + 1)) {
			int j = i + 1;

			while (j < str.length() && str.charAt(i) == str.charAt(j)) {
				j++;
			}

			return removeAdjDups(str.substring(0, i) + str.substring(j, str.length()), i - 1);
		}

		return removeAdjDups(str, i + 1);
	}

}
