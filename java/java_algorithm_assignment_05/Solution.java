package java_algorithm_assignment_05;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isBalanced("()"));
        System.out.println(isBalanced("()[]{}<>"));
        System.out.println(isBalanced("(]"));
        System.out.println(isBalanced("([)]"));
        System.out.println(isBalanced("<{[]}>"));
        System.out.println(isBalanced("(<>"));
        System.out.println(isBalanced(""));
    }

    public static boolean isBalanced(String brackets) {
        Stack<Character> openings = new Stack<>();

        for (char bracket : brackets.toCharArray()) {
            if (bracket == '(' || bracket == '{' || bracket == '[' || bracket == '<') {
                openings.push(bracket);
            } else {
                if (openings.isEmpty()) {
                    return false;
                }
                if (!isMatchingPair(openings.pop(), bracket)) {
                    return false;
                }
            }
        }

        return openings.isEmpty();
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')')
                || (opening == '{' && closing == '}')
                || (opening == '[' && closing == ']')
                || (opening == '<' && closing == '>');
    }
}
