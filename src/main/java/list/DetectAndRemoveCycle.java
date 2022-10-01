package list;

public class DetectAndRemoveCycle {

	public static void main(String[] args) {

		Link link = new Link(1);
		link.next = new Link(2);
		link.next.next = new Link(3);
		link.next.next.next = new Link(4);
		link.next.next.next.next = link;

		System.out.println("printing after breaking the loop : " + detectAndRemoveCycle(link));

	}

	private static Link detectAndRemoveCycle(Link link) {
		Link curr = link;
		Link slow = link;
		Link fast = link.next;

		while (fast != null && fast.next != null) {
			if (slow == fast) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		// If there is a cycle
		if (slow == fast) {
			while (curr != fast.next) {
				curr = curr.next;
				fast = fast.next;
			}

			fast.next = null;

		}
		return link;
	}
}
