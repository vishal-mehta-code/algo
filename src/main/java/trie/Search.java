package trie;

public class Search {

    public static void main(String[] args) {
        String[] strs = {"vishal", "vivek", "hotdog"};

        TrieNode node = Insert.insert(strs);

        boolean found = searchKey("vivek", node);
        System.out.println(found);

        boolean startsWith = startsWith("dog", node);
        System.out.println(startsWith);
    }

    private static boolean searchKey(String str, TrieNode node) {
        TrieNode currNode = node;

        for (char curr : str.toCharArray()) {
            if (currNode.children.get(curr) == null) {
                return false;
            }
            currNode = currNode.children.get(curr);
        }

        return currNode.isWord;
    }

    private static boolean startsWith(String str, TrieNode node) {
        TrieNode currNode = node;

        for (char curr : str.toCharArray()) {
            if (currNode.children.get(curr) == null) {
                return false;
            }
            currNode = currNode.children.get(curr);
        }

        return true;
    }
}
