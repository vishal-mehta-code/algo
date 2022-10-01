package tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AssighnNeighbours {

	public static void main(String[] args) {
		Node node = new Node(20);
		node.left = new Node(15);
		node.right = new Node(30);

		node.left.left = new Node(17);
		node.left.right = new Node(18);
		node.right.left = new Node(25);
		node.right.right = new Node(35);

		node.left.left.left = new Node(19);
		node.left.left.right = new Node(21);
		node.right.right.right = new Node(50);

		assighnNeighboursForCompleteTree(node, null);
		assighnNeighbours(node);
		assighnNeighboursVertically(node);

		TreeTraversals.inOrder(node);
	}

	private static void assighnNeighboursVertically(Node node) {
		collectNodesVerticallyByLevel(node, 0, 0);
		System.out.println(mapByVerticalDistance);

		for (Entry<Integer, Map<Integer, List<Node>>> entryByVerticalDistance : mapByVerticalDistance.entrySet()) {
			Map<Integer, List<Node>> mapByLevels = entryByVerticalDistance.getValue();

			Node prev = null;
			for (Entry<Integer, List<Node>> entryByLevel : mapByLevels.entrySet()) {
				List<Node> nodesAtLevel = entryByLevel.getValue();
				for (Node n : nodesAtLevel) {
					if (prev == null) {
						break;
					} else {
						n.arb = prev;
					}
				}
				prev = nodesAtLevel.get(0);
			}

		}
	}

	private static Map<Integer, Map<Integer, List<Node>>> mapByVerticalDistance = new LinkedHashMap<>();

	private static void collectNodesVerticallyByLevel(Node node, int vd, int level) {
		if (node == null) {
			return;
		}

		if (mapByVerticalDistance.get(vd) == null) {
			Map<Integer, List<Node>> mapByLevels = new LinkedHashMap<>();
			List<Node> list = new ArrayList<>();
			list.add(node);
			mapByLevels.put(level, list);
			mapByVerticalDistance.put(vd, mapByLevels);
		} else {

			Map<Integer, List<Node>> mapByLevels = mapByVerticalDistance.get(vd);

			List<Node> list = mapByLevels.get(level);
			if (list == null) {
				list = new ArrayList<>();
				list.add(node);
				mapByLevels.put(level, list);
			} else {
				list.add(node);
			}

		}

		collectNodesVerticallyByLevel(node.left, vd - 1, level + 1);
		collectNodesVerticallyByLevel(node.right, vd + 1, level + 1);
	}

	private static void assighnNeighbours(Node node) {
		collectNodesByLevel(node, 0);

		for (Entry<Integer, List<Node>> entry : map.entrySet()) {
			List<Node> nodesAtLevel = entry.getValue();
			if (nodesAtLevel.size() > 1) {
				Node prev = null;
				for (Node n : nodesAtLevel) {
					if (prev == null) {
						prev = n;
					} else {
						prev.arb = n;
						prev = n;
					}
				}
			}
		}
	}

	private static Map<Integer, List<Node>> map = new LinkedHashMap<>();

	private static void collectNodesByLevel(Node node, int lvl) {
		if (node == null) {
			return;
		}

		List<Node> nodesAtLevel = map.get(lvl);

		if (nodesAtLevel == null) {
			nodesAtLevel = new ArrayList<Node>();
		}

		nodesAtLevel.add(node);
		map.put(lvl, nodesAtLevel);

		collectNodesByLevel(node.left, lvl + 1);
		collectNodesByLevel(node.right, lvl + 1);
	}

	private static void assighnNeighboursForCompleteTree(Node node, Node parent) {
		if (node != null) {
			if (parent != null) {
				if (parent.left == node) {
					node.arb = parent.right;
				} else if (parent.arb != null) {
					node.arb = parent.arb.left != null ? parent.arb.left : parent.arb.right;
				}
			}

			assighnNeighboursForCompleteTree(node.left, node);
			assighnNeighboursForCompleteTree(node.right, node);
		}
	}
}
