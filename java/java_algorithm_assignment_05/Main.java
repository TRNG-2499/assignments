import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(validParentheses("()"));
        System.out.println(validParentheses("()[]{}<>"));
        System.out.println(validParentheses("(]"));
        System.out.println(validParentheses("([)]"));
        System.out.println(validParentheses("<{[]}>"));
        System.out.println(validParentheses("(<>"));
        System.out.println(validParentheses(""));

        System.out.println(validParenthesesIndex("(]"));
        System.out.println(validParenthesesIndex("()"));
        System.out.println(validParenthesesIndex("([)]"));

        System.out.println(validParenthesesMatch("([)]", new char[]{'('}));
        System.out.println(validParenthesesMatch("([)]", new char[]{')'}));
    }

    /**
     * Checks to see if the string is a valid parentheses string.
     * @param input The input string
     * @return Whether or not it is a valid parentheses string.
     */
    public static boolean validParentheses(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');
        mapping.put('>', '<');

        for (char c: input.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != mapping.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * Checks to see if the string is a valid parentheses string.
     * @param input The input string
     * @return A list of indexes that contributes to invalidating the parentheses string.
     */
    public static List<Integer> validParenthesesIndex(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');
        mapping.put('>', '<');

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != mapping.get(c)) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    /**
     * Checks to see if the string is a valid parentheses string based on what to check.
     * @param input The input string
     * @param type The characters to check
     * @return Whether or not it is a valid parentheses string.
     */
    public static boolean validParenthesesMatch(String input, char[] brackets) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> mapping = new HashMap<>();

        for (char c : brackets) {
            if (c == ')' || c == '(') {
                mapping.put(')', '(');
            } else if (c == '}' || c == '{') {
                mapping.put('}', '{');
            } else if (c == ']' || c == '[') {
                mapping.put(']', '[');
            } else if (c == '>' || c == '<') {
                mapping.put('>', '<');
            }
        }

        for (char c: input.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != mapping.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}