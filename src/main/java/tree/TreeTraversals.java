package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversals {
	private static int lhsHorizontalDistance, rhsHorizontalDistance;

	public static void main(String[] args) {
		Node node = new Node(20);
		node.left = new Node(15);
		node.right = new Node(30);

		node.right.left = new Node(25);
		node.right.right = new Node(35);

		inOrder(node);
		inOrderWithoutRecursion(node);
		preOrder(node);
		horizontalOrder(node);
		horizontalOrderWithoutRecursion(node);
		verticalOrder(node);
	}

	public static void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node);
			inOrder(node.right);
		}
	}

	public static void preOrder(Node node) {
		if (node != null) {
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}

	}

	public static void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.data);
		}
	}

	private static void inOrderWithoutRecursion(Node node) {
		if (node == null) {
			return;
		}

		Stack<Node> stk = new Stack<>();
		stk.push(node);

		while (node != null || !stk.isEmpty()) {

			if (node != null) {

				if (node.left != null) {
					stk.push(node.left);
					node = node.left;
				} else {
					Node n = stk.pop();
					System.out.println("printing inorder without recursion : " + n);
					if (n.right != null) {
						stk.push(n.right);
					}
					node = n.right;
				}

			} else {
				Node n = stk.pop();
				System.out.println("printing inorder without recursion : " + n);
				if (n.right != null) {
					stk.push(n.right);
				}
				node = n.right;
			}
		}

	}

	private static void horizontalOrderWithoutRecursion(Node node) {

		if (node == null)
			return;

		Queue<QueueItem> queue = new LinkedList<QueueItem>();

		queue.add(new QueueItem(node, 0));

		while (!queue.isEmpty()) {
			QueueItem queueItem = queue.remove();
			Node n = queueItem.node;
			System.out.println("printing up down : " + n.data);

			if (n.left != null) {
				queue.add(new QueueItem(n.left));
			}
			if (n.right != null) {
				queue.add(new QueueItem(n.right));
			}
		}
	}

	private static void horizontalOrder(Node node) {
		int depth = getDepth(node);

		for (int i = 1; i <= depth; i++) {
			printHorizontalLine(node, i, 1);
		}

	}

	private static void printHorizontalLine(Node node, int i, int level) {

		if (node != null) {
			if (level == i) {
				System.out.println("printing line : " + node.data);
			}

			printHorizontalLine(node.left, i, level + 1);
			printHorizontalLine(node.right, i, level + 1);
		}
	}

	private static int getDepth(Node node) {
		if (node == null)
			return 0;

		return 1 + Math.max(getDepth(node.left), getDepth(node.right));
	}

	// O(w*n) and if the tree is flat O(n * n)
	private static void verticalOrder(Node node) {

		findLhsRhsHorizontalDistances(node, 0);
		System.out.println("lhsHorizontalDistance : " + lhsHorizontalDistance + " rhsHorizontalDistance : " + rhsHorizontalDistance);

		for (int i = lhsHorizontalDistance; i <= rhsHorizontalDistance; i++) {
			printVerticalLine(node, i, 0);
		}

	}

	// O(n)
	private static void printVerticalLine(Node node, int lineNo, int hd) {
		if (node != null) {

			if (lineNo == hd) {
				System.out.println("printing line : " + node.data);
			}

			printVerticalLine(node.left, lineNo, hd - 1);
			printVerticalLine(node.right, lineNo, hd + 1);
		}

	}

	// O(n)
	private static void findLhsRhsHorizontalDistances(Node node, int hd) {
		if (node != null) {
			if (hd < lhsHorizontalDistance) {
				lhsHorizontalDistance = hd;
			}
			if (hd > rhsHorizontalDistance) {
				rhsHorizontalDistance = hd;
			}
			findLhsRhsHorizontalDistances(node.left, hd - 1);
			findLhsRhsHorizontalDistances(node.right, hd + 1);
		}
	}

}
