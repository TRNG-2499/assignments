import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValidParentheses(")]"));
        System.out.println(isValidParentheses("()"));
        System.out.println(isValidParentheses("()[]{}<>"));
        System.out.println(isValidParentheses("(]"));
        System.out.println(isValidParentheses("([)]"));
        System.out.println(isValidParentheses("<{[]}>"));
        System.out.println(isValidParentheses("(<>{"));
        System.out.println(isValidParentheses(""));
        System.out.println(isValidParentheses("<{[]({})[<>]}()>"));
        System.out.println();

        // stretch goal 1
        System.out.println(getInvalidIndices(")]"));
        System.out.println(getInvalidIndices("()"));
        System.out.println(getInvalidIndices("()[]{}<>"));
        System.out.println(getInvalidIndices("(]"));
        System.out.println(getInvalidIndices("([)]"));
        System.out.println(getInvalidIndices("<{[]}>"));
        System.out.println(getInvalidIndices("(<>{"));
        System.out.println(getInvalidIndices(""));
        System.out.println(getInvalidIndices("<{[]({})[<>]}()>"));
    }

    private static boolean isValidParentheses(String str) {
        if (str.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == '}') {
                if (!stack.empty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (!stack.empty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (c == '>') {
                if (!stack.empty() && stack.peek() == '<') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static List<Integer> getInvalidIndices(String str) {
        if (str.isEmpty()) return List.of();

        record CharIndex(Character c, Integer index) {}
        List<Integer> indices = new ArrayList<>();
        Stack<CharIndex> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(new CharIndex(c, i));
            } else if (c == ')') {
                if (!stack.empty() && stack.peek().c == '(') {
                    stack.pop();
                } else {
                    indices.add(i);
                }
            } else if (c == '}') {
                if (!stack.empty() && stack.peek().c == '{') {
                    stack.pop();
                } else {
                    indices.add(i);
                }
            } else if (c == ']') {
                if (!stack.empty() && stack.peek().c == '[') {
                    stack.pop();
                } else {
                    indices.add(i);
                }
            } else if (c == '>') {
                if (!stack.empty() && stack.peek().c == '<') {
                    stack.pop();
                } else {
                    indices.add(i);
                }
            }
        }

        if (!stack.empty()) {
            indices.addAll(stack.stream().map((charIndex) -> charIndex.index).toList());
        }
        return indices.stream().sorted().toList();
    }
}
