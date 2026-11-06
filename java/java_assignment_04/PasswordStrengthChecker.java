import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PasswordStrengthChecker {

    private static final String SPECIALS = "!@#$%^&*";

    // Stretch goal 2:
    private static final List<String> COMMON_PASSWORDS = Arrays.asList("password", "12345678", "qwerty", "password123", "admin", "welcome");

    public static void main(String[] args) {
        System.out.println("Password Strength Checker");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a password: ");
            String password = scanner.nextLine();

            System.out.println();
            System.out.println("Basic:     " + checkPassword(password));
            System.out.println("Weighted:  " + checkPasswordWeighted(password));
            System.out.println("Blacklist: " + checkPasswordBlacklist(password));
        }
    }

    // Base requirement
    public static String checkPassword(String password) {
        boolean[] rules = evaluateRules(password);
        int passed = countPassed(rules);

        String strength;
        if (passed == 4) {
            strength = "Strong";
        } else if (passed >= 2) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }
        return describe(rules) + " -- Strength: " + strength;
    }

    // Stretch goal 1 (length 1, digit 1, uppercase 1, special 2)
    public static String checkPasswordWeighted(String password) {
        boolean[] rules = evaluateRules(password);
        int[] points = {1, 1, 1, 2};   // total possible = 5

        int earned = 0;
        for (int i = 0; i < rules.length; i++) {
            if (rules[i]) earned += points[i];
        }

        String strength;
        if (earned == 5) {
            strength = "Strong";
        } else if (earned >= 3) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }
        return describe(rules) + " -- Points: " + earned + "/5 -- Strength: " + strength;
    }

    // Stretch goal 2
    public static String checkPasswordBlacklist(String password) {
        if (password != null && COMMON_PASSWORDS.contains(password.toLowerCase())) {
            return describe(evaluateRules(password))
                    + " -- Common password -- Strength: Weak";
        }
        return checkPassword(password);
    }

    private static boolean[] evaluateRules(String password) {
        boolean[] rules = new boolean[4];
        if (password == null) {
            return rules;
        }
        rules[0] = password.length() >= 8;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) rules[1] = true;
            if (Character.isUpperCase(c)) rules[2] = true;
            if (SPECIALS.indexOf(c) >= 0) rules[3] = true;
        }
        return rules;
    }

    private static int countPassed(boolean[] rules) {
        int count = 0;
        for (boolean r : rules) {
            if (r) count++;
        }
        return count;
    }

    private static String describe(boolean[] rules) {
        return "Length: " + label(rules[0])
                + " | Digit: " + label(rules[1])
                + " | Uppercase: " + label(rules[2])
                + " | Special Character: " + label(rules[3]);
    }

    private static String label(boolean passed) {
        return passed ? "Pass" : "Fail";
    }
}