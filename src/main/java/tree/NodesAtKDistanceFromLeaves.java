package tree;

import java.util.*;

public class NodesAtKDistanceFromLeaves {

    static class Pair {
        int val;
        int d;

        Pair(int val, int d) {
            this.val = val;
            this.d = d;
        }
    }

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

        nodesAtKDistanceFromLeavesUsingGraph(rootNode);
    }

    private static void nodesAtKDistanceFromLeavesUsingGraph(Node rootNode) {
        // Populate the graph. Also keep track of the leaf nodes
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> leaves = new HashSet<>();
        populateGraph(rootNode, null, graph, leaves);
        // Traverse the graph for each leave now
        for (Integer leaf : leaves) {
            traverseGraph(graph, leaf);
        }
    }

    private static void traverseGraph(Map<Integer, List<Integer>> graph, Integer leaf) {
        Set<Integer> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(leaf, 0));
        visited.add(leaf);
        while (!queue.isEmpty()) {
            Pair curr_pair = queue.poll();
            if (curr_pair.d == k) {
                System.out.println("node at : " + k + " distance from leaf : " + leaf + " is : " + curr_pair.val);
            }
            List<Integer> neighbors = graph.get(curr_pair.val);
            for (Integer n : neighbors) {
                if (!visited.contains(n)) {
                    queue.add(new Pair(n, curr_pair.d + 1));
                    visited.add(n);
                }
            }
        }
    }

    private static void populateGraph(Node node, Node parent, Map<Integer, List<Integer>> graph, Set<Integer> leaves) {
        if (node == null) return;
        List<Integer> neighbours = new ArrayList<>();
        graph.put(node.data, neighbours);
        if (node.left == null && node.right == null && !leaves.contains(node.data)) {
            leaves.add(node.data);
        }
        if (node.left != null) {
            neighbours.add(node.left.data);
        }
        if (node.right != null) {
            neighbours.add(node.right.data);
        }
        if (parent != null) {
            neighbours.add(parent.data);
        }

        populateGraph(node.left, node, graph, leaves);
        populateGraph(node.right, node, graph, leaves);
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
