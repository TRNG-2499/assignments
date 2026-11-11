package java_algorithm_assignment_03;

import java.util.HashMap;
import java.util.Map;

public class compressChar {
    public static String compress(String input) {
        StringBuilder output = new StringBuilder();
        if (input == null || input.isEmpty() || input.isBlank()) {
            return "";
        }
        input = input.toLowerCase().trim();
        Map<Character, Integer> count = new HashMap<>();

        for (Character c : input.toCharArray()) {
            if(count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
                
            }
        }
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();

            output.append(key);
            output.append(value);
        }
        return output.toString();
    }

    public static String onlyShorter(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            return "";
        }
        input = input.toLowerCase().trim();

        int ogInput = input.length();
        int compressedInput = compress(input).length();

        if (compressedInput < ogInput) {
            return compress(input);
        } else {
            return input;
        }
    }

    public static String decompress(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            return "";
        }
        input = input.toLowerCase().trim();
        StringBuilder output = new StringBuilder();

        char[] tempInput = input.toCharArray();
        char currentChar = tempInput[0];
        for (int i = 1; i < tempInput.length; i++) {
            if (Character.isDigit(tempInput[i])) {
                int n = Character.getNumericValue(tempInput[i]);
                for (int j = 0; j < n; j++) {
                    output.append(currentChar);
                }
            } else {
                currentChar = tempInput[i];
            }
        }
        
        return output.toString();
    }
        

    public static void main(String[] args) {
        System.out.println(compress("aaabbbbccd"));
        System.out.println(compress("abcd"));
        System.out.println(compress("aaaAAA  "));
        System.out.println(compress(""));

        System.out.println("Optimal Compression");
        System.out.println(onlyShorter("aa"));
        System.out.println(onlyShorter("aaaaawwwwwww"));

        System.out.println("Decompress");
        System.out.println(decompress(""));
        System.out.println(decompress("a3b4c2d1"));
        System.out.println(decompress("a3"));
        System.out.println(decompress("a1b1c1d1"));
    }
}
