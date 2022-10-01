package tree;

/**
 * Change the node value = sum of the left and right subtree. Another commonly
 * asked is change the node value = sum of the left and right subtree
 * considering only those values which are smaller then node value.
 */
public class SumTree {

	public static void main(String[] args) {
		Node node1 = new Node(10);
		node1.left = new Node(-2);
		node1.right = new Node(6);

		node1.left.left = new Node(8);
		node1.left.right = new Node(-4);

		node1.right.left = new Node(7);
		node1.right.right = new Node(5);

		Node node2 = new Node(50);
		node2.left = new Node(7);
		node2.right = new Node(2);

		node2.left.left = new Node(3);
		node2.left.right = new Node(5);

		node2.right.left = new Node(1);
		node2.right.right = new Node(30);

		convertTosumTree(node1);
		TreeTraversals.inOrder(node1);

		// Convert to fully sum tree
		convertToFullSumTree(node2);
		System.out.println("printing full sum tree");
		TreeTraversals.inOrder(node2);

	}

	/**
	 * Given an arbitrary binary tree, convert it to a binary tree that holds
	 * Children Sum Property. You can only increment data values in any node
	 * (You cannot change structure of tree and cannot decrement value of any
	 * node).
	 */
	private static void convertToFullSumTree(Node node) {

		if ((node == null || (node.left == null && node.right == null)))
			return;

		convertToFullSumTree(node.left);
		convertToFullSumTree(node.right);

		int diff = (node.left == null ? 0 : node.left.data) + (node.right == null ? 0 : node.right.data) - node.data;

		if (diff == 0)
			return;
		if (diff > 0) {
			node.data = node.data + diff;
		} else {
			increment(node, -diff);
		}
	}

	private static void increment(Node node, int diff) {
		if (node.left != null) {
			node.left.data = node.left.data + diff;
			increment(node.left, diff);
		} else if (node.right != null) {
			node.right.data = node.right.data + diff;
			increment(node.right, diff);
		}
	}

	private static void convertTosumTree(Node node) {
		if (node == null)
			return;

		node.data = calculateSum(node.left, node.data) + calculateSum(node.right, node.data);
		convertTosumTree(node.left);
		convertTosumTree(node.right);
	}

	private static int calculateSum(Node node, int data) {
		if (node != null) {
			return (node.data < data ? node.data : 0) + calculateSum(node.left, data) + calculateSum(node.right, data);
		}

		return 0;
	}

}
