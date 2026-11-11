import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class solution {
    public static void main(String[] args) {

        System.out.println(validCheck("()"));
        System.out.println(validCheck("()[]{}<>"));
        System.out.println(validCheck("(]"));
        System.out.println(validCheck("([)]"));
        System.out.println(validCheck("<{[]}>"));
        System.out.println(validCheck("(<>"));
        System.out.println(validCheck(""));

        System.out.println();

        // invalid index tests
        System.out.println(findInvalidIndexes("()"));       // []
        System.out.println(findInvalidIndexes("(]"));       // [0, 1]
        System.out.println(findInvalidIndexes("([)]"));     // [0, 2]
        System.out.println(findInvalidIndexes("(<>"));      // [0]
        System.out.println(findInvalidIndexes("))(("));     // [0, 1, 2, 3]
        System.out.println(findInvalidIndexes("{[]}}"));    // [4]
        System.out.println(findInvalidIndexes(""));         // []

        System.out.println();

        // matching given symbols tests
        System.out.println(validCheckForSymbols("([)]", new char[]{'['}));       // true, only [ ] checked
        System.out.println(validCheckForSymbols("([)]", new char[]{')'}));       // true, only ( ) checked
        System.out.println(validCheckForSymbols("([)]", new char[]{'(', ']'}));  // false, both pairs checked
        System.out.println(validCheckForSymbols("(<]", new char[]{'<'}));        // false, < never closed
        System.out.println(validCheckForSymbols("{(}", new char[]{'{'}));        // true, ( ignored
        System.out.println(validCheckForSymbols("", new char[]{'('}));           // true

    }


    public static boolean validCheck(String input) {

        Stack<Character> stack = new Stack<>();

        for (char i : input.toCharArray()) {

            if (i == '(' || i == '[' || i == '{' || i == '<') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) return false;
                char pop = stack.pop();

                if (i == ')' && pop != '(') return false;
                if (i == ']' && pop != '[') return false;
                if (i == '}' && pop != '{') return false;
                if (i == '>' && pop != '<') return false;



            }

        }
        return stack.isEmpty();


    }

    // returns the index of every character that makes the string unbalanced
    // the stack holds indexes instead of characters so we know where each opener was
    public static List<Integer> findInvalidIndexes(String input) {

        Stack<Integer> openIndexes = new Stack<>();
        List<Integer> invalid = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (isOpener(c)) {
                openIndexes.push(i);
            } else if (isCloser(c)) {
                // a closer only counts as matched if the most recent opener is its partner
                if (!openIndexes.isEmpty() && input.charAt(openIndexes.peek()) == matchingOpener(c)) {
                    openIndexes.pop();
                } else {
                    invalid.add(i);
                }
            }
        }

        // any opener still on the stack never got closed
        invalid.addAll(openIndexes);

        Collections.sort(invalid);
        return invalid;
    }

    // same as validCheck, but only checks the bracket types in symbols and ignores the rest
    public static boolean validCheckForSymbols(String input, char[] symbols) {

        // store every allowed pair by its opener, so ( and ) both mean the same pair
        Set<Character> allowedOpeners = new HashSet<>();
        for (char symbol : symbols) {
            if (isOpener(symbol)) {
                allowedOpeners.add(symbol);
            } else if (isCloser(symbol)) {
                allowedOpeners.add(matchingOpener(symbol));
            }
        }

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {

            if (isOpener(c) && allowedOpeners.contains(c)) {
                stack.push(c);
            } else if (isCloser(c) && allowedOpeners.contains(matchingOpener(c))) {
                if (stack.isEmpty()) return false;
                if (stack.pop() != matchingOpener(c)) return false;
            }
            // anything else is ignored, as if it weren't in the string
        }

        return stack.isEmpty();
    }

    // helpers used by the stretch goals

    public static boolean isOpener(char c) {
        return c == '(' || c == '[' || c == '{' || c == '<';
    }

    public static boolean isCloser(char c) {
        return c == ')' || c == ']' || c == '}' || c == '>';
    }

    // gives back the opener that pairs with a closer
    public static char matchingOpener(char closer) {
        switch (closer) {
            case ')': return '(';
            case ']': return '[';
            case '}': return '{';
            default:  return '<';
        }
    }
}