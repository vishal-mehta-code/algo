package list;

public class SortList {

	public static void main(String[] args) {

		Link link = new Link(1);
		link.next = new Link(5);
		link.next.next = new Link(4);
		link.next.next.next = new Link(2);
		link.next.next.next.next = new Link(3);

		Link sorted = sort(link);

		System.out.println(sorted);

	}

	private static Link sort(Link link) {

		if (link == null || link.next == null)
			return link;

		Link firstHalf = null;
		Link secondHalf = null;

		Link slow = link;
		Link fast = link;
		Link prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast == null) {
			secondHalf = prev.next;
			prev.next = null;
			firstHalf = link;
		} else {
			secondHalf = slow.next;
			slow.next = null;
			firstHalf = link;
		}

		firstHalf = sort(firstHalf);
		secondHalf = sort(secondHalf);

		return merge(firstHalf, secondHalf);
	}

	private static Link merge(Link linka, Link linkb) {
		if (linka == null)
			return linkb;
		if (linkb == null)
			return linka;

		Link link = null;
		if (linka.data >= linkb.data) {
			link = linkb;
			link.next = merge(linka, linkb.next);
		} else {
			link = linka;
			link.next = merge(linka.next, linkb);
		}

		return link;
	}

}
