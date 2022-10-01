package stack;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> stk = new Stack<>();

		stk.push(30);
		stk.push(-5);
		stk.push(18);
		stk.push(14);
		stk.push(-3);

		System.out.println("Before reversing : " + stk);
		reverse(stk);
		System.out.println("After reversing : " + stk);
	}

	private static void reverse(Stack<Integer> stk) {

		if (!stk.isEmpty()) {
			int tmp = stk.pop();
			reverse(stk);
			insert(tmp, stk);
		}
	}

	private static void insert(int item, Stack<Integer> stk) {
		if (stk.isEmpty()) {
			stk.push(item);
		} else {
			int tmp = stk.pop();
			insert(item, stk);
			stk.push(tmp);
		}
	}

}
