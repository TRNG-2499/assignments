import java.util.Locale;

public class CompressConsecutiveCharacters {
    static void main() {
        /*
        Base test
         */
        System.out.println("Base test\n----------");
        CompressConsecutiveCharacters instance = new CompressConsecutiveCharacters();
        System.out.println(instance.compressCharacters("aaabbbccd"));
        System.out.println(instance.compressCharacters("abcd"));
        System.out.println(instance.compressCharacters("aaaaaa"));
        System.out.println(instance.compressCharacters("aAaA"));
        System.out.println(instance.compressCharacters(""));
        System.out.println(instance.compressCharacters("aaabbbccdAAAA"));

        /*
        Stretch test
         */
        System.out.println("\nStretch test\n----------");
        // only compress when shorter
        System.out.println(instance.compressCharactersStretch("abcd"));
        System.out.println(instance.lossyDecompressCharacters("a4A4b4"));
        System.out.println(instance.lossyDecompressCharacters(""));
        System.out.println(instance.lossyDecompressCharacters("a4A"));
    }

    public String compressCharacters(String uncompressedString) {
        if (uncompressedString == null || uncompressedString.isEmpty()) {
            return "";
        }

        StringBuilder compressedString = new StringBuilder();
        int uncompressedStringLen = uncompressedString.length();

        char prevChar = uncompressedString.charAt(0);
        int consecutiveCharCount = 0;
        for (int i = 0; i < uncompressedStringLen; i++) {
            char curChar = uncompressedString.charAt(i);
            if (Character.toLowerCase(curChar) != Character.toLowerCase(prevChar)) {
                compressedString.append(prevChar);
                compressedString.append(consecutiveCharCount);
                prevChar = curChar;
                consecutiveCharCount = 1;

                // Edge case: End of string, make sure to append
                if (i == (uncompressedStringLen - 1)) {
                    compressedString.append(prevChar);
                    compressedString.append(consecutiveCharCount);
                }
            } else if (i == (uncompressedStringLen - 1)) {
                compressedString.append(prevChar);
                compressedString.append(++consecutiveCharCount);
            } else {
                consecutiveCharCount += 1;
            }
        }
        return compressedString.toString();
    }

    public String compressCharactersStretch(String uncompressedString) {
        if (uncompressedString == null || uncompressedString.isEmpty()) {
            return "";
        }

        StringBuilder compressedString = new StringBuilder();
        int uncompressedStringLen = uncompressedString.length();

        char prevChar = uncompressedString.charAt(0);
        int consecutiveCharCount = 0;
        for (int i = 0; i < uncompressedStringLen; i++) {
            char curChar = uncompressedString.charAt(i);
            if (Character.toLowerCase(curChar) != Character.toLowerCase(prevChar)) {
                compressedString.append(prevChar);
                compressedString.append(consecutiveCharCount);
                prevChar = curChar;
                consecutiveCharCount = 1;

                // Edge case: End of string, make sure to append
                if (i == (uncompressedStringLen - 1)) {
                    compressedString.append(prevChar);
                    compressedString.append(consecutiveCharCount);
                }
            } else if (i == (uncompressedStringLen - 1)) {
                compressedString.append(prevChar);
                compressedString.append(++consecutiveCharCount);
            } else {
                consecutiveCharCount += 1;
            }
        }
        String compressedStringFinal = compressedString.toString();
        if (compressedStringFinal.length() >= uncompressedStringLen) {
            return uncompressedString;
        }
        return compressedString.toString();
    }

    public String lossyDecompressCharacters(String compressedString) {
        if (compressedString == null || compressedString.isEmpty()) {
            return "";
        }
        int compressedStringLen = compressedString.length();
        StringBuilder decompressedString = new StringBuilder();
        StringBuilder nonDigitCharCount = new StringBuilder();
        boolean prevCharIsDigit = true;
        char lastNonDigitChar = 0;

        for (int i = 0; i < compressedStringLen; i++) {
            char curChar = compressedString.charAt(i);
            String digits = "1234567890";

            /*
             Process non-digit character
             */
            boolean curCharIsDigit = digits.contains(Character.toString(curChar));
            if (i == (compressedStringLen - 1) && !curCharIsDigit) {
                // Compression format error: final character in compressed string must be a digit
               return "";
            } else if (!curCharIsDigit) {
                if (!prevCharIsDigit) {
                    // Compression format error: character must be immediately followed by a digit
                   return "";
                } else {
                    // Non-digit is in correct order
                    lastNonDigitChar = curChar;
                    prevCharIsDigit = false;
                    continue;
                }
            }

            /*
             Current char is a digit, process and add integer to decopressedString if it
             is the final digit of the integer
             */

            nonDigitCharCount.append(curChar);

            // Append characters to uncompressedString if we are at end of compressed String or end of int
            if (i == (compressedStringLen - 1) || !digits.contains(Character.toString(compressedString.charAt(i + 1)))) {
                for (int j = 0; j < Integer.parseInt(nonDigitCharCount.toString()); j++) {
                    decompressedString.append(lastNonDigitChar);
                }
                nonDigitCharCount = new StringBuilder();
            }

            prevCharIsDigit = true;
        }
        return decompressedString.toString();
    }
}
