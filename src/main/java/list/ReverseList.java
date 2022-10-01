package list;

public class ReverseList {

	public static void main(String[] args) {
		Link link = new Link(1);
		link.next = new Link(2);
		link.next.next = new Link(3);

		reverseList(link);
	}

	private static void reverseList(Link link) {
		Link prev = null;

		while (link != null) {
			Link next = link.next;
			link.next = prev;
			prev = link;
			link = next;
		}
		System.out.println("reversed list is : " + prev);
	}
}
