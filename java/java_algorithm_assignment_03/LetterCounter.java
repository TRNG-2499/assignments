package assignments.java.java_algorithm_assignment_03;

public class LetterCounter {
    public static void main(String[] args) {
        runReader("aaabbbccd");
        runReader("abcd");
        runReader("aaaaaa");
        runReader("aAaA");
        runReader("abbcccdd");
        runReader("");
    }

    public static void runReader(String sentence) {
        String output = "";

        if (sentence.length() > 0) {
            sentence = sentence.toLowerCase();
            char letter = sentence.charAt(0);
            char temp = letter;
            int count = 0;

            while(sentence.length() > 0) {
                temp = sentence.charAt(0);
                if (temp == letter) {
                    count += 1;
                }else {
                    output += (""+letter+count);
                    letter = temp;
                    count = 1;
                }
                sentence = sentence.substring(1, sentence.length());
            }
            output += (""+letter+count); 
        }

        System.out.println(output);
    }
}
