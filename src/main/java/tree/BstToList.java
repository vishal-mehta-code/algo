package tree;

public class BstToList {

    public static void main(String[] args) {
        Node node = new Node(20);
        node.left = new Node(15);
        node.right = new Node(30);

        node.left.left = new Node(17);
        node.left.right = new Node(18);
        node.right.left = new Node(25);
        node.right.right = new Node(35);

        node.left.left.left = new Node(19);
        node.left.left.right = new Node(21);
        node.right.right.right = new Node(50);

        bstToList(node, node);
        print(node);

    }

    private static void print(Node node) {
        // we must go to extreme left to start
        while (node.left != null) {
            node = node.left;
        }

        while (node != null) {
            System.out.println(node.data);
            node = node.right;
        }
    }

    private static Node bstToList(Node node, Node root) {

        if (node == null) {
            return null;
        }

        Node l = bstToList(node.left, root);
        Node r = bstToList(node.right, root);

        if (r != null) {
            while (r.left != null) {
                r = r.left;
            }

            node.right = r;
            r.left = node;
        }

        if (l != null) {
            while (l.right != null) {
                l = l.right;
            }

            l.right = node;
            node.left = l;
        }

        return node;
    }

}
