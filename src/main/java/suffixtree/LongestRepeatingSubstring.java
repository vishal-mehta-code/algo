package suffixtree;

import suffixtree.SuffixTree.SuffixTreeNode;

public class LongestRepeatingSubstring {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		String str = "AAAAAAAAA$";
		SuffixTreeNode node = new SuffixTree(str).root;
		longestRepeatingSubstring(node, 0);
		System.out.println("longest repeating substring : " + str.substring(maxEnd + 1 - maxLength, maxEnd + 1));
	}

	private static int maxLength = 0;
	private static int maxEnd = 0;

	private static void longestRepeatingSubstring(SuffixTreeNode node, int length) {
		if (node.start != -1 && node.index == -1 && length > maxLength) {
			maxLength = length;
			maxEnd = node.end.end;
		}

		for (int i = 0; i < 256; i++) {
			if (node.children[i] != null) {
				longestRepeatingSubstring(node.children[i], length + (node.children[i].end.end - node.children[i].start + 1));
			}
		}
	}
}
