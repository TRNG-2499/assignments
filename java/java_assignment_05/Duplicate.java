package java.java_assignment_05;


public class Duplicate {
    public static void count(String sentence){
        String[] words = sentence.toLowerCase().trim().split("\\s+");
        String[] uniqueWords = new String[words.length];
        int[] counts = new int[words.length];
        int uniqueCount = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean found = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueWords[j].equals(word)) {
                    counts[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
            uniqueWords[uniqueCount] = word;
            counts[uniqueCount] = 1;
            uniqueCount++;
        }
    }
    for (int i = 0; i < uniqueCount; i++) {
        System.out.println(uniqueWords[i] + ": " + counts[i]);
    }
}
public static void main(String[] args) {
    count("The cat and the hat");
    System.out.println("------------------------------");

    count("Hello hello HELLO world");
    System.out.println("------------------------------");

    count("one");
    System.out.println("------------------------------");

    count("  extra   spaces  between   words  words ");
}

}
