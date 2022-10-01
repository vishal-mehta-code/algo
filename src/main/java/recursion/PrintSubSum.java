package recursion;

import java.util.Stack;

public class PrintSubSum {

	private static int[] arr = { 1, 8, 5, 2, 4 };
	private static int end = arr.length;
	public static int TARGET_SUM = 9;

	public static void main(String[] args) {
		populateSubset(0);
	}

	private static Stack<Integer> stack = new Stack<Integer>();
	private static int sumInStack = 0;

	private static void populateSubset(int start) {

		if (sumInStack == TARGET_SUM) {
			print(stack);
		}

		for (int i = start; i < end; i++) {
			stack.push(arr[i]);
			sumInStack += arr[i];

			populateSubset(i + 1);
			sumInStack = sumInStack - (Integer) stack.pop();
		}
	}

	private static void print(Stack<Integer> stack) {
		StringBuilder sb = new StringBuilder();
		for (Integer i : stack) {
			sb.append(i).append(" + ");
		}
		String str = sb.toString();

		System.out.println("combination is : " + str.substring(0, str.length() - 3));
	}

}
