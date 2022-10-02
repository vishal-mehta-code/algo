package tree;

public class QueueItem {
    Node node;
    int hd;

    public QueueItem(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }

    public QueueItem(Node node) {
        this.node = node;
    }
}