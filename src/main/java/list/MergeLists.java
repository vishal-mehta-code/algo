package list;

public class MergeLists {

	public static void main(String[] args) {
		Link linka = new Link(1);
		linka.next = new Link(2);
		linka.next.next = new Link(20);

		Link linkb = new Link(4);
		linkb.next = new Link(5);

		Link link = merge(linka, linkb);

		System.out.println(link);
	}

	private static Link merge(Link linka, Link linkb) {

		if (linka == null)
			return linkb;

		if (linkb == null)
			return linka;

		Link link = null;
		if (linka.data <= linkb.data) {
			link = linka;
			link.next = merge(linka.next, linkb);
		} else {
			link = linkb;
			link.next = merge(linka, linkb.next);
		}

		return link;
	}
}
