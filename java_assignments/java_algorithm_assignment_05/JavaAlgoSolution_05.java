package java_assignments.java_algorithm_assignment_05;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class JavaAlgoSolution_05 {
    public static void main(String[] args) {
        System.out.println(balancedParenthesis("))"));
        
    }

    public static boolean balancedParenthesis(String input){
        boolean output = true;

        //cant be balanced if uneven
        if(input.length()%2!=0){
            return false;
        }

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('{', '}');
        pairs.put('<', '>');
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<input.length(); i++){

            if(pairs.containsKey(input.charAt(i))){
                st.push(input.charAt(i));
            } else { 
                if(pairs.get(st.pop()) != input.charAt(i)){
                    return false;
                }
            }
        }



        return output;
    }
}
