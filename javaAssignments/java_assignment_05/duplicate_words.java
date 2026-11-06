package javaAssignments.java_assignment_05;

import java.util.ArrayList;
import java.util.HashMap;

public class duplicate_words {

    public static void main(String[] args) {
        // System.out.println(countDupesString("TEST TEST TEST TEST TEST"));
        // System.out.println(countDupesString("This is a test. This test is only a test."));
        // System.out.println(removeDupes("This is a test. This test is only a test."));
        // System.out.println(removeDupes("TEST TEST TEST TEST TEST"));
        // System.out.println(removeDupes("This is a test. This! test? is: only# a$ test."));
        // System.out.println(sentenceStats("This is a test. This test is only a test."));
        // System.out.println(sentenceStats("In a hole in the ground there lived a hobbit. Not a nasty, dirty, wet hole, filled with the ends of worms and an oozy smell, nor yet a dry, bare, sandy hole with nothing in it to sit down on or to eat: it was a hobbit-hole, and that means comfort."));
    }
    
    public static String countDupesString(String str) {
        //I had almost this exact question in a coding competency test once for a job application
        String[] words = str.split(" "); // Split the input string into words using space as the delimiter, since the prompt assumes we receive sentences

        HashMap<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            String normalized = word.toLowerCase();
            counts.put(normalized, counts.getOrDefault(normalized, 0) + 1); //sorting the words as keys to a hashmap with a value of count.
        }
        
        StringBuilder result = new StringBuilder(); //creating a single large string to return the results of the hashmap
        for (String word : counts.keySet()) {
            int count = counts.get(word);
            if (count > 1) {
                result.append(word).append(" - ").append(count).append("\n"); // Append the word and its count to the result string if it appears more than once
            }
        }
        return result.toString();
    }


    public static String removeDupes(String str){
        str = str.replaceAll("[^a-zA-Z0-9\\s]", ""); //removing all non-alphanumeric characters from the string.
        
        //Something I hadn't considered at first is that this treats non-alphanumeric characters as part of the word, so "test." and "test" came out as different words. 
        //I will be cleaning the strings going forwards to avoid this.
        String[] words = str.split(" ");//splitting a sentence by spaces


        //I don't think this one needs a hashmap, since we only care about one instance we could simply create a new list and decline to copy any word already in it.
        ArrayList<String> cleaned = new ArrayList<>();

        for (String word : words) {
            if (!cleaned.contains(word)) {
                cleaned.add(word);
            }
        }
        return String.join(" ", cleaned);
    }

    public static String sentenceStats(String str){
        //first step is to clean this
        str = str.replaceAll("[^a-zA-Z0-9\\s]", ""); //removing all non-alphanumeric characters from the string.

        //splitting a sentence by spaces
        String[] words = str.split(" ");
        
        //creating a hashmap of the words and their counts, since we will need to know this for the most and least frequent words.
        HashMap<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            String normalized = word.toLowerCase();
            counts.put(normalized, counts.getOrDefault(normalized, 0) + 1); //sorting the words as keys to a hashmap with a value of count.
        }

        ArrayList<String> mostFrequentWords = new ArrayList<>();        
        ArrayList<String> leastFrequentWords = new ArrayList<>();       
        ArrayList<String> longestWords = new ArrayList<>();            
        ArrayList<String> shortestWords = new ArrayList<>();           
        int maxCount = 0;
        int minCount = 0;
        int maxLength = 0;
        int minLength = 0;
        for (String word : counts.keySet()) {
            int count = counts.get(word);
            if (count > maxCount || minCount == 0) {    // - The most frequently occurring word(s) in the sentence (report all of them if there is a tie)
                maxCount = count;
                mostFrequentWords.clear();
                mostFrequentWords.add(word);
            } else if (count == maxCount) {
                mostFrequentWords.add(word);
            }
            if (count < minCount || minCount == 0) {    // - The least frequently occurring word(s) in the sentence (report all of them if there is a tie)
                minCount = count;
                leastFrequentWords.clear();
                leastFrequentWords.add(word);
            } else if (count == minCount) {
                leastFrequentWords.add(word);
            }
            if (word.length() > maxLength || maxLength == 0) { // - The longest word(s) in the sentence, by character count (report all of them if there is a tie)
                maxLength = word.length();
                longestWords.clear();
                longestWords.add(word);
            } else if (word.length() == maxLength) {
                longestWords.add(word);
            }
            if (word.length() < minLength || minLength == 0) { // - The shortest word(s) in the sentence, by character count (report all of them if there is a tie)
                minLength = word.length();
                shortestWords.clear();
                shortestWords.add(word);
            } else if (word.length() == minLength) {
                shortestWords.add(word);
            }
        }
        //this is an abomination of a return statement.
        return "Most Frequent Words: " + String.join(", ", mostFrequentWords) + "\n" + " count: " + maxCount + "\n" +
               "Least Frequent Words: " + String.join(", ", leastFrequentWords) + "\n" + " count: " + minCount + "\n" +
               "Longest Words: " + String.join(", ", longestWords) + "\n" + " length: " + maxLength + "\n" +
               "Shortest Words: " + String.join(", ", shortestWords) + "\n" + " length: " + minLength;
    }
}
