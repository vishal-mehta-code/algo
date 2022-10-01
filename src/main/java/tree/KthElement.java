package tree;

public class KthElement {

	public static void main(String[] args) {
		Node node = new Node(20);
		node.left = new Node(15);
		node.right = new Node(30);

		node.left.left = new Node(14);
		node.left.right = new Node(16);

		node.right.left = new Node(25);
		node.right.right = new Node(35);

		System.out.println(kthSmallest(node, 5));
		System.out.println(kthLargest(node, 5));

	}

	private static Node kthLargest(Node node, int k) {
		if (node == null) {
			return null;
		}

		int rs = TreeSize.getSize(node.right);

		if (rs + 1 == k) {
			return node;
		}

		if (rs + 1 > k) {
			return kthLargest(node.right, k);
		}

		return kthLargest(node.left, k - rs - 1);
	}

	private static Node kthSmallest(Node node, int k) {
		if (node == null) {
			return null;
		}

		int ls = TreeSize.getSize(node.left);

		if (ls + 1 == k) {
			return node;
		}

		if (ls + 1 > k) {
			return kthSmallest(node.left, k);
		}

		return kthSmallest(node.right, k - ls - 1);

	}

}
