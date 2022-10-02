package tree;

public class MaxSumBetweenLeaves {

    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(2);
        node.right = new Node(7);

        node.right.left = new Node(16);
        node.right.right = new Node(8);

        maxSumBetweenLeaves(node);

        System.out.println("max sum between leaves : " + maxSum);

    }

    private static int maxSumBetweenLeaves(Node node) {
        if (node == null)
            return 0;

        int ls = maxSumBetweenLeaves(node.left);
        int rs = maxSumBetweenLeaves(node.right);

        if (ls + rs + node.data > maxSum)
            maxSum = ls + rs + node.data;

        return Math.max(ls, rs) + node.data;
    }

}
