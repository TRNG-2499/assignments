import java.util.Stack;
public class AlgorithmSolution5 {
    public static void main(String[] args) {
        System.out.println(balance("]"));
    }
    public static boolean balance(String input){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '(' || c == '{' || c == '[' || c == '<')
                stack.push(c);
            else if(!stack.isEmpty()){
                if(c == ')' && stack.peek() != '(')
                    return false;
                if(c == '}' && stack.peek() != '{')
                    return false;
                if(c == ']' && stack.peek() != '[')
                    return false;
                if(c == '>' && stack.peek() != '<')
                    return false;
                stack.pop();
            }
            else
                return false;
        }
        return stack.isEmpty();
    }
}
