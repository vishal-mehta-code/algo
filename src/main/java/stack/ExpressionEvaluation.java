package stack;

import java.util.Stack;

public class ExpressionEvaluation {

    public static void main(String[] args) {
        String postFixExpression = "2 3 + 9 -";
        evaluatePostFixExpression(postFixExpression);

        String infixExpression = "19 + 12 / 4 - ((4 - 7) * 3 / 1)  ";
        infixExpression = removeAllWhiteSpaces(infixExpression, 0, "");
        evaluteInfixExpression(infixExpression);
    }

    private static String removeAllWhiteSpaces(String infixExpression, int i, String result) {
        if (i == infixExpression.length()) {
            return result;
        }

        if (infixExpression.charAt(i) != ' ') {
            return removeAllWhiteSpaces(infixExpression, i + 1, result + infixExpression.charAt(i));
        }

        return removeAllWhiteSpaces(infixExpression, i + 1, result);
    }

    private static Stack<Integer> valuesStk = new Stack<>();
    private static Stack<Character> opsStk = new Stack<>();

    private static void evaluteInfixExpression(String infixExpression) {

        for (int i = 0; i < infixExpression.length(); i++) {
            char current = infixExpression.charAt(i);

            if (current >= '0' && current <= '9') {

                StringBuilder sb = new StringBuilder();
                sb.append(current);

                int j = i + 1;

                while (j < infixExpression.length() && infixExpression.charAt(j) >= '0' && infixExpression.charAt(j) <= '9') {
                    sb.append(infixExpression.charAt(j));
                    j++;
                }

                if (j != i + 1) {
                    i = j - 1;
                }

                valuesStk.push(Integer.parseInt(sb.toString()));
            } else if (infixExpression.charAt(i) == '(') {
                opsStk.push('(');
            } else if (infixExpression.charAt(i) == ')') {
                while (opsStk.peek() != '(') {
                    valuesStk.push(evaluteOperand(opsStk.pop(), valuesStk.pop(), valuesStk.pop()));
                }
                opsStk.pop();
            } else {
                while (!opsStk.isEmpty() && hasPrecedence(opsStk.peek(), infixExpression.charAt(i))) {
                    valuesStk.push(evaluteOperand(opsStk.pop(), valuesStk.pop(), valuesStk.pop()));
                }

                opsStk.push(infixExpression.charAt(i));
            }
        }

        while (!opsStk.isEmpty()) {
            valuesStk.push(evaluteOperand(opsStk.pop(), valuesStk.pop(), valuesStk.pop()));
        }

        System.out.println(valuesStk.pop());
    }

    private static boolean hasPrecedence(char peek, char current) {
        if (peek == '(' || peek == ')') {
            return false;
        }

        if ((current == '*' || current == '/') && (peek == '+' || peek == '-')) {
            return false;
        }

        return true;
    }

    private static void evaluatePostFixExpression(String postFixExpression) {
        Stack<Integer> stk = new Stack<>();
        String[] strArray = postFixExpression.split(" ");
        for (String str : strArray) {

            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                stk.push(evaluteOperand(str, stk.pop(), stk.pop()));
            } else {
                stk.push(Integer.parseInt(str));
            }

        }
        System.out.println(stk.pop());
    }

    private static int evaluteOperand(String str, int value1, int value2) {
        if (str.equals("+")) {
            return value2 + value1;
        }

        if (str.equals("-")) {
            return value2 - value1;
        }

        if (str.equals("*")) {
            return value2 * value1;
        }

        if (str.equals("/")) {
            return value2 / value1;
        }

        return 0;
    }

    private static int evaluteOperand(char op, int value2, int value1) {
        if (op == '+') {
            return value1 + value2;
        }

        if (op == '-') {
            return value1 - value2;
        }

        if (op == '*') {
            return value1 * value2;
        }

        if (op == '/') {
            return value1 / value2;
        }

        return 0;
    }
}
