package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public char value;
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean isWord;

    public TrieNode(char value) {
        this.value = value;
    }

    public TrieNode() {
    }
}
