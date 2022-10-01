package string;

public class StringReversal {

	private static String str = "abc123";
	private static int length = str.length();

	public static void main(String[] args) {
		reverse("", str);
	}

	private static void reverse(String prefix, String str) {

		if (prefix.length() == length) {
			System.out.println("reversed string is : " + prefix);
			return;
		}

		reverse(prefix + str.charAt(str.length() - 1), str.substring(0, str.length() - 1));

	}

}
