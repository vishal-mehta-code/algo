package trie;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"vishal", "vivek"};

        TrieNode node = Insert.insert(strs);

        longestCommonPrefix(node);
    }

    private static void longestCommonPrefix(TrieNode node) {
        int max = 0;
        TrieNode currNode = node;

        while (currNode.children.size() == 1) {
            max++;
            currNode = currNode.children.entrySet().iterator().next().getValue();
        }

        System.out.println("max common prefix is : " + max);
    }

}
