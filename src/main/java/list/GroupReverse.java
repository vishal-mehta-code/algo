package list;

public class GroupReverse {
    private static int k = 2;

    public static void main(String[] args) {

        Link link = new Link(1);
        link.next = new Link(3);
        link.next.next = new Link(5);
        link.next.next.next = new Link(4);
        link.next.next.next.next = new Link(2);

        Link groupReversedLink = groupReverse(link);
        System.out.println(groupReversedLink);
    }

    private static Link groupReverse(Link link) {
        Link prev = null;
        int count = 0;
        Link current = link;
        Link next = null;
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (current != null) {
            link.next = groupReverse(current);
        }

        return prev;

    }

}
