package java_algorithm_assignment_05;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesisSolution {

    public static boolean isBalanced(String input) {

        //Create the Stack
        Deque<Character> stack = new ArrayDeque<>();

        //loop through the input string
        for (int i = 0; i < input.length(); i++) {

            //Get the current character
            char current = input.charAt(i);

            //Check for bracket rule
            if (current == '(' || current == '[' || current == '{' || current == '<') {
                stack.push(current);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                //Check if the closing bracket matches
                char top = stack.peek();

                if (current == ')' && top != '(' ||
                    current == ']' && top != '[' ||
                    current == '}' && top != '{' ||
                    current == '>' && top != '<') {
                    return false;
                }

                //Remove matched opening bracket
                stack.pop();
            }
        }

        //check if all brackets were matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "([{<>}])";
        boolean result = isBalanced(input);
        System.out.println("is balanced: " + result);
    }
}