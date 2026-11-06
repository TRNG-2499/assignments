package assignment02.part05;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void dupWords(String sentence){
        Map<String, Integer> data = new LinkedHashMap<>();
        String [] sentenceSplit = sentence.split(" ");
        for (String word : sentenceSplit){
            word = word.toLowerCase();
            if (data.containsKey(word)){
                data.put(word, data.get(word) + 1);
            }
            else{
                data.put(word, 1);
            }
        }
        for (String key : data.keySet()){
            System.out.print(key + " - " + data.get(key) + ", ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        dupWords(userInput);
        sc.close();
    }

}
