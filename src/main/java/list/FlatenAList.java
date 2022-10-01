package list;

public class FlatenAList {

	public static void main(String[] args) {
		Link link = new Link(1);

		link.next = new Link(2);
		link.next.arb = new Link(3);
		link.next.arb.next = new Link(4);
		link.next.arb.next.next = new Link(5);

		link.next.next = new Link(6);
		link.next.next.arb = new Link(7);
		link.next.next.arb.next = new Link(8);

		link.next.next.arb.next.arb = new Link(9);

		printList(flatenAList(link));
	}

	private static Link flatenAList(Link link) {
		Link current = link;

		Link next = link;
		while (current != null) {
			next = current.next;
			if (current.arb != null) {
				Link flatenLink = flatenAList(current.arb);
				current.next = flatenLink;
				current.arb = null;

				Link tmp = flatenLink;

				while (tmp.next != null) {
					tmp = tmp.next;
				}

				tmp.next = next;
				current = next;
			} else {
				current = current.next;
			}
		}

		return link;
	}

	private static void printList(Link link) {
		Link current = link;

		StringBuilder sb = new StringBuilder();
		while (current != null) {
			sb.append(current.data + " ");
			current = current.next;
		}

		System.out.println("printing list : " + sb.toString());
	}
}
