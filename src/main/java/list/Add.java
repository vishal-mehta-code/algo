package list;

public class Add {

    public static void main(String[] args) {
        Link link1 = new Link(5);
        link1.next = new Link(6);

        Link link2 = new Link(9);
        link2.next = new Link(9);
        link2.next.next = new Link(6);
        link2.next.next.next = new Link(4);

        Link result = add(link1, link2);

        print(result);
    }

    private static int carry = 0;

    private static Link add(Link link1, Link link2) {
        int l1 = getLength(link1);
        int l2 = getLength(link2);

        Link result = null;
        if (l1 == l2) {
            result = addSameSize(link1, link2);
        } else {
            if (l2 > l1) {
                Link tmp = link1;
                link1 = link2;
                link2 = tmp;
            }

            Link current = link1;
            int diff = Math.abs(l1 - l2);
            while (diff > 0) {
                current = current.next;
                diff--;
            }

            Link sameSizeAddResult = addSameSize(current, link2);

            Link restAddResult = addRest(link1, Math.abs(l1 - l2));

            Link iter = restAddResult;
            while (iter.next != null) {
                iter = iter.next;
            }

            iter.next = sameSizeAddResult;
            result = restAddResult;
        }

        if (carry > 0) {
            Link link = new Link(carry);
            link.next = result;
            result = link;
        }

        return result;
    }

    private static Link addRest(Link link1, int diff) {
        if (diff == 0) {
            return null;
        }

        Link result = new Link();
        result.next = addRest(link1.next, diff - 1);
        int data = link1.data + carry;
        result.data = data % 10;
        carry = data / 10;

        return result;
    }

    private static Link addSameSize(Link link1, Link link2) {
        if (link1 == null && link2 == null) {
            return null;
        }

        Link result = new Link();
        result.next = addSameSize(link1.next, link2.next);

        int data = link1.data + link2.data + carry;
        result.data = data % 10;
        carry = data / 10;

        return result;
    }

    private static int getLength(Link link) {
        int length = 0;
        Link current = link;
        while (null != current) {
            length++;
            current = current.next;
        }
        return length;
    }

    private static void print(Link link) {
        Link current = link;
        while (null != current) {
            System.out.println(current.data);
            current = current.next;
        }

    }

}
