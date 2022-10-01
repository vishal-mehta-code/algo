package tree;

public class BstValidation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node node = new Node(20);
		node.left = new Node(15);
		node.right = new Node(30);

		node.left.left = new Node(2);
		node.left.right = new Node(18);

		System.out.println(isBst(node, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}

	public static boolean isBst(Node node, int minValue, int maxValue) {
		if (node == null)
			return true;
		if (node.data < minValue || node.data > maxValue)
			return false;
		return isBst(node.left, minValue, node.data - 1) && isBst(node.right, node.data + 1, maxValue);
	}
}
