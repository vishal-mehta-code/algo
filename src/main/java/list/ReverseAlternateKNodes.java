package list;

public class ReverseAlternateKNodes {

	public static void main(String[] args) {
		int k = 2;

		Link link = new Link(1);
		link.next = new Link(2);
		link.next.next = new Link(3);
		link.next.next.next = new Link(4);
		link.next.next.next.next = new Link(5);
		link.next.next.next.next.next = new Link(6);

		Link modifiedLink = reverseAlternateKNodes(link, k);
		System.out.println(modifiedLink);

	}

	private static Link reverseAlternateKNodes(Link link, int k) {

		Link current = link;
		Link prev = null;
		Link next = null;
		int count = 0;

		while (current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		link.next = current;
		while (current != null && count > 1) {
			current = current.next;
			count--;
		}

		if (current != null && current.next != null) {
			current.next = reverseAlternateKNodes(current.next, k);
		}

		return prev;
	}

}
