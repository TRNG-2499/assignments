import java.util.*;

public class parentheses {

    static Map<Character, Character> symbol = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        symbol.put(')', '(');
        symbol.put(']', '[');
        symbol.put('}', '{');
        symbol.put('>', '<');

        System.out.println("Valid parentheses program running....");
        System.out.print("Enter your string: ");
        String input = scanner.nextLine();

        System.out.println("1. Check if parentheses are valid");
        System.out.println("2. Get invalid parentheses indices");
        System.out.print("Select program mode: ");
        int mode = scanner.nextInt();

        if (mode == 1) {
            boolean result = isValid(input);
            System.out.println(result);
        } else if (mode == 2) {
            // ArrayList<Integer> invalidIndices = invalidIndex(input);
            // System.out.println(invalidIndices);
        } else {
            System.out.println("Invalid mode selected.");
        }

        scanner.close();
    }

    public static boolean isValid(String s) {

        // Check for empty string
        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (symbol.containsKey(c)) {

                if (stack.isEmpty() || stack.pop() != symbol.get(c)) {
                    return false;
                }

            } else if (symbol.containsValue(c)) {
                stack.push(c);
            } else {
                System.out.println("Invalid character encountered: " + c);
                return false;
            }

        }

        return stack.isEmpty();
    }

    // public static ArrayList<Integer> invalidIndex(String s) {

    // int index = 0;

    // ArrayList<Integer> result = new ArrayList<>();

    // // Check for empty string
    // if (s == null || s.isEmpty()) {
    // return new ArrayList<>();
    // }

    // Stack<Character> stack = new Stack<>();

    // for (char c : s.toCharArray()) {

    // if (symbol.containsKey(c)) {

    // if (stack.isEmpty() || stack.pop() != symbol.get(c)) {
    // result.add(index);
    // }

    // } else if (symbol.containsValue(c)) {
    // stack.push(c);
    // } else {
    // System.out.println("Invalid character encountered: " + c);
    // return new ArrayList<>();
    // }

    // index++;

    // }

    // return result;

    // }

}
