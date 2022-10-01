package string;

public class PrintInterleivingStrings {

	public static void main(String[] args) {
		String str1 = "ab";
		String str2 = "cd";

		printInterleiving(str1, str2, "");
		printInterleiving(str2, str1, "");
	}

	private static void printInterleiving(String str1, String str2, String result) {
		if (str1.isEmpty() && str2.isEmpty()) {
			System.out.println(result);
			return;
		}
		if (str1.isEmpty() && !str2.isEmpty()) {
			System.out.println(result + str2);
			return;
		}
		if (str2.isEmpty() && !str1.isEmpty()) {
			System.out.println(result + str1);
			return;
		}

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {

				if (i == str1.length()) {
					printInterleiving(str1.substring(i, str1.length()), str2.substring(j, str2.length()), result + str1.substring(0, i) + str2.substring(0, j));
					break;
				} else {
					printInterleiving(str1.substring(i, str1.length()), str2.substring(j, str2.length()), result + str1.substring(0, i) + str2.substring(0, j));
				}

			}
		}

	}

}
