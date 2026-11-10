package java_assignments.java_algorithm_assignment_03;

import java.util.HashMap;
import java.util.Map;

public class JavaAlgoSolution_03 {
    public static void main(String[] args) {
       String test = consecCharsStretch("AAaabBbCcc");

       System.out.println("String entering decompresser: "+test+"\nString after decompression: "+decompCharsStretch(test));
    }

    public static String consecChars(String input){
        if(input.isBlank()){
            return "Input is blank";
        }
        char[] charArr = input.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();

        for(char c : charArr){
            if(charMap.containsKey(c)){
                charMap.put(c, charMap.get(c)+1);
            } else if(charMap.containsKey(Character.toLowerCase(c))){
                charMap.put(Character.toLowerCase(c), charMap.get(Character.toLowerCase(c))+1);
            } else if(charMap.containsKey(Character.toUpperCase(c))){
                charMap.put(Character.toUpperCase(c), charMap.get(Character.toUpperCase(c))+1);
            } else {
                charMap.put(c, 1);
            }
        }

        String output = "";
        for(Map.Entry<Character, Integer> entry : charMap.entrySet()){
            output += entry.getKey() + Integer.toString(entry.getValue());
        }

        return output;
    }

    public static String consecCharsStretch(String input){
        if(input.isBlank()){
            return "Input is blank";
        }
        char[] charArr = input.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();

        for(char c : charArr){
            if(charMap.containsKey(c)){
                charMap.put(c, charMap.get(c)+1);
            } else if(charMap.containsKey(Character.toLowerCase(c))){
                charMap.put(Character.toLowerCase(c), charMap.get(Character.toLowerCase(c))+1);
            } else if(charMap.containsKey(Character.toUpperCase(c))){
                charMap.put(Character.toUpperCase(c), charMap.get(Character.toUpperCase(c))+1);
            } else {
                charMap.put(c, 1);
            }
        }

        String output = "";
        for(Map.Entry<Character, Integer> entry : charMap.entrySet()){
            output += entry.getKey() + Integer.toString(entry.getValue());
        }

        if(output.length() < input.length()){
            return output;
        }

        return input;
        
    }

    public static String decompCharsStretch(String input){
        char[] charArr = input.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();

        for(int i = 0; i < charArr.length; i+=2){
            charMap.put(charArr[i], Character.getNumericValue(charArr[i+1]));
        }

        String output="";
        for(Map.Entry<Character, Integer> entry : charMap.entrySet()){
            for(int i = 0; i < entry.getValue(); i++){
                output+=entry.getKey();
            }
        }

        


        return output;
    }


}
