import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(validP("{}<>[]()"));
    }
    public static boolean validP(String parenthesis){

        //creating my stack
        Stack<String> stack = new Stack<>();

        //if user input nothing it's still balanced
        if(parenthesis == null || parenthesis.isEmpty()) {
            return true;
        } 
        //looping through the input
        for (int i = 0; i < parenthesis.length(); i++) {
            //checking each character
            char c = parenthesis.charAt(i);

            //if beginning parenthesis push to the stack and check for matching end and if there's nothing in the beginning parenthesis return false
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(String.valueOf(c));
            } else if (c == ')' || c == '}' || c == ']' || c == '>') {
                if(stack.isEmpty()){
                    return false;
                }

                // peek to see if end matches beginning
            if (c == ')' && !stack.peek().equals("(")) {
                return false;
            }
            else if (c == '}' && !stack.peek().equals("{")) {
                return false;
            }
            else if (c == ']' && !stack.peek().equals("[")) {
                return false;
            }
            else if (c == '>' && !stack.peek().equals("<")) {
                return false;
            }
                stack.pop();
            }
        }
        //returns stack is empty which is always true
        return stack.isEmpty();
    }
}

