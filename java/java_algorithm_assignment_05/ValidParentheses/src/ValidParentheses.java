/**
     * @param args the command line arguments
     * Java algorithm assignment 05 - Valid Parentheses
     * Objective: Practice using a stack-based approach to track and validate nested/paired structures — a foundational pattern for problems involving matching, balancing, or nesting.
     * 1. Write a method that accepts a single parameter: a String containing only the following characters: (, ), {, }, [, ], <, and >. No other characters, letters, or numbers will appear in the input.
     * 2. The method should return a boolean indicating whether the brackets in the string are balanced — meaning every opening bracket has a matching closing bracket of the same type, and brackets are closed in the correct order (properly nested, not just present in equal counts).
     * 3. An empty string should be treated as valid/balanced, since there is nothing unbalanced about it. Consider what should happen with a string that has closing brackets with no corresponding opening bracket, or leftover unmatched opening brackets at the end — both of these cases should result in false.
*/

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        
        //first see if brackets are balanced
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            //opening brackets
            if (current == '(' || current == '{' ||
                current == '[' || current == '<') {
                stack.push(current);
            }
            //closing brackets
            else {
                //If there is no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                //checks for matching pairs
                if (current == ')' && top != '(') {
                    return false;
                }
                if (current == '}' && top != '{') {
                    return false;
                }
                if (current == ']' && top != '[') {
                    return false;
                }
                if (current == '>' && top != '<') {
                    return false;
                }
            }
        }
        //checks if there are any unmatched opening brackets left in the stack
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
