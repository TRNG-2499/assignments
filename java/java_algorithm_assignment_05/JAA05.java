package java_algorithm_assignment_05;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class JAA05 {
    public static Map<Character, Character> makeMap(){
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(',')');
        brackets.put('[',']');
        brackets.put('{','}');
        brackets.put('<','>');
        
        return brackets;
    }

    public static Boolean assess(String inputStr, Map<Character,Character> bracketMap){
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < inputStr.length(); i++){
            char c = inputStr.charAt(i);

            // If opening bracket
            if (bracketMap.containsKey(c)){
                stack.push(c);
            // If closing bracket
            } else {
                // If top of stack is an opening bracket corresponding with curr closing bracket
                if(bracketMap.get(stack.peek()) == c){
                    stack.pop();
                }
            }
        }

        if (stack.size() == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        // Init hashmap
        // Init stack
        // Iterate through input arr
        // Open brackets get pushed,
        // close brackets trigger pop of stack.
        String in = "<{[]}";
        Boolean result = assess(in, makeMap());

        System.out.println(result);
    }
}
