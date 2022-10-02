package tree;

public class NodesDistance {

    public static void main(String[] args) {
        Node node = new Node(20);
        node.left = new Node(15);
        node.right = new Node(30);

        node.left.left = new Node(10);
        node.left.right = new Node(16);

        int n1 = 10;
        int n2 = 30;

        int distance = nodeDistance(node, n1, n2);
        System.out.println("distance between nodes is : " + distance);

    }

    private static int nodeDistance(Node node, int n1, int n2) {

        Node lca = lca(node, n1, n2);

        if (!((n1Present && n2Present) || (n1Present && find(lca, n2)) || (n2Present && find(node, n2)))) {
            lca = null;
        }

        if (lca != null) {
            return distance(lca, n1, 0) + distance(lca, n2, 0);
        }

        return -1;

    }

    private static int distance(Node node, int n, int d) {
        if (node == null)
            return 0;
        if (node.data == n)
            return d;

        return Math.max(distance(node.left, n, d + 1), distance(node.right, n, d + 1));
    }

    private static boolean find(Node node, int n) {
        if (node == null) {
            return false;
        }

        return node.data == n || find(node.left, n) || find(node.right, n);
    }

    private static boolean n1Present = false;
    private static boolean n2Present = false;

    private static Node lca(Node node, int n1, int n2) {
        if (node == null)
            return null;

        if (node.data == n1) {
            n1Present = true;
            return node;
        }
        if (node.data == n2) {
            n2Present = true;
            return node;
        }

        Node left = lca(node.left, n1, n2);
        Node right = lca(node.right, n1, n2);

        if (left != null && right != null) {
            return node;
        }

        return left != null ? left : right;
    }
}
