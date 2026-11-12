/*
*Write a method that accepts a single parameter: a String containing only the following characters: (, ), {, }, [, ], <, and >.
 No other characters, letters, or numbers will appear in the input.
The method should return a boolean indicating whether the brackets in the string are balanced — meaning every opening bracket has a 
matching closing bracket of the same type, and brackets are closed in the correct order (properly nested, not just present in equal counts).
An empty string should be treated as valid/balanced, since there is nothing unbalanced about it.
Consider what should happen with a string that has closing brackets with no corresponding opening bracket, or leftover unmatched opening brackets 
at the end — both of these cases should result in false.
Hint: This is a natural fit for a Stack (from java.util): push opening brackets as they're encountered, and when a closing bracket is encountered, 
check that it matches the most recently pushed opening bracket.
*/
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

