package numbers;

public class NumerToString {

	private static final String NEGATIVE = "- ";
	private static final String HUNDRED = " hundred ";
	private static final String THOUSNAD = " thousand ";
	private static final String MILLION = " million ";
	private static final String[] units = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "nineteen" };
	private static final String[] tens = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	public static void main(String[] args) {
		int num = -1209;
		boolean isNegative = false;
		if (num < 0) {
			isNegative = true;
		}
		String str = convertToString(isNegative ? -num : num);

		System.out.println(isNegative ? NEGATIVE + str : str);
	}

	private static String convertToString(int num) {
		if (num < 20) {
			return units[num];
		}
		if (num < 100) {
			return tens[num / 10] + " " + units[num % 10];
		}
		if (num < 1000) {
			return units[num / 100] + HUNDRED + (num % 100 > 0 ? convertToString(num % 100) : "");
		}
		if (num < 100000) {
			return convertToString(num / 1000) + THOUSNAD + (num % 1000 > 0 ? convertToString(num % 1000) : "");
		}
		if (num < 100000000) {
			return convertToString(num / 100000) + MILLION + (num % 100000 > 0 ? convertToString(num % 100000) : "");
		}

		return null;
	}

}
