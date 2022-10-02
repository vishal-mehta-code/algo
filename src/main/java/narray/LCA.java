package narray;

import java.util.List;

public class LCA {

    public static void main(String[] args) {

        Node n1 = new Node(1);

        Node n1c1 = new Node(2);
        Node n1c2 = new Node(3);
        Node n1c3 = new Node(4);

        n1.addChildren(n1c1);
        n1.addChildren(n1c2);
        n1.addChildren(n1c3);

        Node n1c1c1 = new Node(5);
        Node n1c1c2 = new Node(6);
        Node n1c1c3 = new Node(7);

        n1c1.addChildren(n1c1c1);
        n1c1.addChildren(n1c1c2);
        n1c1.addChildren(n1c1c3);

        Node nodeA = n1c1c3;
        Node nodeB = n1c1c2;

        System.out.println(lca(n1, nodeA, nodeB));
    }

    private static Node lca(Node node, Node nodeA, Node nodeB) {
        if (node == null)
            return null;
        if (node.data == nodeA.data || node.data == nodeB.data)
            return node;

        List<Node> children = node.chidren;
        int count = 0;
        Node lca = null;
        for (Node n : children) {
            Node tmpNode = lca(n, nodeA, nodeB);

            if (tmpNode != null) {
                lca = tmpNode;
                count++;
            }
        }
        if (count == 2) {
            return node;
        }

        return lca;
    }
}
