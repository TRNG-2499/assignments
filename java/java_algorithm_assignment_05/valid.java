import java.util.HashMap;
import java.util.Stack;
public class valid {
    public static boolean validParenthesis(String s) {
        Stack <Character> stack = new Stack<>();
        HashMap <Character, Character> m = new HashMap<>();
        m.put('(',')');
        m.put('[',']');
        m.put('{','}');
        m.put('<','>');
        for (int i = 0; i <s.length();i++) {
            char ch =  s.charAt(i);
            if (ch == '}' || ch == ')' || ch == ']' || ch =='>' ) {
                if(stack.isEmpty())  {
                return false;
                }
                if (ch != m.get(stack.pop())) {
                    
                    return false;
                }
            }
            else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String [] args) {
        System.out.println(validParenthesis("()"));
        System.out.println(validParenthesis("()[]{}<>"));
        System.out.println(validParenthesis("(]"));
        System.out.println(validParenthesis("([)]"));
        System.out.println(validParenthesis("<{[]}>"));
        System.out.println(validParenthesis("(<>"));
        System.out.println(validParenthesis(""));
    }

    
}