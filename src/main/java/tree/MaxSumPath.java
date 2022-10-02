package tree;

public class MaxSumPath {

    public static void main(String[] args) {

        Node node = new Node(20);
        node.left = new Node(15);
        node.right = new Node(30);

        node.right.left = new Node(2);
        node.right.right = new Node(35);

        int maxSum = getMaxSum(node);
        printMaxSumPath(node, 0, maxSum);
    }

    private static boolean printMaxSumPath(Node node, int sum, int maxSum) {
        if (node == null) {
            return sum == maxSum;
        }

        boolean l = printMaxSumPath(node.left, sum + node.data, maxSum);
        boolean r = printMaxSumPath(node.right, sum + node.data, maxSum);

        if (l || r) {
            System.out.println(node.data);
        }

        return l || r;
    }

    private static int getMaxSum(Node node) {
        if (node == null)
            return 0;

        return node.data + Math.max(getMaxSum(node.left), getMaxSum(node.right));
    }

}
