public class Algorithm_03 {
    public static String shortString(String str)
    {
        str = str.toLowerCase();
        String result = "";
        int count = 1;
        char currentChar;
        for (int i = 0; i < str.length(); i++) {
            currentChar = str.charAt(i);
            if (i+1 < str.length() && currentChar == str.charAt(i+1))
            {
                count++;
            } else {
                result += currentChar + String.valueOf(count);
                count = 1;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String str = "aAabbccc";
        String shortStr = shortString(str);
        System.out.println("Shortened string: " + shortStr);
    }
}
