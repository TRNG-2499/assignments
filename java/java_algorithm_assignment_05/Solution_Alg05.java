import java.util.Stack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_Alg05 {

        public static void main(String[] args) {
        System.out.println("Valid Parentheses");
        System.out.println("===================");

        // Test validParenthesese
        System.out.println("\n--- Valid Parentheses Tests ---");
        runTest(validParenthesese("()"), "()");
        runTest(validParenthesese("()[]{}<>"), "()[]{}<>");
        runTest(validParenthesese("(]"), "(]");
        runTest(validParenthesese("([)]"), "([)]");
        runTest(validParenthesese("<{[]}>"), "<{[]}> ");
        runTest(validParenthesese("(<>"), "(<>");
        runTest(validParenthesese(""), "");

        // Test getInvalidIndices
        System.out.println("\n--- Invalid Indices Tests ---");
        runInvalidIndexTest(getInvalidIndices("()[]{}<>"), "()[]{}<>", "Balanced string - empty list expected");
        runInvalidIndexTest(getInvalidIndices("(]"), "(]", "Mismatched types - indices 0 and 1 expected");
        runInvalidIndexTest(getInvalidIndices("([)]"), "([)]", "Wrong nesting order - all indices expected");
        runInvalidIndexTest(getInvalidIndices("<{[]}>"), "<{[]}>", "Balanced nested - empty list expected");
        runInvalidIndexTest(getInvalidIndices("(<>"), "(<>", "Unmatched opening bracket - indices 0 and 1 expected");
        runInvalidIndexTest(getInvalidIndices("((()))"), "((()))", "Balanced triple nesting - empty list expected");

        // Test checkSpecificSymbols
        System.out.println("\n--- Specific Symbols Tests ---");
        runSymbolTest(checkSpecificSymbols("()[]{}<>", new char[]{'(', ')'}), "()[]{}<>", new char[]{'(', ')'}, "(/) pair only");
        runSymbolTest(checkSpecificSymbols("([)]", new char[]{'[', ']'}), "([)]", new char[]{'[', ']'}, "[/] pair only (ignores parens)");
        runSymbolTest(checkSpecificSymbols("{[]}", new char[]{'{', '}', '[', ']'}), "{[]}", new char[]{'{', '}', '[', ']'}, "mixed nested []{} - balanced");
        runSymbolTest(checkSpecificSymbols("<>", new char[]{'<', '>'}), "<>", new char[]{'<', '>'}, "<> pair only");
        runSymbolTest(checkSpecificSymbols("()[]{}<>", new char[]{'(', ')', '{', '}'}), "()[]{}<>", new char[]{'(', ')', '{', '}'}, "balanced with () and {} only");
    }

    private static void runTest(boolean result, String input) {
        System.out.printf("Input: \"%s\" -> %s%n", input, result ? "true" : "false");
    }

    private static void runInvalidIndexTest(List<Integer> indices, String input, String description) {
        System.out.println(description);
        System.out.printf("  Input: \"%s\"\n", input);
        if (indices.isEmpty()) {
            System.out.println("  Output: [] (empty - balanced)\n");
        } else {
            System.out.print("  Output: [");
            for (int i = 0; i < indices.size(); i++) {
                System.out.print(indices.get(i));
                if (i < indices.size() - 1) System.out.print(", ");
            }
            System.out.println("]\n");
        }
    }

    private static void runSymbolTest(boolean result, String input, char[] symbols, String description) {
        System.out.println(description);
        System.out.printf("  Input: \"%s\", Symbols: %s -> %s%n", input, 
                symbols.length > 0 ? symbols[0] + "," : "", result ? "true" : "false");
    }


    public static boolean validParenthesese(String input) {
        if (input.isEmpty()) {
            return true;
        }

        char[] charArr = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(' || charArr[i] == '{' || charArr[i] == '[' || charArr[i] == '<') {
                stack.push(charArr[i]);
            } 
            else {
                // Closing bracket case
                if (stack.empty()) {
                    return false;
                }

                Character topChar = stack.peek();

                if ((topChar == '(' && charArr[i] != ')') ||
                   (topChar == '{' && charArr[i] != '}') ||
                   (topChar == '[' && charArr[i] != ']') ||
                   (topChar == '<' && charArr[i] != '>')) {
                    return false;
                }

                stack.pop();
            }
        }

        // If stack is not empty, there are unmatched opening brackets
        return stack.isEmpty();
    }

    public static List<Integer> getInvalidIndices(String input) {
        List<Integer> invaildInd = new ArrayList<>();

        if (input == null  || input.isEmpty()) {
            return invaildInd;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // if it's an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(i);
            }
            // if it's a closing bracket
            else if (c == ')' || c == '}' || c == ']' || c == '>') {

                if (stack.isEmpty()) {
                    // these are closing bracket with no matching opening brackets
                    invaildInd.add(i);
                }
                else {
                    int topIdx = stack.pop();
                    char topChar = input.charAt(topIdx);

                    boolean isMatch = false;
                    // check matchingness
                    if (topChar == '(' && c == ')') isMatch = true;
                    if (topChar == '{' && c == '}') isMatch = true;
                    if (topChar == '[' && c == ']') isMatch = true;
                    if (topChar == '<' && c == '>') isMatch = true;

                    if (!isMatch) {

                        // both the opening and closing brackets lead to invalid results. 
                        invaildInd.add(topIdx);
                        invaildInd.add(i);
                    }

                }
            }
        }

        // after processing, any indices left in the stack is not matched with an opening brackets
        while (!stack.isEmpty()) {
            invaildInd.add(stack.pop());
        }
        return invaildInd;
    }

    public static boolean checkSpecificSymbols(String input, char[] symbols) {
        if (input == null || symbols.length == 0) return true;

        Set<Character> allowed = new HashSet<>();
        for (char s : symbols) {
            switch(s) {
                case '(': case ')': allowed.add('('); allowed.add(')'); break;
                case '{': case '}': allowed.add('{'); allowed.add('}'); break;
                case '[': case ']': allowed.add('['); allowed.add(']'); break;
                case '<': case '>': allowed.add('<'); allowed.add('>'); break;
            }
        }

        if (input.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // don't care about the symbols not in the set
            if (!allowed.contains(c)) continue;

            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) return false; 

                char top = stack.pop();
                boolean match = ((top == '(' && c == ')') || (top == '{' && c == '}') || (top == '[' && c == ']') || (top == '<' && c == '>'));

                if (!match) return false;
            }
        }
        return stack.isEmpty();
    }
}


