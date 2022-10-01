package misc;

public class JspParser {

	public static void main(String[] args) {

		String jsp = "" + "<!DOCTYPE html>" + "<html>" + "  <head>" + "    <% int i = 3 % 5, j = 2; %>" + "    <title>JSP Parser!</title>" + "  </head>" + "  <body>"
				+ "    <h1>Time: <%= System.currentTimeMillis() %></h1>" + "    <p><code>i = <%=i%></code> and that's 33% more than <code>j = <%=j%></p>" + "  </body>" + "</html>";

		int curstart = 0;
		for (int i = 0; i < jsp.length(); i++) {

			if (jsp.charAt(i) == '%' && jsp.charAt(i - 1) == '<') {

				System.out.println(jsp.substring(curstart, i - 1));
				int endIndex = getEndIndex(jsp, i + 1);

				if (endIndex == -1) {
					System.out.println("invalid tag starting at : " + (i - 1));
					return;
				}

				if (jsp.charAt(i + 1) == '=') {
					// Expression
					System.out.println(jsp.substring(i + 2, endIndex));
				} else {
					// java code
					System.out.println(jsp.substring(i + 1, endIndex));
				}

				i = endIndex + 2;
				curstart = endIndex + 2;
			}
		}

		// print if something left
		System.out.println(jsp.substring(curstart, jsp.length()));
	}

	private static int getEndIndex(String jsp, int startIndex) {
		int lastIndex = 0;

		while (lastIndex != -1) {
			lastIndex = jsp.indexOf('%', startIndex);
			if (lastIndex < jsp.length() - 1 && jsp.charAt(lastIndex + 1) == '>') {
				return lastIndex;
			}
			startIndex = lastIndex + 1;
		}
		return -1;
	}

}
