import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        PasswordChecker test = new PasswordChecker();

        System.out.println(test.checkPassword("password"));
        System.out.println(test.checkPassword("Password1"));
        System.out.println(test.checkPassword("P@ssw0rd"));
        System.out.println(test.checkPassword(""));

        System.out.println(test.checkPasswordCustomRule("P@ssw0rd"));
        System.out.println(test.checkPasswordCustomRule("Passw0rd"));
        System.out.println(test.checkPasswordCustomRule("Passw0rd"));

        System.out.println(test.checkPasswordBlacklist("password"));
    }
}

class PasswordChecker {

    /**
     * Checks the strength of a given password.
     * @param password The password to check.
     * @return A string describing the password's strength and individual criteria.
     */
    public String checkPassword(String password) {
        boolean lengthStatus = true;
        if (password == null || password.length() < 8) lengthStatus = false;

        boolean digitStatus = false;
        boolean upperStatus = false;
        boolean specialStatus = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) digitStatus = true;
            if (Character.isUpperCase(c)) upperStatus = true;
            if (!Character.isLetterOrDigit(c)) specialStatus = true;

            if (digitStatus && upperStatus && specialStatus) break;
        }

        StringBuilder result = new StringBuilder();
        result.append("Length: ").append(lengthStatus ? "Pass" : "Fail").append(" | ");
        result.append("Digit: ").append(digitStatus ? "Pass" : "Fail").append(" | ");
        result.append("Uppercase: ").append(upperStatus ? "Pass" : "Fail").append(" | ");
        result.append("Special Character: ").append(specialStatus ? "Pass" : "Fail").append("\n-- Strength: ");
        
        int totalPassed = (lengthStatus ? 1 : 0) + (digitStatus ? 1 : 0) + (upperStatus ? 1 : 0) + (specialStatus ? 1 : 0);
        if (totalPassed == 4) {
            result.append("Strong");
        } else if (totalPassed >= 2) {
            result.append("Medium");
        } else {
            result.append("Weak");
        }

        return result.toString();
    }

    /**
     * Checks the strength of a given password.
     * @param password The password to check.
     * @return A string describing the password's strength and individual criteria.
     */
    public String checkPasswordCustomRule(String password) {
        boolean lengthStatus = true;
        if (password == null || password.length() < 8) lengthStatus = false;

        boolean digitStatus = false;
        boolean upperStatus = false;
        boolean specialStatus = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) digitStatus = true;
            if (Character.isUpperCase(c)) upperStatus = true;
            if (!Character.isLetterOrDigit(c)) specialStatus = true;

            if (digitStatus && upperStatus && specialStatus) break;
        }

        StringBuilder result = new StringBuilder();
        result.append("Length: ").append(lengthStatus ? "Pass" : "Fail").append(" | ");
        result.append("Digit: ").append(digitStatus ? "Pass" : "Fail").append(" | ");
        result.append("Uppercase: ").append(upperStatus ? "Pass" : "Fail").append(" | ");
        result.append("Special Character: ").append(specialStatus ? "Pass" : "Fail").append("\n-- Strength: ");
        
        int totalPassed = (lengthStatus ? 1 : 0) + (digitStatus ? 2 : 0) + (upperStatus ? 2 : 0) + (specialStatus ? 3 : 0);
        if (totalPassed == 8) {
            result.append("Strong");
        } else if (totalPassed >= 5) {
            result.append("Medium");
        } else {
            result.append("Weak");
        }

        return result.toString();
    }

    /**
     * Checks the strength of a given password.
     * @param password The password to check.
     * @return A string describing the password's strength and individual criteria.
     */
    public String checkPasswordBlacklist(String password) {
        Set<String> blacklist = new HashSet<>(Arrays.asList("password", "12345678", "qwertyui", "strongpassword", "password123"));
        if (blacklist.contains(password)) {
            return "Weak password";
        }

        boolean lengthStatus = true;
        if (password == null || password.length() < 8) lengthStatus = false;

        boolean digitStatus = false;
        boolean upperStatus = false;
        boolean specialStatus = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) digitStatus = true;
            if (Character.isUpperCase(c)) upperStatus = true;
            if (!Character.isLetterOrDigit(c)) specialStatus = true;

            if (digitStatus && upperStatus && specialStatus) break;
        }

        StringBuilder result = new StringBuilder();
        result.append("Length: ").append(lengthStatus ? "Pass" : "Fail").append(" | ");
        result.append("Digit: ").append(digitStatus ? "Pass" : "Fail").append(" | ");
        result.append("Uppercase: ").append(upperStatus ? "Pass" : "Fail").append(" | ");
        result.append("Special Character: ").append(specialStatus ? "Pass" : "Fail").append("\n-- Strength: ");
        
        int totalPassed = (lengthStatus ? 1 : 0) + (digitStatus ? 1 : 0) + (upperStatus ? 1 : 0) + (specialStatus ? 1 : 0);
        if (totalPassed == 4) {
            result.append("Strong");
        } else if (totalPassed >= 2) {
            result.append("Medium");
        } else {
            result.append("Weak");
        }

        return result.toString();
    }
}