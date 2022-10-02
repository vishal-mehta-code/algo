package tree;

public class MirrorImage {

    public static void main(String[] args) {
        Node node = new Node(20);
        node.left = new Node(15);
        node.right = new Node(30);

        node.left.left = new Node(2);
        node.left.right = new Node(18);

        mirrorImage(node);
        TreeTraversals.inOrder(node);

    }

    private static Node mirrorImage(Node node) {
        if (node != null) {
            Node left = mirrorImage(node.left);
            Node right = mirrorImage(node.right);

            node.right = left;
            node.left = right;

            return node;
        }
        return null;
    }
}
