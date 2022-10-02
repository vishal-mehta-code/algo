package narray;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int data;
    public List<Node> chidren;

    public Node(int data) {
        this.data = data;
        this.chidren = new ArrayList<>();
    }

    public void addChildren(Node node) {
        chidren.add(node);
    }

    @Override
    public String toString() {
        return "Node [data=" + data + "]";
    }

}
