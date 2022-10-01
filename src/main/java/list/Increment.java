package list;

public class Increment {

	public static void main(String[] args) {
		Link link = new Link(9);
		link.next = new Link(9);
		link.next.next = new Link(9);
		link.next.next.next = new Link(9);

		System.out.println("printing orignal link");
		print(link);

		increment(link);

		if (carry > 0) {
			Link leftOverLink = new Link(carry);
			leftOverLink.next = link;
			link = leftOverLink;
		}

		System.out.println("printing incremented link");
		print(link);
	}

	private static int carry = 0;

	private static void increment(Link link) {
		if (link == null) {
			return;
		}

		increment(link.next);

		int data = 0;
		if (link.next == null) {
			data = link.data + 1;
		} else {
			data = carry + link.data;
		}

		link.data = data % 10;
		carry = data / 10;
	}

	private static void print(Link link) {
		Link current = link;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

}
