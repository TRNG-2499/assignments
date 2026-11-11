package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string of brackets: ");
        String brackets = scanner.nextLine().trim();

        System.out.println("Balanced: " + isBalanced(brackets));

        System.out.println();
        System.out.println("-----Stretch Goal 1-----");
        // stretch goal 1
        System.out.println("Invalid indexes: " + findInvalidIndexes(brackets));

        System.out.println();
        System.out.println("-----Stretch Goal 2-----");
        // stretch goal 2
        System.out.print("Enter the bracket types to check, any of ( { [ < { (for example: { or [{): ");
        char[] symbols = scanner.nextLine().trim().toCharArray();
        System.out.println("Balanced for those types: " + isBalancedForSymbols(brackets, symbols));

        scanner.close();
    }

    // normal solution
    public static boolean isBalanced(String brackets) {
        Stack<Character> stack = new Stack<>();

        for (char c : brackets.toCharArray()) {
            if (isOpening(c)) {
                stack.push(c);
            } else {
                // a closing bracket must close the most recent unclosed opening bracket,
                // and if nothing is open there's nothing for it to close
                if (stack.isEmpty() || stack.pop() != matchingOpening(c)) {
                    return false;
                }
            }
        }
        // anything still on the stack was opened but never closed
        return stack.isEmpty();
    }

    public static boolean isOpening(char c) {
        return c == '(' || c == '{' || c == '[' || c == '<';
    }

    public static char matchingOpening(char closing) {
        switch (closing) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            case '>':
                return '<';
            default:
                // already an opening bracket, so it is its own match
                return closing;
        }
    }

    // stretch goal 1
    public static List<Integer> findInvalidIndexes(String brackets) {
        List<Integer> invalid = new ArrayList<>();
        // stores indexes instead of characters, so leftover openings can be reported by position
        Stack<Integer> openIndexes = new Stack<>();

        for (int i = 0; i < brackets.length(); i++) {
            char c = brackets.charAt(i);
            if (isOpening(c)) {
                openIndexes.push(i);
            } else if (!openIndexes.isEmpty() && brackets.charAt(openIndexes.peek()) == matchingOpening(c)) {
                openIndexes.pop();
            } else {
                // the check above only peeks, so on a mismatch the opening bracket stays open
                // and can still be matched by a later closing bracket
                invalid.add(i);
            }
        }

        // every opening bracket left over was never closed
        invalid.addAll(openIndexes);
        // closings are found during the loop and leftover openings after it, so sort to list them in string order
        Collections.sort(invalid);
        return invalid;
    }

    // stretch goal 2
    public static boolean isBalancedForSymbols(String brackets, char[] symbols) {
        // store each symbol as its opening form, so "(" and ")" both mean the ( ) pair
        Set<Character> typesToCheck = new HashSet<>();
        for (char symbol : symbols) {
            typesToCheck.add(matchingOpening(symbol));
        }

        Stack<Character> stack = new Stack<>();
        for (char c : brackets.toCharArray()) {
            // skip brackets that aren't being checked, as if they weren't in the string
            if (!typesToCheck.contains(matchingOpening(c))) {
                continue;
            }

            if (isOpening(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || stack.pop() != matchingOpening(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
