package tree;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeViewSums {

    private static Map<Integer, Integer> horizontalSumsMap = new TreeMap<>();
    private static Map<Integer, Integer> verticalSumsMap = new TreeMap<>();
    private static Map<Integer, Integer> diagonalSumsMap = new TreeMap<>();

    public static void main(String[] args) {
        Node node = new Node(20);
        node.left = new Node(8);
        node.right = new Node(22);

        node.right.right = new Node(25);

        node.left.left = new Node(5);
        node.left.right = new Node(3);

        node.left.right.left = new Node(10);
        node.left.right.right = new Node(14);

        collectHorizontalSum(node, 0);
        Set<Entry<Integer, Integer>> horizontalSumsSet = horizontalSumsMap.entrySet();
        for (Entry<Integer, Integer> entry : horizontalSumsSet) {
            System.out.println("printing horizontal sum : " + entry.getValue());
        }

        collectVerticalSums(node, 0);
        Set<Entry<Integer, Integer>> verticalSumsSet = verticalSumsMap.entrySet();
        for (Entry<Integer, Integer> entry : verticalSumsSet) {
            System.out.println("printing vertical sum : " + entry.getValue());
        }

        collectDiagonalSums(node, 0);
        Set<Entry<Integer, Integer>> diagonalSumsSet = diagonalSumsMap.entrySet();
        for (Entry<Integer, Integer> entry : diagonalSumsSet) {
            System.out.println("printing diagonal sum : " + entry.getValue());
        }

    }

    private static void collectHorizontalSum(Node node, int level) {
        if (node != null) {
            if (horizontalSumsMap.get(level) == null) {
                horizontalSumsMap.put(level, node.data);
            } else {
                horizontalSumsMap.put(level, horizontalSumsMap.get(level) + node.data);
            }

            collectHorizontalSum(node.left, level + 1);
            collectHorizontalSum(node.right, level + 1);
        }
    }

    private static void collectDiagonalSums(Node node, int level) {
        if (node != null) {
            if (diagonalSumsMap.get(level) == null)
                diagonalSumsMap.put(level, node.data);
            else
                diagonalSumsMap.put(level, diagonalSumsMap.get(level) + node.data);

            collectDiagonalSums(node.right, level);
            collectDiagonalSums(node.left, level + 1);
        }
    }

    private static void collectVerticalSums(Node node, int level) {
        if (node != null) {
            if (verticalSumsMap.get(level) == null)
                verticalSumsMap.put(level, node.data);
            else
                verticalSumsMap.put(level, verticalSumsMap.get(level) + node.data);

            collectVerticalSums(node.left, level - 1);
            collectVerticalSums(node.right, level + 1);
        }
    }
}
