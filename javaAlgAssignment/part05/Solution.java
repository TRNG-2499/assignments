package javaAlgAssignment.part05;
import java.util.HashMap;
import java.util.Stack;
public class Solution {
    public static boolean validParentheses(String s){
        Stack <Character> openingBrackets = new Stack<Character>();
        HashMap <Character,Character> brackets = new HashMap<>();
        brackets.put('(',')');
        brackets.put('{','}');
        brackets.put('[', ']');
        brackets.put('<', '>');

        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if(brackets.containsKey(c)){
                openingBrackets.push(c);
            } else if (openingBrackets.isEmpty() || c != brackets.get(openingBrackets.peek())){
                return false;
            } else{
                openingBrackets.pop();
            }
        }
        if (s.length() == 0){
            return true;
        }
        return openingBrackets.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(validParentheses("()"));
        System.out.println(validParentheses("()[]{}<>"));
        System.out.println(validParentheses("(]"));
        System.out.println(validParentheses("([]]"));
        System.out.println(validParentheses("<{[]}>"));
        System.out.println(validParentheses("(<>"));
        System.out.println(validParentheses(""));

    }
}
