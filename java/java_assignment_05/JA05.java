package java_assignment_05;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Scanner;

public class JA05 {
    public static void tallyWords(String sentence){
        String[] words = sentence.split(" ");
        Map<String, Integer> tally = new LinkedHashMap<>();

        // Tally
        for (String word : words){
            int count = 0;
            if (tally.containsKey(word.toLowerCase())){
                // Set count to its current value
                count = tally.get(word.toLowerCase());
            }
            // Increments either way
            tally.put(word.toLowerCase(), count + 1);
        }
        
        // Extract map entries to list
        String[] items = new String[tally.size()];
        int i = 0;
        for (Map.Entry<String, Integer> item : tally.entrySet()){
            items[i] = String.format("%s - %d", item.getKey(), item.getValue());
            i++;
        }
        /* System.out.println(tally); */
        System.out.println(Arrays.toString(items));
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sentence:");
        String sentence = scanner.nextLine();
        scanner.close();
        tallyWords(sentence);
    }
}
