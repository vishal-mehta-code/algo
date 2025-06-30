package tree;

import java.util.*;

public class NodesAtKDistanceFromNode {

    static class Pair {
        int val;
        int d;

        Pair(int val, int d) {
            this.val = val;
            this.d = d;
        }
    }

    private static int k = 2;
    private static Node rootNode = new Node(20);
    private static Node targetNode = null;

    public static void main(String[] args) {
        rootNode.left = new Node(8);
        rootNode.right = new Node(22);

        rootNode.left.left = new Node(4);
        rootNode.left.right = new Node(12);

        rootNode.left.right.left = new Node(10);
        rootNode.left.right.right = new Node(14);
        targetNode = rootNode.left;

        nodesAtKDistanceFromNode(rootNode);
        nodesAtKDistanceFromNodeUsingGraph(rootNode);
    }

    private static void nodesAtKDistanceFromNodeUsingGraph(Node rootNode) {
        // Populate the Graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        populateGraph(rootNode, null, graph);
        System.out.println(graph);
        // Traverse the Graph
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(targetNode.data, 0));

        Set<Integer> visited = new HashSet<>();
        visited.add(targetNode.data);

        while (!queue.isEmpty()) {
            Pair curr_node = queue.poll();
            if (curr_node.d == k) {
                System.out.println(curr_node.val);
            }
            List<Integer> neighbours = graph.get(curr_node.val);
            for (Integer n : neighbours) {
                if (!visited.contains(n)) {
                    queue.add(new Pair(n, curr_node.d + 1));
                    visited.add(n);
                }
            }
        }
    }

    private static void populateGraph(Node node, Node parent, Map<Integer, List<Integer>> graph) {
        if (node == null) return;
        List<Integer> neighbors = new ArrayList<>();
        graph.put(node.data, neighbors);
        if (node.left != null) {
            neighbors.add(node.left.data);
        }
        if (node.right != null) {
            neighbors.add(node.right.data);
        }
        if (null != parent) {
            neighbors.add(parent.data);
        }
        populateGraph(node.left, node, graph);
        populateGraph(node.right, node, graph);
    }


    private static Node nodesAtKDistanceFromNode(Node node) {

        if (node != null) {

            if (node == targetNode) {
                printAllDescendantsAtKDistance(node, 0, k);
                return node;
            }

            Node lNode = nodesAtKDistanceFromNode(node.left);
            Node rNode = nodesAtKDistanceFromNode(node.right);

            if (rNode != null) {
                if (k == 1) {
                    System.out.println(node);
                    return null;
                } else {
                    printAllDescendantsAtKDistance(node.left, 0, k - 2);
                    k = k - 1;
                    return node;
                }

            } else if (lNode != null) {
                if (k == 1) {
                    System.out.println(node);
                    return null;
                } else {
                    printAllDescendantsAtKDistance(node.right, 0, k - 2);
                    k = k - 1;
                    return node;
                }
            }

            return null;
        }
        return null;
    }

    private static void printAllDescendantsAtKDistance(Node node, int level, int k) {
        if (node != null) {
            if (level == k) {
                System.out.println(node.data);
            }
            printAllDescendantsAtKDistance(node.left, level + 1, k);
            printAllDescendantsAtKDistance(node.right, level + 1, k);
        }
    }
}
