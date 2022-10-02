package trie;

public class Search {

    public static void main(String[] args) {
        String[] strs = {"vishal", "vivek"};

        TrieNode node = Insert.insert(strs);

        searchKey("vivek", node);
    }

    private static void searchKey(String str, TrieNode node) {
        boolean keyFound = false;
        TrieNode currNode = node;
        char[] strarray = str.toCharArray();
        for (int i = 0; i < strarray.length; i++) {
            char current = strarray[i];

            boolean found = false;
            for (TrieNode child : currNode.children) {
                if (child.value == current) {
                    found = true;
                    currNode = child;
                }
            }

            if (!found) {
                System.out.println("can not be found");
                return;
            } else if (found && i == str.length() - 1 && currNode.leaf) {
                keyFound = true;
            }
        }

        System.out.println("key found : " + keyFound);
    }
}
