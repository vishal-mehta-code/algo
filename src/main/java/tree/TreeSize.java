package tree;

public class TreeSize {

	public static void main(String[] args) {

		Node node = new Node(20);
		node.left = new Node(15);
		node.right = new Node(30);

		System.out.println(getSize(node));
	}

	public static int getSize(Node node) {
		if (node == null) {
			return 0;
		}

		return 1 + getSize(node.left) + getSize(node.right);
	}
}
