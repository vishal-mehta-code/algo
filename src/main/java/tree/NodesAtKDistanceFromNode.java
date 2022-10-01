package tree;

public class NodesAtKDistanceFromNode {

	private static int k = 2;
	private static Node rootNode = new Node(20);
	private static Node targetNode = null;

	public static void main(String[] args) {
		rootNode.left = new Node(8);
		rootNode.right = new Node(22);

		rootNode.left.left = new Node(4);
		rootNode.left.right = new Node(12);

		rootNode.left.right.left = new Node(10);
		rootNode.left.right.right = new Node(14);
		targetNode = rootNode.left;

		nodesAtKDistanceFromNode(rootNode);
	}

	private static Node nodesAtKDistanceFromNode(Node node) {

		if (node != null) {

			if (node == targetNode) {
				printAllDescendentsAtKDistance(node, 0, k);
				return node;
			}

			Node lNode = nodesAtKDistanceFromNode(node.left);
			Node rNode = nodesAtKDistanceFromNode(node.right);

			if (rNode != null) {
				if (k == 1) {
					System.out.println(node);
					return null;
				} else {
					printAllDescendentsAtKDistance(node.left, 0, k - 2);
					k = k - 1;
					return node;
				}

			} else if (lNode != null) {
				if (k == 1) {
					System.out.println(node);
					return null;
				} else {
					printAllDescendentsAtKDistance(node.right, 0, k - 2);
					k = k - 1;
					return node;
				}
			}

			return null;

		}
		return null;

	}

	private static void printAllDescendentsAtKDistance(Node node, int level, int k) {
		if (node != null) {
			if (level == k) {
				System.out.println(node.data);
			}
			printAllDescendentsAtKDistance(node.left, level + 1, k);
			printAllDescendentsAtKDistance(node.right, level + 1, k);
		}
	}
}
