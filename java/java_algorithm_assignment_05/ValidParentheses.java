import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;;

public class ValidParentheses {
    public static boolean isBalanced(String parentheses) {
        HashMap<Character, Character> parenthesesMap = new HashMap<Character, Character>();
        parenthesesMap.put(')', '(');
        parenthesesMap.put('}', '{');
        parenthesesMap.put(']', '[');
        parenthesesMap.put('>', '<');

        HashSet<Character> charSet = new HashSet<Character>(Set.of('(', '{', '[', '<'));

        ArrayList<Character> stack = new ArrayList<Character>();
        char[] charArray = parentheses.toCharArray();

        for (char c : charArray) {
            if (charSet.contains(c)) {
                stack.add(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }

                if (!stack.getLast().equals(parenthesesMap.get(c))) {   
                    return false;
                }

                stack.removeLast();
            }
        }

        return (stack.size() == 0);
    }

    public static void main(String...args) {
        boolean result = isBalanced("()[]{}<>");
        System.out.println(result);
    }
}
