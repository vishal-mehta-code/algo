package tree;

public class TreeDiameter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node node = new Node(20);
		node.right = new Node(30);

		node.right.left = new Node(25);
		node.right.right = new Node(35);

		node.right.left.left = new Node(23);
		node.right.left.right = new Node(26);

		node.right.left.left.left = new Node(22);

		System.out.println(getDiameter(node));

	}

	private static int max = 0;

	private static int getDiameter(Node node) {
		if (node == null) {
			return 0;
		}

		int l = getDiameter(node.left);
		int r = getDiameter(node.right);

		if (l + r + 1 > max) {
			max = l + r + 1;
		}

		return 1 + Math.max(l, r);

	}

}
