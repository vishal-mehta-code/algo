package list;

import java.util.HashMap;
import java.util.Map;

public class Clone {

	public static void main(String[] args) {
		Link link = new Link(1);
		link.next = new Link(3);
		link.next.next = new Link(5);

		link.arb = link.next.next;
		link.next.arb = link;
		link.next.next.arb = link.next;

		Link clone = clone(link);
		while (clone != null) {
			System.out.println(clone);
			clone = clone.next;
		}
	}

	static Map<Link, Link> map = new HashMap<>();

	private static Link clone(Link link) {
		Link current = link;
		Link clone;
		while (current != null) {
			clone = new Link(current.data);
			map.put(current, clone);
			current = current.next;
		}

		current = link;
		while (current != null) {
			clone = map.get(current);
			clone.next = map.get(current.next);
			clone.arb = map.get(current.arb);
			current = current.next;
		}

		return map.get(link);
	}

}
