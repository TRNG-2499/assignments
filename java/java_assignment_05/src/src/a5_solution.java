
import java.util.*;

public class a5_solution  {
    public void solution(String sentence){
        String[] words =  sentence.toLowerCase().split(" "); // split the sentence + case-insensitive
        Map<String,Integer> wordMap = new LinkedHashMap<>();
        for(String word:words){
            wordMap.put(word,wordMap.getOrDefault(word,0)+1);
        }
        System.out.println(wordMap);
    }
    public void removeDupe(String sentence){
        String[] words =  sentence.split(" ");
        List<String> wordList = new ArrayList<>();
        List<String> tempList = new ArrayList<>(); // create another list for the sake of catching any with different casing
        for(String word:words){
            if(tempList.contains(word.toLowerCase())){
                continue;
            }else{
                wordList.add(word);
                tempList.add(word.toLowerCase());
            }
        }
        System.out.println(String.join(" ", wordList));
    }
    public void statistics(String sentence){
        int max = 0;
        int min = Integer.MAX_VALUE;
        ArrayList<String> mostFrequent = new ArrayList<>();
        ArrayList<String> leastFrequent = new ArrayList<>();
        ArrayList<String> longestWord = new ArrayList<>();
        ArrayList<String> shortestWord = new ArrayList<>();
        String[] words =  sentence.toLowerCase().split(" "); // split the sentence + case-insensitive
        longestWord.add(words[0]); // for temporary (possibly)
        shortestWord.add(words[1]); // for temporary (possibly)
        Map<String,Integer > wordMap = new LinkedHashMap<>();
        for(String word:words){
            // longest word part
            if(word.length() > longestWord.getFirst().length()){
                longestWord.clear();
                longestWord.add(word);
            }else if(word.length() == longestWord.getFirst().length() && !longestWord.contains(word)){
                longestWord.add(word);
            }
            // shortest word part
            if(word.length() < shortestWord.getFirst().length()){
                shortestWord.clear();
                shortestWord.add(word);
            }else if(word.length() == shortestWord.getFirst().length() && !shortestWord.contains(word)){
                shortestWord.add(word);
            }

            wordMap.put(word,wordMap.getOrDefault(word,0)+1);
        }

        for(Map.Entry<String,Integer> entry:wordMap.entrySet()){ // find highest and lowest number of words
            int amount = entry.getValue();
            if(amount > max){
                max = amount;
            }
            if(amount < min){
                min = amount;
            }
        }

        for(Map.Entry<String,Integer> entry:wordMap.entrySet()){ // find words with that amount stated
            if(entry.getValue() == max){
                mostFrequent.add(entry.getKey());
            }
            if(entry.getValue() == min){
                leastFrequent.add(entry.getKey());
            }
        }

        System.out.println("The most frequently occurring word(s) in the sentence: " + mostFrequent);
        System.out.println("The least frequently occurring word(s) in the sentence: " + leastFrequent);
        System.out.println("The longest word(s) in the sentence, by character count: " + longestWord);
        System.out.println("The shortest word(s) in the sentence, by character count: " + shortestWord);
    }
    public static void main(String[] args) {
        a5_solution s = new a5_solution();
        s.solution("This is a unique sentence");
        s.solution("This this THAT and THAT and there and then");
        System.out.println("---------- Stretch Goals ----------");
        s.removeDupe("This this THAT and THAT and there and then"); // This THAT and there then
        s.removeDupe("I went to the watermelon store and picked up the watermelon");
        s.statistics("Went to the watermelon store and picked up the watermelon");
    }
}