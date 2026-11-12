import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {

    private static final String OPENERS = "({[<";
    private static final String CLOSERS = ")}]>";

    // ---------- Base activity ----------
    // Pushes each opening bracket onto a stack. Each closing bracket must match
    // the most recently pushed opener, or the string is unbalanced. Anything
    // left on the stack at the end is an unmatched opener. Empty string -> true.
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (isOpener(c)) {
                stack.push(c);
            } else if (isCloser(c)) {
                if (stack.isEmpty() || stack.pop() != matchingOpener(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isOpener(char c) {
        return OPENERS.indexOf(c) >= 0;
    }

    private static boolean isCloser(char c) {
        return CLOSERS.indexOf(c) >= 0;
    }

    // Returns the opener that pairs with the given closer, e.g. ')' -> '('.
    private static char matchingOpener(char closer) {
        return OPENERS.charAt(CLOSERS.indexOf(closer));
    }

    // ---------- Stretch 1: Identify All Invalid Character Indexes ----------
    // Same stack idea, but the stack holds indexes so they can be reported.
    // - A closer that does not match the opener on top of the stack (or arrives
    //   when the stack is empty) is invalid. The stack is left alone so that the
    //   opener can still be matched by a later closer.
    // - Any openers still on the stack at the end are invalid.
    // Removing every returned index from the string leaves a balanced string.
    // A balanced string returns an empty list. Indexes are in ascending order.
    public static List<Integer> findInvalidIndexes(String s) {
        Stack<Integer> openIndexes = new Stack<>();
        List<Integer> invalid = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpener(c)) {
                openIndexes.push(i);
            } else if (isCloser(c)) {
                if (!openIndexes.isEmpty() && s.charAt(openIndexes.peek()) == matchingOpener(c)) {
                    openIndexes.pop();
                } else {
                    invalid.add(i);
                }
            }
        }

        invalid.addAll(openIndexes);
        Collections.sort(invalid);
        return invalid;
    }

    // ---------- Stretch 2: Matching Given Symbols ----------
    // Only the bracket pairs named in `symbols` are checked; every other bracket
    // character is skipped as if it were not in the string. A symbol can be given
    // in either form: '(' and ')' both select the ( ) pair.
    // An empty symbols array checks nothing, so it always returns true.
    public static boolean isBalanced(String s, char[] symbols) {
        Set<Character> selectedOpeners = new HashSet<>();
        for (char symbol : symbols) {
            if (isOpener(symbol)) {
                selectedOpeners.add(symbol);
            } else if (isCloser(symbol)) {
                selectedOpeners.add(matchingOpener(symbol));
            } else {
                throw new IllegalArgumentException("Not a bracket symbol: '" + symbol + "'");
            }
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpener(c) && selectedOpeners.contains(c)) {
                stack.push(c);
            } else if (isCloser(c) && selectedOpeners.contains(matchingOpener(c))) {
                if (stack.isEmpty() || stack.pop() != matchingOpener(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("=== Base activity: is balanced ===");
        System.out.println(isBalanced("()"));        // true
        System.out.println(isBalanced("()[]{}<>"));  // true
        System.out.println(isBalanced("(]"));        // false
        System.out.println(isBalanced("([)]"));      // false
        System.out.println(isBalanced("<{[]}>"));    // true
        System.out.println(isBalanced("(<>"));       // false
        System.out.println(isBalanced(""));          // true
        System.out.println(isBalanced(")("));        // false (closer with no opener)

        System.out.println("\n=== Stretch 1: Invalid Character Indexes ===");
        System.out.println(findInvalidIndexes("()"));       // []
        System.out.println(findInvalidIndexes("(]"));       // [0, 1]
        System.out.println(findInvalidIndexes("([)]"));     // [0, 2]
        System.out.println(findInvalidIndexes("(<>"));      // [0]
        System.out.println(findInvalidIndexes("))(("));     // [0, 1, 2, 3]
        System.out.println(findInvalidIndexes("{[}]>"));    // [0, 2, 4]
        System.out.println(findInvalidIndexes(""));         // []

        System.out.println("\n=== Stretch 2: Matching Given Symbols ===");
        System.out.println(isBalanced("([)]", new char[] { '[' }));       // true
        System.out.println(isBalanced("([)]", new char[] { ')' }));       // true
        System.out.println(isBalanced("([)]", new char[] { '(', ']' }));  // false
        System.out.println(isBalanced("(<]>", new char[] { '>' }));       // true
        System.out.println(isBalanced("{(}", new char[] { '}', '(' }));   // false
        System.out.println(isBalanced("((([", new char[] {}));            // true (nothing checked)
    }
}
