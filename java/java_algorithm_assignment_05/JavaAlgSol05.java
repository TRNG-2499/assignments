package assignments.java.java_algorithm_assignment_05;

import java.util.ArrayList;
import java.util.Map;

public class JavaAlgSol05 {

    private static Map<Character, Character> pairs = Map.of(
            '(', ')',
            '{', '}',
            '[', ']',
            '<', '>');
    private static ArrayList<Character> bracketList = new ArrayList<>();

    private static boolean validParentheses(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        bracketList.clear();
        for (char currentChar : input.toCharArray()) {
            if (pairs.containsKey(currentChar)) {
                openingBracket(currentChar);
            } else {
                if (!closingBracket(currentChar)) {
                    return false;
                }
            }
        }
        return bracketList.isEmpty();
    }

    private static void openingBracket(char currentChar) {
        bracketList.add(currentChar);
    }

    private static boolean closingBracket(char currentChar) {
        if (bracketList.isEmpty()) {
            return false;
        }

        int lastIndex = bracketList.size() - 1;
        char lastOpen = bracketList.get(lastIndex);

        if (pairs.get(lastOpen) != currentChar) {
            return false;
        }
        bracketList.remove(lastIndex);
        return true;
    }

    // Stretch valid return list FAILED, will think about it more when my brain is
    // working better.
    private static ArrayList<Integer> invalidBracketIndexes(String input) {
        ArrayList<Integer> openings = new ArrayList<>();
        ArrayList<Integer> invalid = new ArrayList<>();

        if (input == null || input.isEmpty())
            return invalid;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (pairs.containsKey(currentChar)) {
                openings.add(i);
            } else {
                if (openings.isEmpty()) {
                    invalid.add(i);
                    continue;
                }

            }
        }
        return invalid;
    }
}
