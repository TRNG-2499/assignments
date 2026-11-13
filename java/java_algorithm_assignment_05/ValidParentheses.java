import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String characters) {
        if (characters.equals("")) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < characters.length(); i++) {
            char c = characters.charAt(i);

            if (c == '(' || c == '[' || c == '{' || c == '<') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{') ||
                    (c == '>' && top != '<')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}<>"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("<{[]}>"));
        System.out.println(isValid("(<>"));
        System.out.println(isValid(""));
    }
}
