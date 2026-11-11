
public class Main {
    public static void main(String[] args) {
        System.out.println(checkString("aaabbbccd"));
        System.out.println(checkString("abcd"));
        System.out.println(checkString("aaaaaa"));
        System.out.println(checkString("aAaA"));
        System.out.println(checkString(""));

        System.out.println(checkStringCompress("aaabbbccd"));
        System.out.println(checkStringCompress("abcd"));
        System.out.println(checkStringCompress("aaaaaa"));
        System.out.println(checkStringCompress("aAaA"));
        System.out.println(checkStringCompress(""));

        System.out.println(decompress(checkString("aaabbbccd")));
        System.out.println(decompress(checkString("abcd")));
        System.out.println(decompress(checkString("aaaaaa")));
        System.out.println(decompress(checkString("aAaA")));
        System.out.println(decompress(checkString("")));
    }

    /**
     * Counts the frequency of each character in the input string and returns a 
     * formatted string containing each unique character followed by its occurrence count.
     * 
     * @param input the target string to be analyzed
     * @return a concatenated string of characters and their respective frequencies, 
     *         or an empty string if the input is null or empty
     */
    public static String checkString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        char lastCharacter = input.charAt(0);
        int count = 1;
        
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.toLowerCase(c) == lastCharacter || Character.toUpperCase(c) == lastCharacter) {
                count++;
            } else {
                result.append(lastCharacter).append(count);
                lastCharacter = c;
                count = 1;
            }
        }
        result.append(lastCharacter).append(count);
        return result.toString();
    }

    /**
     * Counts the frequency of each character in the input string and returns a 
     * formatted string containing each unique character followed by its occurrence count
     * or the original string (whichever one is shorter).
     * 
     * @param input the target string to be analyzed
     * @return a concatenated string of characters and their respective frequencies, 
     *         or an empty string if the input is null or empty or the original string if its 
     *         length is shorter then the concatenated string
     */
    public static String checkStringCompress(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        char lastCharacter = input.charAt(0);
        int count = 1;
        
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.toLowerCase(c) == lastCharacter || Character.toUpperCase(c) == lastCharacter) {
                count++;
            } else {
                result.append(lastCharacter).append(count);
                lastCharacter = c;
                count = 1;
            }
        }
        result.append(lastCharacter).append(count);
        if (result.toString().length() < input.length()) {
            return result.toString();
        }
        return input;
    }

    /**
     * Decompresses the encrypted string.
     * @param input The encrypted string.
     * @return The original string.
     */
    public static String decompress(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        int n = input.length();

        while (i < n) {
            char c = input.charAt(i);
            i++;

            int count = 0;
            while (i < n && input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                count = count * 10 + (input.charAt(i) - '0');
                i++;
            }

            for (int j = 0; j < count; j++) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}