import java.util.Scanner;

public class DuplicateWords{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write a sentence.");
        String sentence = scanner.nextLine();
        countWords(sentence);

        scanner.close();


    }

    public static void countWords (String sentence){

    //Let's convert sentence into lowercase first and then split words.
    // Example: "The time I went for the first time to fair I had the boat ride"

        String [] words = sentence.toLowerCase().split("\\s+");

    //Let's create a boolean array, here we are going to create another array with the same number of positions as our words array.
    //Initially, java automatically assigns false to every position.
    //If same words repeated twice (ex, the) we have to count once. Boolean array helps us remember that we already processed its duplicate.

    boolean [] counted = new boolean[words.length];
    boolean firstWord = true;

    //Let's go through each word
    for(int i =0 ; i<words.length; i++){

        if(counted[i]) {
            continue;
        }

        int count = 1;

        for (int j = i+1; j<words.length; j++){

            if(words[i].equals(words[j])){
                count ++;
                counted[j] = true;
            }
        }

        if(!firstWord){
            System.out.print(" , ");
        }
        System.out.print(words[i] + " - " + count);
        firstWord = false;
    }
        System.out.println();
    }

}



