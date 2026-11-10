import java.io.*;
import java.util.*;

public class Solution {

    public static String characterCompress(String s){
        /*
        * PSEUDOCODE:
        * input: s (string)
        * initialize compressed with the empty string builder
        * 
        * initialize runningChar with the whitespace character
        * initialize occurenceCount to 0
        * for every character c in s
        *   if the lowercase of c is equal to the lowercase of the runningChar
        *       add occurenceCount with 1
        *   else
        *       if runningChar was not a whitespace character
        *           add the runningCharacter followed by the occurenceCount to compressed
        *       set runningChar to c
        *       reset occurenceCount to 1
        * 
        * return compressed
         */

        StringBuilder compressed = new StringBuilder();

        char runningChar = ' ';
        int occurenceCount = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.toLowerCase(c) == Character.toLowerCase(runningChar)){
                occurenceCount++;
            } else {
                if(runningChar != ' '){
                    compressed.append(runningChar);
                    compressed.append(occurenceCount);
                }
                runningChar = c;
                occurenceCount = 1;
            }
            if(i >= s.length() - 1){
                compressed.append(runningChar);
                compressed.append(occurenceCount);
            }
        }

        return compressed.toString();
    }

    public static void main(String[] args){
        System.out.println(characterCompress("aaabbbccd"));
        System.out.println(characterCompress("abcd"));
        System.out.println(characterCompress("aaaaaa"));
        System.out.println(characterCompress("aAaA"));
        System.out.println(characterCompress(""));
        System.out.println(characterCompress("NOOOOOoooooooo! The sky is FAAAAALLLLLLLLLIIIINNNNG!"));
    }
}
