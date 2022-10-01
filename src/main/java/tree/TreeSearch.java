package tree;

public class TreeSearch {

	public static void main(String[] args) {
		Node node = new Node(15);
		node.left = new Node(10);
		node.right = new Node(30);

		// node.left.right = new Node(2);

		node.right.left = new Node(25);
		node.right.right = new Node(35);

		System.out.println(isPresent(node, 35));
	}

	public static boolean isPresent(Node node, int itemToBeSearched) {
		if (node == null)
			return false;

		return node.data == itemToBeSearched || isPresent(node.left, itemToBeSearched) || isPresent(node.right, itemToBeSearched);
	}
}
