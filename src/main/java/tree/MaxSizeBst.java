package tree;

public class MaxSizeBst {

	public static void main(String[] args) {
		Node node = new Node(20);
		node.left = new Node(15);
		node.right = new Node(30);

		node.right.left = new Node(2);
		node.right.right = new Node(35);

		System.out.println(maxSizeBst(node));
		System.out.println(getSizeOfMaxSizeBst(node));
	}

	private static Node maxSizeBst(Node node) {
		if (node == null)
			return null;
		if (BstValidation.isBst(node, Integer.MIN_VALUE, Integer.MAX_VALUE))
			return node;

		Node left = maxSizeBst(node.left);
		Node right = maxSizeBst(node.right);
		int ls = TreeSize.getSize(node.left);
		int rs = TreeSize.getSize(node.right);

		return (ls >= rs) ? left : right;
	}

	private static int getSizeOfMaxSizeBst(Node node) {
		if (node == null)
			return 0;
		if (BstValidation.isBst(node, Integer.MIN_VALUE, Integer.MAX_VALUE))
			return TreeSize.getSize(node);

		return Math.max(getSizeOfMaxSizeBst(node.left), getSizeOfMaxSizeBst(node.right));
	}

}
