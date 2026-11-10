public class CharacterCompressor {
    public static void main(String[] args) {
        System.out.println("Output: " + compressString("aaabbbccd"));
        System.out.println("Output: " + compressString("abcd"));
        System.out.println("Output: " + compressString("aaaaaa"));
        System.out.println("Output: " + compressString("aAaA"));
    }

    private static String compressString(String str) {
        if (str.isEmpty()) return "";

        int len = str.length();
        if (len == 1)
            return str + "1";

        StringBuilder newStr = new StringBuilder();
        char prevLetter = Character.toLowerCase(str.charAt(0));
        int repeatCount = 1;

        for (int i = 1; i < len; i++) {
            char currLetter = Character.toLowerCase(str.charAt(i));
            if (currLetter == prevLetter) {
                repeatCount++;
            } else {
                newStr.append(prevLetter).append(repeatCount);
                repeatCount = 1; // reset
            }
            prevLetter = currLetter;
        }

        newStr.append(prevLetter).append(repeatCount);

        return newStr.toString();
    }
}
