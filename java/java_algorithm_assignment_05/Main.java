import java.util.Stack;

public class Main {

    public static boolean validParenthesis(String input){
        char currentChar;
        boolean isBalanced = true;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++){
            currentChar = input.charAt(i);

            switch(currentChar){
                case ')':
                    if(stack.peek() == '('){
                        stack.pop();
                    } else {
                        isBalanced = false;
                    }
                    break;
                case '}':
                    if(stack.peek() == '{'){
                        stack.pop();
                    } else {
                        isBalanced = false;
                    }
                    break;
                case ']':
                    if(stack.peek() == '['){
                        stack.pop();
                    } else {
                        isBalanced = false;
                    }
                    break;
                case '>':
                    if(stack.peek() == '<'){
                        stack.pop();
                    } else {
                        isBalanced = false;
                    }
                    break;
                default:
                    stack.push(currentChar);
                    break;
            }
        }

        if(!stack.isEmpty()){
            isBalanced = false;
        }

        return isBalanced;
    }

    public static void main(String[] args){

        //Test 1 - Balanced Single Type
        System.out.println("input: ()");
        System.out.println(validParenthesis("()")); //expecting true

        //Test 2 - Balanced Multiple Types
        System.out.println("input: ()[]{}<>");
        System.out.println(validParenthesis("()[]{}<>")); //expecting true

        //Test 3 - Mismatched Types
        System.out.println("input: (]");
        System.out.println(validParenthesis("(]")); //expecting false

        //Test 4 - Wrong Nesting Order
        System.out.println("input: ([)]");
        System.out.println(validParenthesis("([)]")); //expecting false

        //Test 5 - Balanced, nested
        System.out.println("input: <{[]}>");
        System.out.println(validParenthesis("<{[]}>")); //expecting true

        //Test 6 - Unmatched opening bracket
        System.out.println("input: (<>");
        System.out.println(validParenthesis("(<>")); //expecting false

        //Test 7 - Empty String
        System.out.println("input: ");
        System.out.println(validParenthesis("")); //expecting true
    }

}
