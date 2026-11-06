import java.util.*;

public static void main(String[] args){
    //Scanner if for testing purposes
    Scanner scanner = new Scanner(System.in);

    System.out.println("Print the sentence you would like tokenized");
    String input = scanner.nextLine();

    StringMapping(input);

    scanner.close();
}

public static void StringMapping(String sentence){
    String[] sentence_array = sentence.toLowerCase().split(" ");

    Map<String, Integer> wordCount = new LinkedHashMap<>();

    for(String word : sentence_array){
        wordCount.merge(word,1,Integer::sum);
    }
    wordCount.forEach((word, count) -> System.out.println(word + ":" + count));
}