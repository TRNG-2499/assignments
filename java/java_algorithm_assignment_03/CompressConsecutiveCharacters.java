public class CompressConsecutiveCharacters {

    public static String compress(String input) {
        // An empty string has no first character to read.
        if (input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        // Save the first character as written so we can keep its casing.
        char runStart = input.charAt(0);
        int count = 1;

        // Start at index 1 because we already counted the first character.
        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);

            // Compare lowercase versions so letters like 'A' and 'a' match.
            if (Character.toLowerCase(current) == Character.toLowerCase(runStart)) {
                count++;
            } else {
                // A different character ends the run. Save it and start a new one.
                result.append(runStart).append(count);
                runStart = current;
                count = 1;
            }
        }

        // Save the final run, even if it contains just one character.
        result.append(runStart).append(count);
        return result.toString();
    }

    public static void main(String[] args) {
        // 'A' and 'a' form one run. The single 'b' still gets a count of 1.
        String input = "Aab";
        System.out.println(compress(input)); // A2b1
    }
}