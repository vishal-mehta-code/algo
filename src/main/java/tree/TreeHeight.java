package tree;

public class TreeHeight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node node = new Node(20);
		node.left = new Node(15);
		// node.right = new Node(30);

		// System.out.println(getBstHeight(node));

		Node node2 = new Node(20);
		node2.left = new Node(15);

		System.out.println(getBstMinHeight(node));
	}

	public static int getBstMinHeight(Node node) {
		if (node == null)
			return 0;
		else
			return 1 + Math.min(getBstMinHeight(node.left), getBstMinHeight(node.right));
	}

	public static int getBstHeight(Node node) {
		if (node == null)
			return 0;
		else
			return 1 + Math.max(getBstHeight(node.left), getBstHeight(node.right));
	}
}
