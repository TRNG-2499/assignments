import java.util.Map;
import java.util.HashMap;

public class RomanNumeralConverter {

    //Have something separate for both toInteger and toRoman
    public static String toRoman(int number){

        if(number < 1 || number > 3999){
            throw new IllegalArgumentException("Number has to be between 1 and 3999");
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < values.length; i++){
            while(number >= values[i]){
                result.append(symbols[i]);
                number -= values[i];
            }
        }
        return result.toString().toUpperCase();
    }

    public static int toInteger(String roman){

        if(roman == null || roman.isBlank()){
            throw new IllegalArgumentException("Roman numeral cannot be null or empty.");
        }
        
        roman = roman.toUpperCase();

        if(!roman.matches("[IVXLCDM]+")){
            throw new IllegalArgumentException("Invalid Roman numeral characters.");
        }

        Map<Character, Integer> values = new HashMap<>();

        values.put('I', 1); 
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int result = 0;

        for(int i = 0; i < roman.length(); i++){
            int current = values.get(roman.charAt(i));
            if(i + 1 < roman.length() && current < values.get(roman.charAt(i + 1))){
                result -= current;
            }
            else{
                result += current;
            }
        }
        if(result < 1 || result > 3999 || !toRoman(result).equals(roman)){
            throw new IllegalArgumentException("Invalid Roman numeral format.");
        }


        return result;
    }
    
}
