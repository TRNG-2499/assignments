import java.util.Scanner;

public class ConsecutiveCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter the word: ");
        String str = scanner.nextLine();
        System.out.println(compress(str));

    }
    public static String compress(String str){
        //Handle empty String
        if(str == null || str.length() == 0){
            return "";
        }

        StringBuilder result = new StringBuilder();

        int currentCount = 1;
        for(int i = 1; i < str.length(); i++){

            //Let's compare current and previous characters (case-insensitive)
            if(Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(str.charAt(i-1))){
                currentCount++;
            } else {
                result.append(str.charAt(i - currentCount));
                result.append(currentCount);

                currentCount = 1; //reset to 1
            }
        }

        //Append the final consecutive group
        result.append(str.charAt(str.length() - currentCount));
        result.append(currentCount);

        return result.toString();
        

    }
}
