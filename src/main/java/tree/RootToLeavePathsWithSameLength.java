package tree;

import java.util.Map;
import java.util.TreeMap;

public class RootToLeavePathsWithSameLength {

	public static void main(String[] args) {
		Node node = new Node(1);

		node.left = new Node(2);
		node.right = new Node(3);

		node.left.left = new Node(1);
		node.right.left = new Node(4);
		node.right.right = new Node(5);

		collectByLengthFromRootToLeave(node, 0);
		System.out.println(map);
	}

	private static Map<Integer, Integer> map = new TreeMap<>();

	private static void collectByLengthFromRootToLeave(Node node, int pathLength) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			if (map.get(pathLength) == null) {
				map.put(pathLength, 1);
			} else {
				map.put(pathLength, map.get(pathLength) + 1);
			}
		}

		collectByLengthFromRootToLeave(node.left, pathLength + 1);
		collectByLengthFromRootToLeave(node.right, pathLength + 1);
	}

}
