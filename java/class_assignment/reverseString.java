package class_assignment;

public class reverseString {
    public static void main(String[] args) {

        // String to be reversed
        String str = "Hello, World!";

        int length = str.length();

        char[] characters = str.toCharArray();

        String reverse = "";

        for (int i = length - 1; i >= 0; i--) {
            reverse += characters[i];
        }

        System.out.println(reverse);

    }
}
