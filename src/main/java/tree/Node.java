package tree;

public class Node {
	int data;
	Node left;
	Node right;
	Node arb;

	Node(int value) {
		this.data = value;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
}
