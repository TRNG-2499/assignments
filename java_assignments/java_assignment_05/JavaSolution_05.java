package java_assignments.java_assignment_05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JavaSolution_05 {
    public static void main(String[] args) {
        System.out.println(countDupesStretch("The time I went to the store I bought a watermelon"));
        
    }

    public static void countDupes(String sentence){
        String[] words = sentence.toLowerCase().split(" ");
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        for(String word : words){
            System.out.println(word);
            if(wordCount.containsKey(word)){
                wordCount.put(word, wordCount.get(word)+1);
            } else {
                wordCount.put(word, 1);
            }
        }
        System.out.println(wordCount);
    }

    public static String countDupesStretch(String sentence){
        String[] words = sentence.toLowerCase().split(" ");
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        for(String word : words){
            System.out.println(word);
            if(!wordCount.containsKey(word)){
                wordCount.put(word, 1);
            } 
        }

        StringBuilder finalString = new StringBuilder();

       for(String word : wordCount.keySet()){
        finalString.append(word+" ");
       }

        return finalString.toString();
    }

    
}
