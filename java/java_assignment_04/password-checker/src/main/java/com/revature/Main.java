package com.revature;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // nextLine so an empty password and passwords with spaces are read as typed
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        System.out.println(passwordStrength(password));

        System.out.println();
        System.out.println("-----Stretch Goal 1-----");
        // stretch goal 1
        System.out.println(weightedPasswordStrength(password));

        System.out.println();
        System.out.println("-----Stretch Goal 2-----");
        // stretch goal 2
        System.out.println(blacklistPasswordStrength(password));

        scanner.close();
    }

    // normal solution
    public static String passwordStrength(String password) {
        boolean[] rules = checkRules(password);

        int passed = 0;
        for (boolean rule : rules) {
            if (rule) {
                passed++;
            }
        }

        String strength;
        if (passed == 4) {
            strength = "Strong";
        } else if (passed >= 2) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }
        return formatResults(rules) + " -- Strength: " + strength;
    }

    // returns {length, digit, uppercase, special} so every method checks the rules the same way
    public static boolean[] checkRules(String password) {
        // a null password has no characters, so it is treated the same as an empty one
        if (password == null) {
            password = "";
        }

        boolean hasDigit = false;
        boolean hasUppercase = false;
        boolean hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (c >= '0' && c <= '9') {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if ("!@#$%^&*".indexOf(c) >= 0) {
                hasSpecial = true;
            }
        }
        return new boolean[] { password.length() >= 8, hasDigit, hasUppercase, hasSpecial };
    }

    public static String formatResults(boolean[] rules) {
        String[] names = { "Length", "Digit", "Uppercase", "Special Character" };

        String output = "";
        for (int i = 0; i < rules.length; i++) {
            if (i > 0) {
                output += " | ";
            }
            output += names[i] + ": " + (rules[i] ? "Pass" : "Fail");
        }
        return output;
    }

    // stretch goal 1
    public static String weightedPasswordStrength(String password) {
        boolean[] rules = checkRules(password);
        // length, digit, uppercase, special; special counts double, so 5 points total
        int[] points = { 1, 1, 1, 2 };

        int earned = 0;
        int possible = 0;
        for (int i = 0; i < rules.length; i++) {
            possible += points[i];
            if (rules[i]) {
                earned += points[i];
            }
        }

        // all 5 points = strong, 3-4 = medium, 0-2 = weak
        String strength;
        if (earned == possible) {
            strength = "Strong";
        } else if (earned >= 3) {
            strength = "Medium";
        } else {
            strength = "Weak";
        }
        return formatResults(rules) + " -- Points: " + earned + "/" + possible + " -- Strength: " + strength;
    }

    // stretch goal 2
    public static String blacklistPasswordStrength(String password) {
        String[] commonPasswords = { "password", "123456", "12345678", "qwerty", "letmein", "admin", "welcome", "password1" };

        for (String common : commonPasswords) {
            if (common.equalsIgnoreCase(password)) {
                return formatResults(checkRules(password)) + " -- Strength: Weak (common password)";
            }
        }
        return passwordStrength(password);
    }
}
