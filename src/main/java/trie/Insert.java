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
        for (char curr : str.toCharArray()) {
            currNode = currNode.children.computeIfAbsent(curr, n -> new TrieNode(curr));
        }
        currNode.isWord = true;
    }
}
