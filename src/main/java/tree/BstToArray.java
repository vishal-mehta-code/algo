package tree;

import java.util.Arrays;

public class BstToArray {

    private static int[] array = new int[5];
    private static int counter = 0;

    public static void main(String[] args) {
        Node node = new Node(20);
        node.left = new Node(15);
        node.right = new Node(30);

        node.left.left = new Node(2);
        node.left.right = new Node(18);

        bstToArray(node);

        System.out.println(Arrays.toString(array));
    }

    private static void bstToArray(Node node) {
        if (node != null) {
            bstToArray(node.left);
            array[counter] = node.data;
            counter++;
            bstToArray(node.right);
        }
    }
}
