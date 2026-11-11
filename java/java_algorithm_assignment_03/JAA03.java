package java_algorithm_assignment_03;

import java.util.LinkedHashMap;
import java.util.Map;

public class JAA03 {
    
    public static LinkedHashMap<Character, Integer> makeMap(String str){
        char[] letters = str.toCharArray();
        LinkedHashMap<Character, Integer> tally = new LinkedHashMap<>();

        for(char letter : letters){
            char letterUp = Character.toUpperCase(letter);
            char letterDown = Character.toLowerCase(letter);
            // If neither variant of letter in letters, add this variant to letters as key.
            if (!tally.containsKey(letterUp) && !tally.containsKey(letterDown)){
                tally.put(letter, 1);
            // If what's already there is lower and the current is upper, just increment lower.
            } else if (tally.containsKey(letterDown) && (letter == letterUp)){
                int count = tally.get(letterDown);
                tally.put(letterDown, count + 1);
            // If what's already there is upper and the current is lower, just increment upper.
            } else if (tally.containsKey(letterUp) && (letter == letterDown)){
                int count = tally.get(letterUp);
                tally.put(letterUp, count + 1);
            // Otherwise, assume they're identical and just increment the value.
            } else {
                int count = tally.get(letter);
                tally.put(letter, count + 1);
            }
        }

        return tally;
    }

    public static String makeString(LinkedHashMap<Character, Integer> map){
        // Break map out into separate arrays of keys and values
        String pairs = "";
        // For loop through both simultaneously, appending latter (as chars) to former
        for (Map.Entry<Character, Integer> item : map.entrySet()){
            pairs += String.format("%c%d", item.getKey(), item.getValue());
        }
        return pairs;
    }
    
    public static void main(String[] args){
        // Make freq map of letters
        //  Check casing on first incidence of each letter
        // Sort freq map alphabetically by key
        // Concatenate each key-value pair to an output string

        String in = "";

        String out = makeString(makeMap(in));

        System.out.print(out);

    }
}
