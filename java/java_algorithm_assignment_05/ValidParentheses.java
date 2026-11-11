import java.util.Stack;

public class ValidParentheses {

    public static boolean isBalanced(String input) {
        // The top of the stack holds the closing bracket we expect next.
        Stack<Character> expectedClosings = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char bracket = input.charAt(i);

            // For each opening bracket, save its matching closing bracket.
            if (bracket == '(') {
                expectedClosings.push(')');
            } else if (bracket == '[') {
                expectedClosings.push(']');
            } else if (bracket == '{') {
                expectedClosings.push('}');
            } else if (bracket == '<') {
                expectedClosings.push('>');
            } else {
                // A closing bracket needs an opening bracket to match.
                if (expectedClosings.isEmpty()) {
                    return false;
                }

                // Remove the most recent expected bracket and check the match.
                if (expectedClosings.pop() != bracket) {
                    return false;
                }
            }
        }

        // An empty stack means every opening bracket was matched.
        // An empty input also passes because nothing was added to the stack.
        return expectedClosings.isEmpty();
    }

    public static void main(String[] args) {
        String input = "<{[()]}>";
        System.out.println(isBalanced(input)); // true
    }
}