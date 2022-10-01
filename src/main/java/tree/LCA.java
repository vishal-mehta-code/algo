package tree;

public class LCA {

	public static void main(String[] args) {
		Node node = new Node(20);
		node.left = new Node(15);
		node.right = new Node(30);

		node.left.left = new Node(10);
		node.left.right = new Node(16);

		System.out.println("BST LCA : " + lcaInABst(node, 15, 16));

		Node node1 = new Node(20);
		node1.left = new Node(5);
		node1.right = new Node(3);

		node1.left.left = new Node(18);
		node1.left.right = new Node(19);

		System.out.println("LCA : " + lca(node1, 5, 3));
	}

	private static Node lca(Node node, int x, int y) {
		Node lca = lcaUtil(node, x, y);
		if ((xPresent && yPresent) || (xPresent && search(node, y) || (yPresent && search(node, x)))) {
			return lca;
		}
		return null;
	}

	private static boolean search(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		}
		return search(node.left, data) || search(node.right, data);
	}

	private static boolean xPresent = false;
	private static boolean yPresent = false;

	private static Node lcaUtil(Node node, int x, int y) {
		if (node == null) {
			return null;
		}
		if (node.data == x) {
			xPresent = true;
			return node;
		}
		if (node.data == y) {
			yPresent = true;
			return node;
		}

		Node l = lcaUtil(node.left, x, y);
		Node r = lcaUtil(node.right, x, y);

		if (l != null && r != null) {
			return node;
		}

		return l != null ? l : r;
	}

	private static Node lcaInABst(Node node, int lowerBound, int upperBound) {
		if (node == null)
			return null;
		if (node.data >= lowerBound && node.data <= upperBound)
			return node;
		if (node.data > upperBound)
			return lcaInABst(node.left, lowerBound, upperBound);

		return lcaInABst(node.right, lowerBound, upperBound);
	}

}
