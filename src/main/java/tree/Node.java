package tree;

public class Node {
    public int data;
    public Node left;
    public Node right;
    public Node arb;

    public Node(int value) {
        this.data = value;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + "]";
    }
}
