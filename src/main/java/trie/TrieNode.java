package trie;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
	public char value;
	public List<TrieNode> children = new ArrayList<>();
	public boolean leaf;

	public TrieNode(char value) {
		super();
		this.value = value;
	}

	public TrieNode() {
		super();
	}
}
