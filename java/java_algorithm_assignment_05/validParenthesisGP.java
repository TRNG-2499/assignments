import java.util.Stack;

public class validParenthesisGP {
    public static void main(String[] args) {
        System.out.println(checkValid("([)"));
    }
    public static Boolean checkValid(String input) {
        Stack<String> myStack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            if(String.valueOf(input.charAt(i)).equals("(") || String.valueOf(input.charAt(i)).equals("{") || String.valueOf(input.charAt(i)).equals("[")) {
                myStack.push(String.valueOf(input.charAt(i)));
            }
            else if (String.valueOf(input.charAt(i)).equals(")") || String.valueOf(input.charAt(i)).equals("}") || String.valueOf(input.charAt(i)).equals("]")) {
                if (myStack.isEmpty()) {
                    return false;
                }
                String top = myStack.peek();
                if ((String.valueOf(input.charAt(i)).equals(")") && !top.equals("(")) ||
                        (String.valueOf(input.charAt(i)).equals("}") && !top.equals("{")) ||
                        (String.valueOf(input.charAt(i)).equals("]") && !top.equals("["))) {
                    return false;
                }
                myStack.pop();
            }

        }
        return true;
    }
}
