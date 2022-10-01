package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MultiplicationOfSumOfLeavesAtLevel {

	public static void main(String[] args) {
		Node node = new Node(20);
		node.left = new Node(15);
		node.right = new Node(30);

		node.left.left = new Node(10);
		node.left.right = new Node(16);

		multiplicationOfSumOfLeavesAtLevel(node);

	}

	private static void multiplicationOfSumOfLeavesAtLevel(Node node) {
		collectSumsAtLevel(node, 0);

		Set<Entry<Integer, Integer>> set = sumsAtLevel.entrySet();

		int mul = 1;
		for (Entry<Integer, Integer> entry : set) {
			mul = mul * entry.getValue();
		}

		System.out.println("mul is : " + mul);

	}

	private static Map<Integer, Integer> sumsAtLevel = new HashMap<>();

	private static void collectSumsAtLevel(Node node, int level) {
		if (node != null) {

			if (node.left == null && node.right == null) {
				if (sumsAtLevel.containsKey(level)) {
					sumsAtLevel.put(level, sumsAtLevel.get(level) + node.data);
				} else {
					sumsAtLevel.put(level, node.data);
				}
			}

			collectSumsAtLevel(node.left, level + 1);
			collectSumsAtLevel(node.right, level + 1);
		}

	}
}
