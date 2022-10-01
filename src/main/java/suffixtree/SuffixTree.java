package suffixtree;

public class SuffixTree {

	public static class SuffixTreeNode {
		public int start;
		public End end;
		public int index = -1;
		public SuffixTreeNode[] children = new SuffixTreeNode[256];
		public SuffixTreeNode suffixLink = root;

		public SuffixTreeNode(int start, End end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "SuffixTreeNode [start=" + start + ", end=" + end + ", index=" + index + "]";
		}

	}

	public static class End {
		public int end;

		public End(int end) {
			this.end = end;
		}

		@Override
		public String toString() {
			return "End [end=" + end + "]";
		}

	}

	public SuffixTree(String str) {
		buildSuffixTree(str);
	}

	public static SuffixTreeNode root;
	private SuffixTreeNode activeNode;
	private End end;
	private int activeEdge = -1;
	private int activeLength = 0;
	private int remaining = 0;
	private char[] text;

	private void buildSuffixTree(String text) {
		this.text = text.toCharArray();

		end = new End(-1);

		root = new SuffixTreeNode(-1, end);

		activeNode = root;

		for (int i = 0; i < text.length(); i++) {
			extendSuffixTree(i);
		}

		setIndex(root, 0);
	}

	private void setIndex(SuffixTreeNode node, int length) {
		if (node == null) {
			return;
		}

		boolean leaf = true;
		for (int i = 0; i < 256; i++) {
			if (node.children[i] != null) {
				leaf = false;
				setIndex(node.children[i], length + (node.children[i].end.end - node.children[i].start + 1));
			}
		}

		if (leaf) {
			node.index = text.length - length;
			print(node);
		} else if (!leaf && node.start != -1) {
			print(node);
		}
	}

	private void print(SuffixTreeNode suffixTreeNode) {
		StringBuilder sb = new StringBuilder();

		for (int i = suffixTreeNode.start; i <= suffixTreeNode.end.end; i++) {
			sb.append(text[i]);
		}

		sb.append(" ");
		sb.append(suffixTreeNode.index);
		System.out.println(sb.toString());
	}

	private void extendSuffixTree(int pos) {
		SuffixTreeNode lastNewNode = null;
		end.end = end.end + 1;
		remaining++;

		while (remaining > 0) {

			if (activeLength == 0) {
				activeEdge = pos;
			}

			if (activeNode.children[text[activeEdge]] == null) {
				activeNode.children[text[activeEdge]] = new SuffixTreeNode(pos, end);

				if (lastNewNode != null) {
					lastNewNode.suffixLink = activeNode;
					lastNewNode = null;
				}

			} else {
				SuffixTreeNode next = activeNode.children[text[activeEdge]];

				if (walkDown(next)) {
					continue;
				}

				if (text[next.start + activeLength] == text[pos]) {
					activeLength++;

					if (lastNewNode != null) {
						lastNewNode.suffixLink = activeNode;
						lastNewNode = null;
					}

					break;
				}

				End splitEnd = new End(next.start + activeLength - 1);

				SuffixTreeNode split = new SuffixTreeNode(next.start, splitEnd);

				activeNode.children[text[activeEdge]] = split;

				split.children[text[pos]] = new SuffixTreeNode(pos, end);

				next.start = next.start + activeLength;

				split.children[text[next.start]] = next;

				if (lastNewNode != null) {
					lastNewNode.suffixLink = split;
				}

				lastNewNode = split;

			}

			remaining--;

			if (activeNode == root && activeLength > 0) {
				activeLength--;
				activeEdge = pos - remaining + 1;
			} else if (activeNode != root) {
				activeNode = activeNode.suffixLink;
			}
		}
	}

	private boolean walkDown(SuffixTreeNode node) {

		if (activeLength >= (node.end.end - node.start + 1)) {
			activeLength = activeLength - (node.end.end - node.start + 1);
			activeEdge = activeEdge + (node.end.end - node.start + 1);
			activeNode = node;
			return true;
		}

		return false;
	}
}
