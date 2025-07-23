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
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char current = charArray[i];

            boolean found = false;
            for (TrieNode child : currNode.children) {
                if (child.value == current) {
                    found = true;
                    currNode = child;
                }
            }

            if (!found) {
                System.out.println("can not be found");
                break;
            } else if (currNode.isWord) {
                keyFound = true;
                break;
            }
        }

        System.out.println("key found : " + keyFound);
    }
}
