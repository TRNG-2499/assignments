public class ConsecutiveCharacters {
    
    public static String Compress(String string) {
        char[] charArray = string.toCharArray();

        StringBuilder strBuild = new StringBuilder();

        int i = 0;
        while (i < charArray.length) {
            char lowerChar = Character.toLowerCase(charArray[i]);
            char actualChar = charArray[i];

            strBuild.append(actualChar);
            int dupeCount = 1;

            while (i+1 < charArray.length && lowerChar == Character.toLowerCase(charArray[i+1])) {
                dupeCount += 1;
                i += 1;
            }

            strBuild.append(Integer.toString(dupeCount));

            i += 1;
        }

        return strBuild.toString();
    }


    public static String CompressIfShorter(String string) {
        char[] charArray = string.toCharArray();

        StringBuilder strBuild = new StringBuilder();

        int i = 0;
        while (i < charArray.length) {
            char lowerChar = Character.toLowerCase(charArray[i]);
            char actualChar = charArray[i];

            strBuild.append(actualChar);
            int dupeCount = 1;

            while (i+1 < charArray.length && lowerChar == Character.toLowerCase(charArray[i+1])) {
                dupeCount += 1;
                i += 1;
            }

            strBuild.append(Integer.toString(dupeCount));

            i += 1;
        }

        String result;
        if (strBuild.toString().length() < string.length()) {
            result = strBuild.toString();
        } else {
           result = string;
        }
        return result;
    }


    public static String Decompress(String compressedString) {
        char[] charArray = compressedString.toCharArray();

        StringBuilder strBuild = new StringBuilder();

        // Assumes input param is always a correctly formed letter + count
        int i = 0;
        while (i < charArray.length) {
            char ogChar = charArray[i];

            StringBuffer digits = new StringBuffer();
            while (i+1 < charArray.length && Character.isDigit(charArray[i+1])) {
                digits.append(charArray[i+1]);
                i += 1;
            }
            int dupeCount = Integer.parseInt(digits.toString());

            for (int j = 0; j < dupeCount; j++) {
                strBuild.append(ogChar);
            }
            i += 1;
        }

        return strBuild.toString();
    }


    public static void main(String[] args) {
        String result = Compress("aaabbbccd");
        System.out.println(result);

        System.out.println(CompressIfShorter("aabb"));
        System.out.println(CompressIfShorter("aaabbb"));

        System.out.println(Decompress("a3B2c1"));
    }  
}