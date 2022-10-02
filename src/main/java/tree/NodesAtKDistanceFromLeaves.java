package tree;

import java.util.HashSet;
import java.util.Set;

public class NodesAtKDistanceFromLeaves {

    private static int k = 2;

    public static void main(String[] args) {

        Node rootNode = new Node(1);
        rootNode.left = new Node(2);
        rootNode.right = new Node(3);

        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(5);
        rootNode.right.left = new Node(6);
        rootNode.right.right = new Node(7);

        rootNode.left.right.left = new Node(11);
        rootNode.right.left.right = new Node(8);

        int h = getHeight(rootNode);
        pathArray = new Node[h];
        nodesAtKDistanceFromLeaves(rootNode, 0);
        System.out.println(set);
    }

    private static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private static Set<Node> set = new HashSet<>();
    private static Node[] pathArray;

    private static void nodesAtKDistanceFromLeaves(Node node, int pathLength) {

        if (node == null) {
            return;
        }

        pathArray[pathLength] = node;

        if (node.left == null && node.right == null && pathLength - k >= 0 && !set.contains(node)) {
            set.add(pathArray[pathLength - k]);
        }

        nodesAtKDistanceFromLeaves(node.left, pathLength + 1);
        nodesAtKDistanceFromLeaves(node.right, pathLength + 1);
    }
}
