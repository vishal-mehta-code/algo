package string;

import java.util.Stack;

public class RemoveAdjDups {

    public static void main(String[] args) {
        String str = "geeksforgeeg";
        System.out.println(removeAdjDups(str));
    }

    private static String removeAdjDups(String str) {
        Stack<Character> stk = new Stack<>();
        for (Character curr : str.toCharArray()) {
            if (stk.isEmpty()) {
                stk.push(curr);
            } else {
                if (stk.peek() == curr) {
                    stk.pop();
                } else {
                    stk.push(curr);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character curr : stk) {
            result.append(curr);
        }
        return result.toString();
    }

}
