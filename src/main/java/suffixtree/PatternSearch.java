package suffixtree;

import suffixtree.SuffixTree.SuffixTreeNode;

public class PatternSearch {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		String str = "AAAAAAAAA$";
		SuffixTreeNode node = new SuffixTree(str).root;

		char[] pattern = "A".toCharArray();

		patternSearch(str, node, pattern, 0);
	}

	private static void printIndexesOfAllDescendentsLeaves(SuffixTreeNode node) {
		if (node.index != -1) {
			System.out.println("occured at : " + node.index);
			return;
		}

		for (int i = 0; i < 256; i++) {
			if (node.children[i] != null) {
				printIndexesOfAllDescendentsLeaves(node.children[i]);
			}
		}
	}

	private static boolean patternSearch(String str, SuffixTreeNode node, char[] pattern, int i) {
		if (i == pattern.length) {
			System.out.println("pattern found");
			printIndexesOfAllDescendentsLeaves(node);
			return true;
		}

		if (node.children[pattern[i]] == null) {
			System.out.println("pattern not found");
			return false;
		}

		node = node.children[pattern[i]];
		for (int j = node.start; j <= node.end.end; j++) {

			if (i == pattern.length) {
				System.out.println("pattern found");
				printIndexesOfAllDescendentsLeaves(node);
				return true;
			}

			if (str.charAt(j) != pattern[i]) {
				System.out.println("pattern not found");
				return false;
			}

			i++;
		}

		return patternSearch(str, node, pattern, i);
	}
}
