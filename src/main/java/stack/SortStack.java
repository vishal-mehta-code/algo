package stack;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();

        stk.push(30);
        stk.push(-5);
        stk.push(18);
        stk.push(14);
        stk.push(-3);

        System.out.println("stk before sorting : " + stk);
        sortStack(stk);
        System.out.println("stk after sorting : " + stk);
    }

    private static void sortStack(Stack<Integer> stk) {
        if (!stk.isEmpty()) {
            int tmp = stk.pop();
            sortStack(stk);
            insert(tmp, stk);
        }
    }

    private static void insert(int item, Stack<Integer> stk) {
        if (stk.isEmpty() || item >= stk.peek()) {
            stk.push(item);
        } else {
            int tmp = stk.pop();
            insert(item, stk);
            stk.push(tmp);
        }
    }
}
