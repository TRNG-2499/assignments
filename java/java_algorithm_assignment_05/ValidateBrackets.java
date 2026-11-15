import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

public class ValidateBrackets {
    private static final String OPENS  = "({[<";
    private static final String CLOSES = ")}]>";
    private static final String ALL    = "(){}[]<>";
    public static void main(String... args) {
        System.out.println(isBalanced("()[]{}<>"));                      // true
        System.out.println(isBalanced("([)]"));                          // false
        System.out.println(isBalanced(""));                              // true
        System.out.println(Arrays.toString(invalidIndices("")));      // [0]
        System.out.println(Arrays.toString(invalidIndices("([)]")));     // [0, 2]
        System.out.println(isBalancedForSymbols("([)]", "]"));

    }

    public static boolean isBalanced(String s) {
        return validate(s, ALL).length == 0;
    }

    public static int[] invalidIndices(String s) {
        return validate(s, ALL);
    }

    public static boolean isBalancedForSymbols(String s, String symbols) {
        return validate(s, symbols).length == 0;
    }

    public static int[] validate(String s, String symbols) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] chars  = s.toCharArray();
        List<Integer> unmatched = new ArrayList<>();
        String[] separated = separateSymbols(symbols);
        HashSet<Character> openSymbolSet = new HashSet<>();
        HashSet<Character> closeSymbolSet = new HashSet<>();


        for (char c : separated[0].toCharArray()) openSymbolSet.add(c);
        for (char c : separated[1].toCharArray()) closeSymbolSet.add(c);

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (openSymbolSet.contains(c)) {
                stack.push(i);
            } else if (closeSymbolSet.contains(c)) {
                if (!stack.isEmpty() && chars[stack.peek()] == OPENS.charAt(CLOSES.indexOf(c))) {
                    stack.pop();
                } else {
                    unmatched.add(i);
                }
            }
        }

        unmatched.addAll(stack);
        int[] out = new int[unmatched.size()];
        for (int i = 0; i < unmatched.size(); i++) {
            out[i] = unmatched.get(i);
        }
        
        return out;
    }

    public static String[] separateSymbols(String s) {
        StringBuilder opens = new StringBuilder();
        StringBuilder closes = new StringBuilder();

        for (char c : s.toCharArray()) {
            int idx = ALL.indexOf(c);
            if (idx < 0) continue; // not a bracket
            int pair = (OPENS.indexOf(c) >= 0) ? OPENS.indexOf(c) : CLOSES.indexOf(c);
            char open = OPENS.charAt(pair);
            if (opens.indexOf(String.valueOf(open)) < 0) { // avoid duplicates
                opens.append(open);
                closes.append(CLOSES.charAt(pair));
            }
        }
        return new String[] { opens.toString(), closes.toString() };
    }
}