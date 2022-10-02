package list;

public class Link {
    public int data;
    public Link next;
    public Link arb;

    public Link(int data) {
        this.data = data;
    }

    public Link() {
    }

    @Override
    public String toString() {
        return "Link [data=" + data + ", next=" + next + "]";
    }

}
