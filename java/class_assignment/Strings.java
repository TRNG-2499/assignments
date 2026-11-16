/*
 * STRING MANIPULATION PRACTICE (LeetCode / HackerRank easy level)
 *
 * How to use:
 *   1. Fill in each method below. Each one returns a placeholder value for now.
 *   2. Read the hints only if you get stuck. They go from small nudge to bigger nudge.
 *   3. Run the file. main() prints PASS or FAIL for every test case.
 *
 *   Compile & run:  javac Strings.java  then  java Strings
 */
public class Strings {

    // =====================================================================
    // 1. Reverse a String
    // Return the string reversed. Don't use StringBuilder.reverse().
    // "hello" -> "olleh"
    // "Revature" -> "erutaveR"
    //
    // Hint 1: Loop through the string starting from the LAST index.
    // Hint 2: The last index is s.length() - 1.
    // Hint 3: Add each charAt(i) to a StringBuilder, then call toString().
    // =====================================================================
    public static String reverse(String s) {
        // TODO
        int pointer = s.length() - 1;

        StringBuilder reversed = new StringBuilder();
        while (pointer >= 0) {
            reversed.append(s.charAt(pointer));
            pointer--;
        }
        return reversed.toString();
    }

    // =====================================================================
    // 2. Count Vowels
    // Return how many vowels (a, e, i, o, u, any case) are in the string.
    // "Programming" -> 3
    // "AEIOU xyz" -> 5
    //
    // Hint 1: Convert the string to lowercase first so you only check 5 letters.
    // Hint 2: Loop with toCharArray() or charAt(i).
    // Hint 3: "aeiou".indexOf(c) != -1 tells you if c is a vowel.
    // =====================================================================
    public static int countVowels(String s) {
        // TODO
        s = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case 'a':
                    count++;
                    break;
                case 'e':
                    count++;
                    break;
                case 'i':
                    count++;
                    break;
                case 'o':
                    count++;
                    break;
                case 'u':
                    count++;
                    break;
            }
        }
        return count;
    }

    // =====================================================================
    // 3. Valid Palindrome
    // Return true if the string reads the same forwards and backwards.
    // Only count letters and digits, and ignore case.
    // "A man, a plan, a canal: Panama" -> true
    // "race a car" -> false
    //
    // Hint 1: Use two pointers: one at the start, one at the end.
    // Hint 2: Skip a character if !Character.isLetterOrDigit(c).
    // Hint 3: Compare with Character.toLowerCase() on both sides, then move
    // the pointers toward each other until they meet.
    // =====================================================================
    public static boolean isPalindrome(String s) {
        // TODO

        s = s.toLowerCase();

        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start)))
                start++;
            while (start < end && !Character.isLetterOrDigit(s.charAt(end)))
                end--;
            if (start <= end && s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }

    // =====================================================================
    // 4. Length of Last Word
    // Words are separated by spaces, possibly with extra spaces.
    // Return the length of the last word.
    // "Hello World" -> 5
    // " fly me to the moon " -> 4
    //
    // Hint 1: The trailing spaces are the tricky part. trim() removes them.
    // Hint 2: After trimming, lastIndexOf(' ') finds where the last word starts.
    // Hint 3: Alternative: loop backwards, skip spaces, then count letters
    // until you hit a space or the start.
    // =====================================================================
    public static int lengthOfLastWord(String s) {
        // TODO

        int length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length > 0) {
                break;
            }
        }

        return length;
    }

    // =====================================================================
    // 5. Valid Anagram
    // Return true if t uses exactly the same letters as s, in any order.
    // Assume lowercase letters only.
    // "anagram", "nagaram" -> true
    // "rat", "car" -> false
    //
    // Hint 1: If the lengths differ, it can't be an anagram.
    // Hint 2: Make an int[26] array. Index for a letter is (c - 'a').
    // Hint 3: Add 1 for each letter in s, subtract 1 for each letter in t.
    // If every slot ends at 0, it's an anagram.
    // (Another way: sort both char arrays with Arrays.sort and compare.)
    // =====================================================================
    public static boolean isAnagram(String s, String t) {
        // TODO
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
        // The code above already returns true if it's an anagram and false otherwise.
        // So the following return false is unreachable and can be removed.

    }

    // =====================================================================
    // 6. First Unique Character
    // Return the index of the first character that appears only once.
    // If there isn't one, return -1. Assume lowercase letters only.
    // "leetcode" -> 0
    // "loveleetcode" -> 2
    // "aabb" -> -1
    //
    // Hint 1: You need two passes over the string.
    // Hint 2: Pass 1: count every character using an int[26] array.
    // Hint 3: Pass 2: loop by index and return the first i whose count is 1.
    // =====================================================================
    public static int firstUniqChar(String s) {
        // TODO

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[(s.charAt(i) - 'a')]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    // =====================================================================
    // 7. Reverse Words in a String
    // Reverse the order of the words. Single spaces between words,
    // no spaces at either end.
    // "the sky is blue" -> "blue is sky the"
    // " hello world " -> "world hello"
    //
    // Hint 1: trim() first, then split("\\s+") splits on ONE OR MORE spaces.
    // Hint 2: Loop over the words array backwards.
    // Hint 3: Append each word to a StringBuilder with a space, but don't add
    // a space after the last one (or trim() at the end).
    // (String.join(" ", ...) is also handy.)
    // =====================================================================
    public static String reverseWords(String s) {
        // TODO
        return "";
    }

    // =====================================================================
    // 8. Capitalize Each Word
    // Uppercase the first letter of every word and lowercase the rest.
    // Assume words are separated by single spaces.
    // "hello wORLD from java" -> "Hello World From Java"
    //
    // Hint 1: split(" ") to get the words.
    // Hint 2: For each word: word.substring(0, 1).toUpperCase()
    // + word.substring(1).toLowerCase()
    // Hint 3: Join them back together with spaces.
    // =====================================================================
    public static String capitalizeWords(String s) {
        // TODO
        boolean cap = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cap && Character.isLetter(c)) {
                sb.append(Character.toUpperCase(c));
                cap = false;
            } else {
                sb.append(Character.toLowerCase(c));
            }
            if (c == ' ') {
                cap = true;
            }
        }
        return sb.toString();
    }

    // =====================================================================
    // 9. Longest Common Prefix
    // Return the longest prefix every string shares, or "" if none.
    // ["flower","flow","flight"] -> "fl"
    // ["dog","racecar","car"] -> ""
    //
    // Hint 1: Start by assuming the whole first string is the prefix.
    // Hint 2: For each other string, while !str.startsWith(prefix),
    // chop the last character off prefix.
    // Hint 3: If prefix becomes empty, return "" right away.
    // =====================================================================
    public static String longestCommonPrefix(String[] strs) {
        // TODO
        return "";
    }

    // =====================================================================
    // 10. String Compression
    // Replace each run of a repeated character with the character followed
    // by its count. If the result isn't shorter, return the original.
    // "aabcccccaaa" -> "a2b1c5a3"
    // "abc" -> "abc"
    //
    // Hint 1: Keep a count that starts at 1.
    // Hint 2: Compare charAt(i) with charAt(i + 1). Same? count++.
    // Different (or end of string)? Append the char and count, reset to 1.
    // Hint 3: At the end, compare result.length() with s.length().
    // =====================================================================
    public static String compress(String s) {
        // TODO
        return "";
    }

    // =====================================================================
    // BONUS 1. Is Subsequence
    // Return true if s appears inside t in order (skipping chars is allowed).
    // "abc", "ahbgdc" -> true
    // "axc", "ahbgdc" -> false
    //
    // Hint 1: Use one pointer for s and one for t.
    // Hint 2: Always move the t pointer. Move the s pointer only on a match.
    // Hint 3: If the s pointer reaches s.length(), every char was found.
    // =====================================================================
    public static boolean isSubsequence(String s, String t) {
        // TODO
        return false;
    }

    // =====================================================================
    // BONUS 2. Count Words
    // Count the words in a sentence that may have extra spaces.
    // " Hello, my name is John " -> 5
    // " " -> 0
    //
    // Hint 1: trim() + split("\\s+") gets you most of the way.
    // Hint 2: Careful: "".split("\\s+") returns an array of length 1, not 0.
    // Hint 3: Check if the trimmed string is empty before splitting.
    // =====================================================================
    public static int countWords(String s) {
        // TODO
        return 0;
    }

    // =====================================================================
    // BONUS 3. Remove Duplicate Characters
    // Keep only the first time each character appears.
    // "programming" -> "progamin"
    // "aabbcc" -> "abc"
    //
    // Hint 1: You need to remember which characters you've already seen.
    // Hint 2: A boolean[256] array or a HashSet<Character> works.
    // Hint 3: Only append a char to the StringBuilder the first time you see it.
    // =====================================================================
    public static String removeDuplicates(String s) {
        // TODO
        return "";
    }

    // =====================================================================
    // TESTS: don't change below this line. Run the file to check your work.
    // =====================================================================
    private static int passed = 0;
    private static int total = 0;

    private static void check(String name, Object actual, Object expected) {
        total++;
        if (expected.equals(actual)) {
            passed++;
            System.out.println("PASS  " + name);
        } else {
            System.out.println("FAIL  " + name + "  expected: " + expected + "  got: " + actual);
        }
    }

    public static void main(String[] args) {
        check("1. reverse(\"hello\")", reverse("hello"), "olleh");
        check("1. reverse(\"Revature\")", reverse("Revature"), "erutaveR");

        check("2. countVowels(\"Programming\")", countVowels("Programming"), 3);
        check("2. countVowels(\"AEIOU xyz\")", countVowels("AEIOU xyz"), 5);

        check("3. isPalindrome(Panama)", isPalindrome("A man, a plan, a canal: Panama"), true);
        check("3. isPalindrome(\"race a car\")", isPalindrome("race a car"), false);

        check("4. lengthOfLastWord(\"Hello World\")", lengthOfLastWord("Hello World"), 5);
        check("4. lengthOfLastWord(moon)", lengthOfLastWord("   fly me   to   the moon  "), 4);

        check("5. isAnagram(anagram, nagaram)", isAnagram("anagram", "nagaram"), true);
        check("5. isAnagram(rat, car)", isAnagram("rat", "car"), false);

        check("6. firstUniqChar(\"leetcode\")", firstUniqChar("leetcode"), 0);
        check("6. firstUniqChar(\"loveleetcode\")", firstUniqChar("loveleetcode"), 2);
        check("6. firstUniqChar(\"aabb\")", firstUniqChar("aabb"), -1);

        check("7. reverseWords(\"the sky is blue\")", reverseWords("the sky is blue"), "blue is sky the");
        check("7. reverseWords(\"  hello   world  \")", reverseWords("  hello   world  "), "world hello");

        check("8. capitalizeWords", capitalizeWords("hello wORLD from java"), "Hello World From Java");

        check("9. longestCommonPrefix(flower...)",
                longestCommonPrefix(new String[] { "flower", "flow", "flight" }), "fl");
        check("9. longestCommonPrefix(dog...)",
                longestCommonPrefix(new String[] { "dog", "racecar", "car" }), "");

        check("10. compress(\"aabcccccaaa\")", compress("aabcccccaaa"), "a2b1c5a3");
        check("10. compress(\"abc\")", compress("abc"), "abc");

        check("B1. isSubsequence(abc, ahbgdc)", isSubsequence("abc", "ahbgdc"), true);
        check("B1. isSubsequence(axc, ahbgdc)", isSubsequence("axc", "ahbgdc"), false);

        check("B2. countWords(John)", countWords("  Hello,   my name is  John "), 5);
        check("B2. countWords(\"   \")", countWords("   "), 0);

        check("B3. removeDuplicates(\"programming\")", removeDuplicates("programming"), "progamin");
        check("B3. removeDuplicates(\"aabbcc\")", removeDuplicates("aabbcc"), "abc");

        System.out.println();
        System.out.println(passed + " / " + total + " tests passed");
    }
}