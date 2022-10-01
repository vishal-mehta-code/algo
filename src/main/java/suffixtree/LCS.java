package suffixtree;

import suffixtree.SuffixTree.SuffixTreeNode;

public class LCS {

	private static final String str1 = "abc$";
	private static final String str2 = "xbc#";
	private static final String str = str1 + str2;

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		SuffixTreeNode node = new SuffixTree(str).root;

		lcs(node);

		System.out.println("LCS : " + str.substring(maxEnd - maxLength + 1, maxEnd + 1));
	}

	private static int maxLength = 0;
	private static int maxEnd = 0;

	private static int lcs(SuffixTreeNode node) {

		if (node.index > -1) {
			if (node.index >= 0 && node.index < str1.length()) {
				return -2;
			}

			if (node.index >= str1.length() && node.index < str.length()) {
				return -3;
			}
		}

		for (int i = 0; i < 256; i++) {
			if (node.children[i] != null) {
				int ret = lcs(node.children[i]);

				if (node.start != -1) {
					if (node.index == -1) {
						node.index = ret;
					} else if ((node.index == -2 && ret == -3) || (node.index == -3 && ret == -2) || node.index == -4) {
						node.index = -4;

						if (node.end.end - node.start > maxLength) {
							maxLength = node.end.end - node.start + 1;
							maxEnd = node.end.end;
						}
					}
				}
			}
		}

		return 0;
	}

}
