package list;

import java.util.HashMap;
import java.util.Map;

public class LongestSequence {

	public static void main(String[] args) {
		Link link = new Link(1);
		link.next = new Link(2);
		link.next.next = new Link(3);
		link.next.next.next = new Link(4);
		link.next.next.next.next = new Link(3);
		link.next.next.next.next.next = new Link(2);
		link.next.next.next.next.next.next = link;

		longestSequence(link);
	}

	private static Map<Integer, Integer> map = new HashMap<>();
	private static int maxStartIndex = 0;
	private static int maxEndIndex = 0;
	private static int max = Integer.MIN_VALUE;

	private static void longestSequence(Link link) {
		Link start = link;
		int index = 1;

		while (link.next != start) {
			link = link.next;

			if (map.get(link.data) == null) {
				map.put(link.data, index);
			} else {

				int currStartIndex = map.get(link.data);

				if (index - currStartIndex > max) {
					max = index - currStartIndex;
					maxStartIndex = currStartIndex;
					maxEndIndex = index;
				}

			}

			index++;
		}

		System.out.println("max sequence is : " + max);
		System.out.println("max start index is : " + maxStartIndex);
		System.out.println("max end index is : " + maxEndIndex);
	}
}
