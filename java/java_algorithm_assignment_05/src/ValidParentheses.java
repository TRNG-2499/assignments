import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValidParentheses("()"));
        System.out.println(isValidParentheses("()[]{}<>"));
        System.out.println(isValidParentheses("(]"));
        System.out.println(isValidParentheses("([)]"));
        System.out.println(isValidParentheses("<{[]}>"));
        System.out.println(isValidParentheses("(<>"));
        System.out.println(isValidParentheses(""));
    }

    private static boolean isValidParentheses(String str) {
        if (str.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == '>') {
                if (stack.peek() == '<') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
