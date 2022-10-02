package tree;

public class InPreToPost {

    static int[] in = {6, 5, 2, 4, 9, 7};
    static int[] pre = {4, 5, 6, 2, 7, 9};

    public static void main(String[] args) {
        toPost(0, in.length - 1);
        Node node = toTree(0, in.length - 1);
        TreeTraversals.postOrder(node);
    }

    private static int preStart1 = 0;

    private static void toPost(int instart, int inend) {
        if (instart > inend) {
            return;
        }

        int root = search(pre[preStart1], instart, inend);

        if (root == -1) {
            return;
        }

        preStart1++;
        toPost(instart, root - 1);
        toPost(root + 1, inend);

        System.out.println(in[root]);
    }

    private static int preStart = 0;

    private static Node toTree(int instart, int inend) {
        if (instart > inend)
            return null;

        int index = search(pre[preStart], instart, inend);

        if (index == -1) {
            return null;
        }

        Node node = new Node(pre[preStart]);
        preStart++;
        node.left = toTree(instart, index - 1);
        node.right = toTree(index + 1, inend);

        return node;
    }

    private static int search(int tobesearched, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (in[i] == tobesearched)
                return i;
        }
        return -1;
    }

}
