package tree;

public class TreeWeight {

	public static void main(String[] args) {
		Node node = new Node(10);
		node.left = new Node(5);
		node.right = new Node(20);

		node.left.left = new Node(6);
		node.right.right = new Node(19);

		int weight = calculateTreeWeight(node, 1);
		System.out.println("Tree weight is : " + weight);

		int maxWeightOfBst = maxWeightBst(node, 1);
		System.out.println("max weight of bst : " + maxWeightOfBst);

	}

	private static int maxWeightBst(Node node, int lvl) {
		if (node == null)
			return 0;
		if (BstValidation.isBst(node, Integer.MIN_VALUE, Integer.MAX_VALUE))
			return calculateTreeWeight(node, lvl);

		return Math.max(maxWeightBst(node.left, lvl + 1), maxWeightBst(node.right, lvl + 1));
	}

	private static int calculateTreeWeight(Node node, int lvl) {
		if (node == null)
			return 0;

		return node.data * lvl + calculateTreeWeight(node.left, lvl + 1) + calculateTreeWeight(node.right, lvl + 1);
	}

}
