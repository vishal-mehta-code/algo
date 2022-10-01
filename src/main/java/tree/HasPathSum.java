package tree;

public class HasPathSum {

	public static void main(String[] args) {
		Node node = new Node(20);
		node.left = new Node(15);
		node.right = new Node(30);

		node.left.left = new Node(10);
		node.left.right = new Node(16);
		System.out.println(hasPathSum(node, 51));

	}

	private static boolean hasPathSum(Node node, int sum) {
		if (node == null)
			return sum == 0;
		return hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data);
	}
}
