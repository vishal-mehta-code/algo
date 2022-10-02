package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxValidParenthesis {

    public static void main(String[] args) {
        char[] str = ")()())()".toCharArray();

        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        System.out.println("max length of valid parenthesis : " + maxValidParethesis(str));
    }

    private static Map<Character, Character> map = new HashMap<>();
    private static Stack<Character> stk = new Stack<>();

    private static int maxValidParethesis(char[] str) {
        int max = 0;

        int currentValidCount = 0;
        for (char current : str) {
            if (map.get(current) != null) {
                stk.push(current);
            } else {
                if (!stk.isEmpty()) {
                    if (map.get(stk.pop()) == current) {
                        currentValidCount += 2;

                        if (currentValidCount > max) {
                            max = currentValidCount;
                        }
                    } else {
                        stk.clear();
                        currentValidCount = 0;
                    }
                } else {
                    currentValidCount = 0;
                }

            }

        }

        return max;
    }
}
