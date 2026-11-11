package javaAssignments.algorithms05;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class valid_parens {

    public static void main(String[] args) {
        //String testString = "({[<><>]})";
        //String testString = "({[<><>]})v";
        //System.out.println(isValidChecked(testString, List.of('(', ')', '{', '}', '[', ']', '<', '>')));
    }
    

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); //initialize a stack, as per request
        for (Character c : s.toCharArray()) { //convert this string to a list an array of characters
            if (c != '(' && c != '{' && c != '[' && c != '<' && c != ')' && c != '}' && c != ']' && c != '>') { //checking if the character is a bracket at all
                return false;
            }
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(c); //push the opening bracket onto the stack
            } else {
                if (stack.isEmpty()) { //if the stack is empty, there is no matching opening bracket
                    return false;
                }
                Character top = stack.pop(); //pop the top opening bracket from the stack
                if ((c == ')' && top != '(') || //check if the closing bracket matches the top opening bracket
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[') ||
                    (c == '>' && top != '<')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    //stretch goal one
    public static List<Integer> isValidIndex(String s) {
        List<Integer> invalidIndices = new ArrayList<>(); //list to store the indices of invalid brackets
        Stack<Character> stack = new Stack<>(); //initialize a stack, as per request
        for (int i = 0; i < s.length(); i++) { //convert this string to an array of characters
            Character c = s.charAt(i); //get the current character
            if (c == '(' || c == '{' || c == '[' || c == '<') {
                stack.push(c); //push the opening bracket onto the stack
            } else if (c == ')' || c == '}' || c == ']' || c == '>') {
                if (stack.isEmpty()) { //if the stack is empty, there is no matching opening bracket
                    invalidIndices.add(i); //add the index of the invalid closing bracket
                }
                Character top = stack.pop(); //pop the top opening bracket from the stack
                if ((c == ')' && top != '(') || //check if the closing bracket matches the top opening bracket
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[') ||
                    (c == '>' && top != '<')) {
                    invalidIndices.add(i); //add the index of the invalid closing bracket
                }
            }
            else {
                invalidIndices.add(i); //add the index of the invalid character
            }
        }
        while (!stack.isEmpty()) { //add the indices of any remaining unmatched opening brackets
            invalidIndices.add(s.lastIndexOf(stack.pop()));
        }
        return invalidIndices;
    }


//stretch goal 2
public static boolean isValidChecked(String s, List<Character> charsToCheckList) {
        Stack<Character> stack = new Stack<>(); //initialize a stack, as per request
        List<Character> referenceChars = new ArrayList<>(); //I am using this to later compare my characters to, but I am notably not cleaning this input. I felt it would clutter the method and would not do this on any true genpop facing method
        for (char b : charsToCheckList) {
            if (b == '(' || b == '{' || b == '[' || b == '<' || b == ')' || b == '}' || b == ']' || b == '>') {
                referenceChars.add(b); //add the character to the reference list for later checking
            }
        }
        System.out.println("Reference characters: " + referenceChars);
        for (Character c : s.toCharArray()) { //convert this string to a list an array of characters
            if (referenceChars.contains(c) && c != ')' && c != '}' && c != ']' && c != '>') {
                stack.push(c); //push the opening bracket onto the stack
            } else {
                if (stack.isEmpty()) { //if the stack is empty, there is no matching opening bracket
                    return false;
                }
                Character top = stack.pop(); //pop the top opening bracket from the stack
                if ((c == ')' && top != '(') || //check if the closing bracket matches the top opening bracket
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[') ||
                    (c == '>' && top != '<')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}