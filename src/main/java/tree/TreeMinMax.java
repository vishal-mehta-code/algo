package tree;

public class TreeMinMax {

	public static void main(String[] args) {
		Node node = new Node(2);
		node.left = new Node(15);
		node.right = new Node(30);

		node.right.left = new Node(1);

		System.out.println(getTreeMin(node));

		System.out.println(getTreeMax(node));
	}

	public static int getTreeMax(Node node) {
		if (node == null)
			return 0;

		return Math.max(node.data, Math.max(getTreeMax(node.left), getTreeMax(node.right)));

	}

	public static int getTreeMin(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return node.data;
		}
		if (node.left == null && node.right != null) {
			return Math.min(node.data, getTreeMin(node.right));
		}
		if (node.left != null && node.right == null) {
			return Math.min(node.data, getTreeMin(node.left));
		}
		return Math.min(node.data, Math.min(getTreeMin(node.left), getTreeMin(node.right)));
	}
}
