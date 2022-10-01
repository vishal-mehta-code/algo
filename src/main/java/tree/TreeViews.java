package tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class TreeViews {

	private static int lMaxLevel = 0;
	private static int rMaxLevel = 0;

	public static void main(String[] args) {
		Node node = new Node(20);
		node.left = new Node(8);
		node.right = new Node(22);

		node.right.right = new Node(25);

		node.left.left = new Node(5);
		node.left.right = new Node(3);

		node.left.right.left = new Node(10);
		node.left.right.right = new Node(14);
		node.right.right.left = new Node(26);
		

		printLeftView(node, 1);
		printRightView(node, 1);

		printTopView(node);
		printBottomView(node);

	}

	private static void printBottomView(Node node) {
		if (node == null)
			return;

		Map<Integer, Node> map = new TreeMap<Integer, Node>();

		Queue<QueueItem> queue = new LinkedList<>();

		queue.add(new QueueItem(node, 0));

		while (!queue.isEmpty()) {
			QueueItem queueItem = queue.remove();
			Node n = queueItem.node;
			int hd = queueItem.hd;

			map.put(hd, n);

			if (n.left != null) {
				queue.add(new QueueItem(n.left, hd - 1));
			}
			if (n.right != null) {
				queue.add(new QueueItem(n.right, hd + 1));
			}
		}

		Set<Entry<Integer, Node>> set = map.entrySet();

		for (Entry<Integer, Node> entry : set) {
			System.out.println("Printing bottom view : " + entry.getValue().data);
		}

	}

	private static void printTopView(Node node) {

		if (node == null) {
			return;
		}

		Set<Integer> set = new HashSet<>();

		Queue<QueueItem> queue = new LinkedList<>();

		queue.add(new QueueItem(node, 0));

		while (!queue.isEmpty()) {
			QueueItem queueItem = queue.remove();
			Node n = queueItem.node;
			int hd = queueItem.hd;

			if (!set.contains(hd)) {
				set.add(hd);
				System.out.println("printing top view : " + n.data);
			}

			if (n.left != null) {
				queue.add(new QueueItem(n.left, hd - 1));
			}
			if (n.right != null) {
				queue.add(new QueueItem(n.right, hd + 1));
			}
		}
	}

	private static void printRightView(Node node, int level) {
		if (node != null) {
			if (level > rMaxLevel) {
				System.out.println("printing right view : " + node.data);
				rMaxLevel++;
			}
			printRightView(node.right, level + 1);
			printRightView(node.left, level + 1);
		}

	}

	private static void printLeftView(Node node, int level) {
		if (node != null) {
			if (level > lMaxLevel) {
				System.out.println("printing left view : " + node.data);
				lMaxLevel++;
			}

			printLeftView(node.left, level + 1);
			printLeftView(node.right, level + 1);
		}
	}
}
