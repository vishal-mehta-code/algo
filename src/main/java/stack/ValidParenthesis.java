package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        char[] str = "[](){({()})}".toCharArray();

        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        System.out.println(isValidParenthesis(str));
    }

    private static Map<Character, Character> map = new HashMap<>();
    private static Stack<Character> stk = new Stack<>();

    private static boolean isValidParenthesis(char[] chars) {
        for (char current : chars) {
            if (map.get(current) != null) {
                stk.push(current);
            } else if (stk.isEmpty() || map.get(stk.pop()) != current) {
                return false;
            }
        }

        return stk.isEmpty();
    }
}
