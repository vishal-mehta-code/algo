package tree;

import java.util.HashMap;
import java.util.Map;

public class PairOnRootToLeafWithSum {

    private static int sum = 4;

    public static void main(String[] args) {
        Node node = new Node(1);

        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(1);
        node.right.left = new Node(4);
        node.right.right = new Node(5);

        int h = getHeight(node);
        pathArray = new int[h];
        findPair(node, 0);
    }

    private static int[] pathArray = null;

    private static void findPair(Node node, int pathLength) {
        if (node == null) {
            return;
        }

        pathArray[pathLength] = node.data;
        if (node.left == null && node.right == null) {
            findPairUtil();
        }

        findPair(node.left, pathLength + 1);
        findPair(node.right, pathLength + 1);
    }

    private static void findPairUtil() {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < pathArray.length; i++) {
            if (map.containsKey(pathArray[i])) {
                System.out.println("pair found at : " + map.get(pathArray[i]) + " and " + i);
            }

            map.put(sum - pathArray[i], i);
        }
    }

    private static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

}
