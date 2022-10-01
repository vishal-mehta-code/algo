package tree;

import linkedlist.Link;

public class ListToBst {

	private static Link link = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		link = new Link(1);
		link.next = new Link(2);
		link.next.next = new Link(3);
		link.next.next.next = new Link(4);
		link.next.next.next.next = new Link(5);

		int length = getLength(link);
		TreeTraversals.preOrder(sortedListToBST(0, length - 1));
	}

	private static Node sortedListToBST(int start, int end) {

		if (start <= end) {
			int mid = start + (end - start) / 2;

			Node lNode = sortedListToBST(start, mid - 1);

			Node node = new Node(link.data);
			node.left = lNode;

			if (link.next != null) {
				link = link.next;
			}

			node.right = sortedListToBST(mid + 1, end);

			return node;

		}
		return null;
	}

	private static int getLength(Link link) {
		int length = 0;
		while (link != null) {
			link = link.next;
			length++;
		}
		System.out.println("length is : " + length);
		return length;
	}

}
