

public class CompressConsecutiveCharacters {
    public static String compress(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        str = str.toLowerCase();

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i - 1));
                compressed.append(count);
                count = 1;
            }
        }

        compressed.append(str.charAt(str.length() - 1));
        compressed.append(count);

        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    public static void main(String[] args) {
        String input1 = "aaabbbccd";
        String input2 = "abcd";
        String input3 = "aaaaaa";
        String input4 = "aAaA";
        String input5 = "";

        System.out.println(compress(input1)); 
        System.out.println(compress(input2));
        System.out.println(compress(input3));
        System.out.println(compress(input4));
        System.out.println(compress(input5));
    }

}

