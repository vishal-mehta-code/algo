package list;

public class IsPalindrome {

	public static void main(String[] args) {
		Link link = new Link(1);
		link.next = new Link(2);
		link.next.next = new Link(2);
		link.next.next.next = new Link(1);
		link.next.next.next.next = new Link(1);

		Link firstHalf = null;
		Link secondHalf = null;
		Link slow = null;

		Link prev = null;
		Link mid = null;

		prev = link;
		slow = link;
		Link fast = link;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null) {
			secondHalf = slow.next;
			slow.next = null;
			mid = slow;
			prev.next = null;
			firstHalf = link;
		} else {
			secondHalf = prev.next;
			prev.next = null;
			firstHalf = link;
		}

		Link reversedSecondHalf = reverse(secondHalf);

		System.out.println("is palindrome : " + compare(firstHalf, reversedSecondHalf));

		secondHalf = reverse(reversedSecondHalf);
		if (mid == null) {
			prev.next = secondHalf;
		} else {
			prev.next = mid;
			mid.next = secondHalf;
		}

		System.out.println("reconstructed list : " + link);
	}

	private static boolean compare(Link linka, Link linkb) {
		if (linka == null && linkb == null)
			return true;
		if (linka == null || linkb == null)
			return false;
		if (linka.data != linkb.data)
			return false;

		return compare(linka.next, linkb.next);

	}

	private static Link reverse(Link link) {
		Link prev = null;
		Link next = null;

		while (link != null) {
			next = link.next;
			link.next = prev;
			prev = link;
			link = next;
		}

		return prev;

	}

}
