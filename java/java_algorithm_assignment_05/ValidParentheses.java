import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String text) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (isOpening(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (open != getOpening(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // stretch goal 1
    public static List<Integer> findInvalidIndexes(String text) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> invalid = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (isOpening(c)) {
                stack.push(i);
            } else if (!stack.isEmpty() && text.charAt(stack.peek()) == getOpening(c)) {
                stack.pop();
            } else {
                invalid.add(i);
            }
        }

        invalid.addAll(stack);
        Collections.sort(invalid);
        return invalid;
    }

    // stretch goal 2
    public static boolean isValidForSymbols(String text, char[] symbols) {
        StringBuilder filtered = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            for (char symbol : symbols) {
                if (getOpening(symbol) == getOpening(c)) {
                    filtered.append(c);
                    break;
                }
            }
        }

        return isValid(filtered.toString());
    }

    private static boolean isOpening(char c) {
        return c == '(' || c == '{' || c == '[' || c == '<';
    }

    private static char getOpening(char c) {
        switch (c) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            case '>':
                return '<';
            default:
                return c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter brackets: ");
            String input = scanner.nextLine().trim();

            if (input.equals("exit")) {
                break;
            }

            System.out.println("Valid: " + isValid(input));
            System.out.println("Invalid indexes: " + findInvalidIndexes(input));

            System.out.print("Symbols to check: ");
            String symbolText = scanner.nextLine().replace(" ", "");
            System.out.println("Valid for those symbols: " + isValidForSymbols(input, symbolText.toCharArray()));
            System.out.println();
        }

        scanner.close();
    }
}