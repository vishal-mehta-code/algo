package list;

import java.util.HashMap;
import java.util.Map;

public class LRU {

	public static void main(String[] args) {
		String str = "abcadefpqaba";
		int max = 5;

		lru(str.toCharArray(), max);
		printList(link);
	}

	private static CharLink link = null;
	private static Map<Character, CharLink> map = new HashMap<>();

	private static void lru(char[] str, int max) {

		for (int i = 0; i < str.length; i++) {
			if (map.get(str[i]) == null) {
				if (link == null) {
					link = new CharLink(str[i]);
				} else {
					CharLink tmpLink = new CharLink(str[i]);
					tmpLink.next = link;
					link.prev = tmpLink;
					link = tmpLink;
				}
			} else {
				CharLink tmpLink = map.get(str[i]);
				CharLink prev = tmpLink.prev;
				CharLink next = tmpLink.next;

				prev.next = next;
				tmpLink.next = null;

				if (tmpLink.prev != null) {
					tmpLink.prev = null;
				}

				tmpLink.next = link;
				link.prev = tmpLink;
				link = tmpLink;
			}

			map.put(str[i], link);

			if (map.size() > max) {
				CharLink tmpLink = link;

				while (tmpLink.next != null) {
					tmpLink = tmpLink.next;
				}

				tmpLink.prev.next = null;
				tmpLink.prev = null;

				map.remove(tmpLink.data);
				tmpLink = null;
			}
		}

	}

	private static void printList(CharLink link) {
		CharLink current = link;
		StringBuilder sb = new StringBuilder();
		while (current != null) {
			sb.append(current.data + " ");
			current = current.next;
		}
		System.out.println("printing list  : " + sb.toString());
	}

}
