public class Alg03_Assig {
    public static void main(String[] args) {

        System.out.println(compressConsectiveCharcters("aaabbbccd"));
        System.out.println(compressConsectiveCharcters("abcd"));
        System.out.println(compressConsectiveCharcters("aAaA"));
        System.out.println(compressConsectiveCharcters("aaaaaa"));
        System.out.println(compressConsectiveCharcters(""));
    }

    /*

        Compress Consecutive Characters
        Objective
        Practice iterating through a string while comparing adjacent characters, tracking a running count, and building a new string incrementally based on that tracking.

        Instructions
        Write a method that accepts a single parameter: a String.
        The method should return a new String where runs of consecutive, identical characters are replaced with the character followed by the count of how many times it repeated in that run (for example, "aaabbbccd" becomes "a3b3c2d1").
        A character that does not repeat (a run of length 1) should still be followed by a 1 in the output, as shown in the example.
        Runs should be identified case-insensitively — for example, "aA" should be treated as a single run of length 2, not two separate runs. The character used in the compressed output for a given run should match the casing of the first character in that run (for example, "aA" compresses to "a2", while "Aa" compresses to "A2").
        Consider how your method should handle an empty string as input.
        Example Interactions
        Example 1

        Input: "aaabbbccd"
        Output: "a3b3c2d1"
        Example 2 — No repeats

        Input: "abcd"
        Output: "a1b1c1d1"
        Example 3 — Entire string is one run

        Input: "aaaaaa"
        Output: "a6"
        Example 4 — Case-insensitive run, output keeps first character's casing

        Input: "aAaA"
        Output: "a4"
        Example 5 — Empty string

        Input: ""
        Output: ""
        Requirements Checklist
        Method accepts the string as a parameter (not hardcoded)
        Correctly identifies runs of consecutive identical characters
        Runs are identified case-insensitively (e.g., "aA" counts as one run)
        The character used in the output for each run matches the casing of that run's first character
        Correctly appends the character followed by its run count for every run, including runs of length 1
        Empty string input is handled without crashing, and returns an empty string
        Code is organized into at least one clearly named method (avoid putting all logic directly in main)

        First empty string.

        Loop through the input string count the amount of each charcters in string for each speific charcters in the string, whether they are lower or captial letters

        Now fill the empty output string from left to right the charcter and it's count if it was captial letter at the start of each charcter's count that make it captial in the output followed by count of that charcter.

        Now return the output string. 



     */

    public static String compressConsectiveCharcters(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder output = new StringBuilder();
        int i = 0;

        while (i < input.length()) {
            char current = input.charAt(i);
            char runChar = current;
            int count = 1;

            while (i + 1 < input.length() && Character.toLowerCase(input.charAt(i + 1)) == Character.toLowerCase(current)) {
                i++;
                count++;
            }

            output.append(runChar).append(count);
            i++;
        }

        return output.toString();
    }
}
