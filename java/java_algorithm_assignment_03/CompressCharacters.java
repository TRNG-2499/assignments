public class CompressCharacters {

    public static String compress(String text) {
        if (text.equals("")) {
            return "";
        }

        char current = text.charAt(0);
        int count = 1;
        String result = "";

        for (int i = 1; i < text.length(); i++) {
            if (Character.toLowerCase(text.charAt(i)) == Character.toLowerCase(current)) {
                count++;
            } else {
                result = result + current + count;
                current = text.charAt(i);
                count = 1;
            }
        }

        result = result + current + count;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(compress("aaabbbccd"));
        System.out.println(compress("abcd"));
        System.out.println(compress("aaaaaa"));
        System.out.println(compress("aAaA"));
        System.out.println(compress(""));
    }
}
