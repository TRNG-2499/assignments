import java.util.Stack;

public class Algorithm_05 {
    public static boolean vaildParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (current == '(' || current == '{' || current == '[' || current == '<')
            {
                stack.push(s.charAt(i));
                continue;
            } else if (current == ')' || current == '}' || current == ']' || current == '>')
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                Character top = stack.peek();
                if (top == '(' && current == ')')
                {
                    stack.pop();
                    continue;
                } 

                if (top == '{' && current == '}')
                {
                    stack.pop();
                    continue;
                }

                if (top == '[' && current == ']')
                {
                    stack.pop();
                    continue;
                }

                if (top == '<' && current == '>')
                {
                    stack.pop();
                    continue;
                }
                return false;

            }
            
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(vaildParentheses("(){}"));
        System.out.println(vaildParentheses("{}]"));
        System.out.println(vaildParentheses("({})"));
    }
}
