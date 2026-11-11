/*# Valid Parentheses

## Objective

Practice using a stack-based approach to track and validate nested/paired structures — a foundational pattern for problems involving matching, balancing, or nesting.

## Instructions

- Write a method that accepts a single parameter: a `String` containing only the following characters: 
`(`, `)`, `{`, `}`, `[`, `]`, `<`, and `>`. No other characters, letters, or numbers will appear in the input.
- The method should return a `boolean` indicating whether the brackets in the string are **balanced** — 
meaning every opening bracket has a matching closing bracket of the same type, and brackets 
are closed in the correct order (properly nested, not just present in equal counts).
- An empty string should be treated as valid/balanced, since there is nothing unbalanced about it.
- Consider what should happen with a string that has closing brackets with no corresponding opening bracket, 
or leftover unmatched opening brackets at the end — both of these cases should result in `false`.

> **Hint:** This is a natural fit for a `Stack` (from `java.util`): push opening brackets as they're encountered, 
and when a closing bracket is encountered, check that it matches the most recently pushed opening bracket.
*/


import java.util.Scanner;
import java.util.Stack;

public class parentheses {
    
    public static void main(String args[]){

        Scanner myObj = new Scanner(System.in);

        String input = "";

        while(true){


            input = myObj.nextLine();

            if(input.equals("exit")){
                break;
            }

            System.out.println(String.format("input %s: %b", input, balanced(input)));



        }

        myObj.close();

    }



    public static boolean balanced(String s){

        if(s.length() < 1){
            return true;
        }

        char[] open = {'(','[','<','{'};
        char[] close = {')',']','>','}'};
        
        Stack<Character> stack = new Stack<>();
        
        //consecutive and nested allowed. [](), (<>). so just read into the next if they pop each other

        char prev = s.charAt(0);
        char curr = s.charAt(0);
        boolean flag = true;

        for(int i = 0; i < s.length(); i++){

            //if it's a closed parentheses, check if it's a pair

            curr = s.charAt(i);

            if(curr == '}' | curr == ')' | curr == ']' | curr == '>'){
                
                if(is_pair(prev, curr)){
                    stack.pop();

                    if(!stack.isEmpty())
                        {prev = stack.peek();}
                }
                else{
                    flag = false;
                    //System.out.println(String.format("not pair %c %c", prev, curr));
                    break;
                }

            }
            else{
                stack.push(curr);

                prev = curr;
            }

        }

        flag = stack.isEmpty();

        return flag;

    }


    public static boolean is_pair(char a, char b){

        if(a == '(' & b == ')'){
            return true;
        }
        else if(a == '[' & b == ']'){
            return true;
        }
        else if(a == '<' & b == '>'){
            return true;
        }
        else if(a == '{' & b == '}'){
            return true;
        }
        else{
            return false;
        }


    }

}


