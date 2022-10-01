package tree;

public class ArrayToBst {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] inOrderArray = { 1, 4, 7, 9, 10 };
		Node node = inOrderArrayToBst(inOrderArray, 0, inOrderArray.length - 1);
		TreeTraversals.inOrder(node);

		int[] preOrderArray = { 10, 5, 1, 7, 40, 50 };
		node = preOrderArrayToBst(preOrderArray, 0, preOrderArray.length - 1);
		TreeTraversals.inOrder(node);

		int[] postOrderArray = { 1, 7, 5, 50, 40, 10 };
		node = postOrderArrayToBst(postOrderArray, 0, postOrderArray.length - 1);
		TreeTraversals.inOrder(node);
	}

	private static Node postOrderArrayToBst(int[] postOrderArray, int start, int end) {
		if (start <= end) {
			Node node = new Node(postOrderArray[end]);

			int breakPoint = start;

			while (breakPoint < end && postOrderArray[breakPoint] < postOrderArray[end]) {
				breakPoint++;
			}

			node.left = postOrderArrayToBst(postOrderArray, start, breakPoint - 1);
			node.right = postOrderArrayToBst(postOrderArray, breakPoint, end - 1);

			return node;
		}

		return null;
	}

	private static Node preOrderArrayToBst(int[] preOrderArray, int start, int end) {
		if (start <= end) {
			Node node = new Node(preOrderArray[start]);

			int breakPoint = start + 1;

			while (breakPoint <= end && preOrderArray[start] > preOrderArray[breakPoint]) {
				breakPoint++;
			}

			node.left = preOrderArrayToBst(preOrderArray, start + 1, breakPoint - 1);
			node.right = preOrderArrayToBst(preOrderArray, breakPoint, end);

			return node;
		}

		return null;
	}

	private static Node inOrderArrayToBst(int[] array, int start, int end) {
		if (start <= end) {
			int mid = start + (end - start) / 2;
			Node node = new Node(array[mid]);
			node.left = inOrderArrayToBst(array, start, mid - 1);
			node.right = inOrderArrayToBst(array, mid + 1, end);

			return node;
		}
		return null;
	}
}
