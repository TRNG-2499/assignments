package java_algorithm_assignment_05;
import java.util.*;

public class inputValidation {
    public static boolean validParentheses(String input) {
        if (input.isEmpty() || input.trim().equals("")) return true;
        Stack<Character> seen = new Stack<>();
        
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                seen.push(c);
            } else {
                 if (seen.isEmpty()) {
                    return false;
                }

                char last = seen.pop();

                 if ((c == ')' && last != '(') ||
                    (c == '}' && last != '{') ||
                    (c == ']' && last != '[') ||
                    (c == '>' && last != '<')) {
                    return false;
                }
            }

        }
        return seen.isEmpty();
    }

        public static List<Integer> invalidCharIndexes(String input) {
        if (input.isEmpty() || input.trim().equals("")) return new ArrayList<Integer>();

        Stack<Character> seen = new Stack<>();
        List<Integer> output = new ArrayList<Integer>();
        char[] copyInput = input.toCharArray();
        
        for (int i = 0; i < copyInput.length; i++) {
            char c = copyInput[i];
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                seen.push(c);
            } else {
                 if (seen.isEmpty()) {
                    output.add(i);
                    return output;
                }

                char last = seen.pop();

                 if ((c == ')' && last != '(') ||
                    (c == '}' && last != '{') ||
                    (c == ']' && last != '[') ||
                    (c == '>' && last != '<')) {
                    output.add(i);
                    return output;
                }
            }

        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(validParentheses("()"));
        System.out.println(validParentheses("()[]{}<>"));
        System.out.println(validParentheses("(]"));
        System.out.println(validParentheses("([)]"));
        System.out.println(validParentheses("<{[]}>"));
        System.out.println(validParentheses("(<>"));
        System.out.println(validParentheses(""));
        
        System.out.println("Invalid Character Indexes");
        System.out.println(invalidCharIndexes("()"));
        System.out.println(invalidCharIndexes("()[]{}<>"));
        System.out.println(invalidCharIndexes("(]"));
        System.out.println(invalidCharIndexes("([)]"));
        System.out.println(invalidCharIndexes("<{[]}>"));
        System.out.println(invalidCharIndexes("(<>"));
        System.out.println(invalidCharIndexes(""));
    }
}
