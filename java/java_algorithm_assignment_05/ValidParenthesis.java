import java.util.Stack;

public class ValidParenthesis {
    public static boolean isBalanced(String input) {
        Stack<Character> st = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                st.push(c);

            } else if (c == ')' || c == '}' || c == ']' || c == '>') {
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[') ||
                    (c == '>' && top != '<')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("(){}[]<>"));
        System.out.println(isBalanced("([{}])"));
        System.out.println(isBalanced("([{}]"));
        System.out.println(isBalanced("([)]"));
        System.out.println(isBalanced(""));
    }
}

