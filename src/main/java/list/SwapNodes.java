package list;

public class SwapNodes {

    public static void main(String[] args) {
        Link link = new Link(1);
        link.next = new Link(2);
        link.next.next = new Link(3);
        link.next.next.next = new Link(4);
        link.next.next.next.next = new Link(5);

        int x = 3;
        int y = 4;

        Link swappedLink = swap(link, x, y);
        System.out.println(swappedLink);

    }

    private static Link swap(Link link, int x, int y) {
        Link prevX = null;
        Link prevY = null;
        Link currX = link;
        Link currY = link;

        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if (prevX == null) {
            link = currY;
        } else {
            prevX.next = currY;
        }

        if (prevY == null) {
            link = currX;
        } else {
            prevY.next = currX;
        }

        Link tmp = currX.next;
        currX.next = currY.next;
        currY.next = tmp;

        return link;
    }

}
