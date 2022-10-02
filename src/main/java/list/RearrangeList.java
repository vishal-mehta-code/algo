package list;

/**
 * Given a singly linked list L0 -> L1 -> � -> Ln-1 -> Ln. Rearrange the nodes
 * in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 ->
 * Ln-2 �
 */
public class RearrangeList {

    private static Link firstHalf = null;
    private static Link secondHalf = null;
    private static Link reversedSecondHalf = null;

    public static void main(String[] args) {
        Link link = new Link(1);
        link.next = new Link(3);
        link.next.next = new Link(5);
        link.next.next.next = new Link(4);
        link.next.next.next.next = new Link(2);

        rearrangeList(link);
    }

    private static void rearrangeList(Link link) {
        split(link);
        reverse(secondHalf);
        Link rerrangedLink = arrange(firstHalf, reversedSecondHalf);
        System.out.println("rearranged link is : " + rerrangedLink);

    }

    private static Link arrange(Link linka, Link linkb) {
        if (linka == null)
            return linkb;

        if (linkb == null)
            return linka;

        Link link = new Link(linka.data);
        link.next = new Link(linkb.data);
        link.next.next = arrange(linka.next, linkb.next);
        return link;
    }

    private static void reverse(Link link) {
        Link prev = null;

        while (link != null) {
            Link next = link.next;
            link.next = prev;
            prev = link;
            link = next;
        }

        System.out.println("reversed list is : " + prev);
        reversedSecondHalf = prev;

    }

    private static void split(Link link) {

        if (link != null) {
            Link slow = link;
            Link fast = link.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            secondHalf = slow.next;
            slow.next = null;
            firstHalf = link;
        }

        System.out.println("first half is : " + firstHalf);
        System.out.println("second half is : " + secondHalf);

    }

}
