package assignments.java.java_algorithm_assignment_05;

import java.util.Stack;

public class BalancedParentheses {

    public static void main(String[] args) {
        parenthesesChecker("()");
        parenthesesChecker("()[]{}<>");
        parenthesesChecker("(]");
        parenthesesChecker("([)]");
        parenthesesChecker("<{[]}>");
        parenthesesChecker("(<>");
        parenthesesChecker("<{[]()}{}>");
        parenthesesChecker("");
    }

    public static void parenthesesChecker(String input) {
        Stack<Character> parentheses = new Stack<>();
        char para;
        //char temp;
        boolean result = true;

        //if (input.length() > 0){
            forLoop: for (int x = 0; x < input.length(); x++) {
                para = input.charAt(x);
                switch (para) {
                    case '(', '{', '[', '<':
                        parentheses.push(para);
                        break;
                    case ')':
                        if (parentheses.pop() != '('){
                            result = false;
                            break forLoop;
                        }
                        break;
                    case '}':
                        if (parentheses.pop() != '{'){
                            result = false;
                            break forLoop;
                        }
                        break;
                    case ']':
                        if (parentheses.pop() != '['){
                            result = false;
                            break forLoop;
                        }
                        break;
                    case '>':
                        if (parentheses.pop() != '<'){
                            result = false;
                            break forLoop;
                        }
                        break;
                    default:
                        //nothing
                        break;
                }
            }
        //}

        if (!result || parentheses.size() != 0) {
            System.out.println("false"); 
        }else {
            System.out.println("true");
        }
    }

}
