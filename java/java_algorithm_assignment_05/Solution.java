import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String... args){
        System.out.println(isBalanced("()"));
        System.out.println(isBalanced("()[]{}<>"));
        System.out.println(isBalanced("(]"));
        System.out.println(isBalanced("([)]"));
        System.out.println(isBalanced("<{[]}>"));
        System.out.println(isBalanced("(<>"));
        System.out.println(isBalanced(""));
    }

    public static boolean isBalanced(String s){
        /*
        * PSEUDOCODE
        * main:
        * input s
        * output true or false
        * 
        * initialize balaceChecker with an empty stack
        * for every character c in s
        *   if c is any of the following: (, ), {, }, [, ], <, >
        *       if IsOpening(c)
        *           push balanceChecker
        *       else if IsClosing(c, balanceChecker)
        *           pop balanceChecker
        * 
        * return that the balanceChecker is empty
        */

        Stack<Character> balanceChecker = new Stack<>();

        for(char c : s.toCharArray()){
            switch(c){
                case '(':
                case ')':
                case '{':
                case '}':
                case '[':
                case ']':
                case '<':
                case '>':
                    if(isOpening(c)){
                        balanceChecker.push(c);
                    } else if(isClosing(c, balanceChecker)){
                        balanceChecker.pop();
                    }
                    break;
                default:
                    break;
            }
        }

        return balanceChecker.size() <= 0;
    }

    private static boolean isOpening(char c){
        /*
        * PROCEDURE 
        * IsOpening:
        * input c
        * output true or false
        * return c is ( or { or [ or <
        * 
        */
        return c == '(' || c == '{' || c == '[' || c == '<';
    }

    private static boolean isClosing(char c, Stack<Character> balanceChecker){
        /*
        * PROCEDURE: 
        * IsClosing:
        * input c, balanceChecker
        * output: true or false
        * 
        * if balanceChecker is empty
        *   initialize pc with NULL
        * else
        *   initialize pc with balanceChecker's top character
        * 
        * if pc is NULL
        *   return false
        * else if pc is (
        *   return c is )
        * else if pc is {
        *   return c is }
        * else if pc is [
        *   return c is ]
        * else if pc is <
        *   return c is >
        * else 
        *   return false
        */
        Character pc;
        try {
            pc = balanceChecker.peek();
        } catch(EmptyStackException e){
            pc = null;
        }

        if(pc == null){
            return false;
        } else if(pc == '('){
            return c == ')';
        } else if(pc == '{'){
            return c == '}';
        } else if(pc == '['){
            return c == ']';
        } else if(pc == '<'){
            return c == '>';
        } else {
            return false;
        }
    }
}
