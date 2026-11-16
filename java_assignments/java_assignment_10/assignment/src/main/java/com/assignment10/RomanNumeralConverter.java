package com.assignment10;
import java.util.Map;

public class RomanNumeralConverter {
    private static int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static String[] symbols = {"M", "CM", "D", "CD","C","XC","L","XL","X","IX","V","IV","I"};
    private static Map<Character, Integer> charToIntMap = Map.of(
        'i', 1,
        'v',5,
        'x', 10,
        'l', 50,
        'c', 100,
        'd', 500,
        'm', 1000
    );

    public static String toRoman(int input) throws IllegalArgumentException{
        if(input < 1 || input > 3999){
            throw new IllegalArgumentException("Error: Invalid number to convert to roman numeral: "+input);
        }
        
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < symbols.length; i++){
            while(input >= nums[i]){
                sb.append(symbols[i]);
                input -= nums[i];
            }
        }

        return sb.toString();
    }

    public static int toInteger(String input) throws IllegalArgumentException{
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException("Error: Input is blank or null.");
        }

        input = input.toLowerCase();
        for(Character c : input.toCharArray()){
            if(!charToIntMap.containsKey(c)){
                throw new IllegalArgumentException("Error: Invalid symbol: "+c);
            }
        }

        int output = 0;
        
        for(int i = 0; i < input.length(); i++){
            char current = input.charAt(i);
            
            if(i + 1 < input.length() && charToIntMap.get(current) < charToIntMap.get(input.charAt(i+1))){
                output -= charToIntMap.get(current);
            } else{
                output += charToIntMap.get(current);
            }
        }
        
        return output;
    }
}
