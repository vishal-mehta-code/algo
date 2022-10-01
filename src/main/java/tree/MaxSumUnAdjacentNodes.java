package tree;

public class MaxSumUnAdjacentNodes {

	public static void main(String[] args) {
		Node node = new Node(1);

		node.left = new Node(2);
		node.right = new Node(3);

		node.left.left = new Node(1);
		node.right.left = new Node(4);
		node.right.right = new Node(5);

		System.out.println("max sum : " + maxSum(node));
	}

	private static int maxSum(Node node) {
		if (node == null) {
			return 0;
		}

		int l = maxSum(node.left);
		int r = maxSum(node.right);

		return (l + r) > node.data ? (l + r) : node.data;
	}

}
