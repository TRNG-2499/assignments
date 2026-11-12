package java.java_algorithm_assignment_05;
import java.util.Stack;

public class BalancedBrackets {
    public static boolean isBalanced(String s){
        if (s == null){
            return false;
        }
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if(isOpening(c)){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                char lastOpen = stack.pop();
                if (lastOpen != matchingOpener(c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private static boolean isOpening(char c){
        return c == '(' || c == '{' || c == '[' || c  == '<';
    }
    public static char matchingOpener(char c){
        switch(c){
            case ')': return '(';
            case '}': return '{';
            case ']': return '[';
            case '>': return '<';
            default: return '\0';
        }
    }
}
