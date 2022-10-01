package tree;

public class CountSingleValuedTrees {

	public static void main(String[] args) {
		Node node = new Node(5);
		node.left = new Node(1);
		node.right = new Node(5);

		node.left.left = new Node(5);
		node.left.right = new Node(5);
		node.right.right = new Node(5);

		countSingleValuedTrees(node);
		System.out.println("count is : " + count);
	}

	private static int count = 0;

	private static boolean countSingleValuedTrees(Node node) {
		if (node == null) {
			return true;
		}

		if (node.left == null && node.right == null) {
			count++;
			return true;
		}

		boolean l = countSingleValuedTrees(node.left);
		boolean r = countSingleValuedTrees(node.right);

		if (l && r) {
			if (node.left != null && node.right != null && node.data == node.left.data && node.data == node.right.data) {
				count++;
				return true;
			}

			if (node.left == null && node.right != null && node.data == node.right.data) {
				count++;
				return true;
			}

			if (node.left != null && node.right == null && node.data == node.left.data) {
				count++;
				return true;
			}
		}

		return false;

	}

}
