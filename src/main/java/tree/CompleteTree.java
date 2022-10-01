package tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteTree {

	public static void main(String[] args) {
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);

		node.left.left = new Node(4);
		node.left.left.left = new Node(5);

		System.out.println("is complete tree : " + isComplete(node));
	}

	private static boolean isComplete(Node node) {

		if (node == null)
			return true;
		if (node.left == null && node.right == null)
			return true;

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		boolean notFull = false;

		while (!queue.isEmpty()) {

			Node n = queue.remove();

			if (n.left == null && n.right != null)
				return false;

			if (notFull) {
				if (n.left != null || n.right != null) {
					return false;
				}

			} else if (n.left == null || n.right == null) {
				notFull = true;
			}

			if (n.left != null) {
				queue.add(n.left);
			}
			if (n.right != null) {
				queue.add(n.right);
			}
		}

		return true;

	}

}
