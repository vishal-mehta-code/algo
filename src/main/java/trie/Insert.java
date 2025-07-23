package trie;

public class Insert {

    // Create a root Trie Node
    private static TrieNode rootNode = new TrieNode();

    public static void main(String[] args) {
        String[] strs = {"vishal", "vivek"};

        insert(strs);
    }

    public static TrieNode insert(String[] strs) {
        for (String str : strs) {
            insert(str);
        }

        return rootNode;
    }

    private static void insert(String str) {
        TrieNode currNode = rootNode;
        char[] strArray = str.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            char current = strArray[i];

            if (currNode.children.isEmpty()) {
                TrieNode t = new TrieNode(current);
                currNode.children.add(t);
                currNode = t;
            } else {
                boolean found = false;
                for (TrieNode child : currNode.children) {
                    if (child.value == current) {
                        found = true;
                        currNode = child;
                    }
                }

                if (!found) {
                    TrieNode t = new TrieNode(current);
                    currNode.children.add(t);
                    currNode = t;
                }
            }

            if (i == strArray.length - 1) {
                currNode.isWord = true;
            }
        }
    }
}
