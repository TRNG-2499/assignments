package java_assignment_04;

import java.util.*;

public class password {
    public static void main(String[] args) {

        System.out.println("Password program is running...");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter program mode");
        System.out.println("1 for default");
        System.out.println("2 for custom weight");
        System.out.println("3 for blacklist");

        int mode = scanner.nextInt();

        if (mode < 1 || mode > 3) {
            System.out.println("Invalid program mode.");
            scanner.close();
            return;
        }

        scanner.nextLine(); // Consume the newline character left by nextInt()

        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();

        switch (mode) {
            case 1:
                DefaultMode(password);
                break;
            case 2:
                CustomWeightMode(password);
                break;
            case 3:
                BlackListMode(password);
                break;
        }
        scanner.close();

    }

    public static void DefaultMode(String password) {

        System.out.println("Default mode selected.");
        int strength = 0;

        if (password.length() < 8) {
            System.out.print(" Length: Fail |");
        } else {
            System.out.print(" Length: Pass |");
            strength += 1;
        }

        if (password.matches(".*\\d.*")) {
            System.out.print(" Digit: Pass |");
            strength += 1;
        } else {
            System.out.print(" Digit: Fail |");
        }

        if (password.matches(".*[A-Z].*")) {
            System.out.print(" Uppercase: Pass |");
            strength += 1;
        } else {
            System.out.print(" Uppercase: Fail |");
        }

        if (password.matches(".*[!@#$%^&*].*")) {
            System.out.print(" Special Char: Pass |");
            strength += 1;
        } else {
            System.out.print(" Special Char: Fail |");
        }

        // Display Strength
        if (strength <= 1) {
            System.out.print(" Strength: Weak");
        } else if (strength == 2 || strength == 3) {
            System.out.print(" Strength: Medium");
        } else if (strength == 4) {
            System.out.print(" Strength: Strong");
        }
    }

    public static void CustomWeightMode(String password) {
        System.out.println("Custom weight mode selected.");
        System.out.println("Custom weights: Length=4, Digit=1, Uppercase=1, Special Char=2");
        int strength = 0;

        if (password.length() < 8) {
            System.out.print(" Length: Fail |");
        } else {
            System.out.print(" Length: Pass |");
            strength += 4; // Custom weight for length with 4 points
        }

        if (password.matches(".*\\d.*")) {
            System.out.print(" Digit: Pass |");
            strength += 1; // Custom weight for digit with 1 point
        } else {
            System.out.print(" Digit: Fail |");
        }

        if (password.matches(".*[A-Z].*")) {
            System.out.print(" Uppercase: Pass |");
            strength += 1; // Custom weight for uppercase with 1 point
        } else {
            System.out.print(" Uppercase: Fail |");
        }

        if (password.matches(".*[!@#$%^&*].*")) {
            System.out.print(" Special Char: Pass |");
            strength += 2; // Custom weight for special character with 2 points
        } else {
            System.out.print(" Special Char: Fail |");
        }

        // Display Strength
        if (strength <= 3) {
            System.out.print(" Strength: Weak");
        } else if (strength > 3 && strength < 8) {
            System.out.print(" Strength: Medium");
        } else if (strength == 8) {
            System.out.print(" Strength: Strong");
        }
    }

    public static void BlackListMode(String password) {

        System.out.println("Blacklist mode selected.");
        System.out.println("Blacklist: 123qweasd, 123456, password, qwertyuiop, thisismypassword.");

        List<String> blacklist = Arrays.asList("123qweasd", "123456", "password", "qwertyuiop", "thisismypassword");

        if (blacklist.contains(password)) {
            System.out.println("Password is in the blacklist.");
            return;
        }

        int strength = 0;

        if (password.length() < 8) {
            System.out.print(" Length: Fail |");
        } else {
            System.out.print(" Length: Pass |");
            strength += 1;
        }

        if (password.matches(".*\\d.*")) {
            System.out.print(" Digit: Pass |");
            strength += 1;
        } else {
            System.out.print(" Digit: Fail |");
        }

        if (password.matches(".*[A-Z].*")) {
            System.out.print(" Uppercase: Pass |");
            strength += 1;
        } else {
            System.out.print(" Uppercase: Fail |");
        }

        if (password.matches(".*[!@#$%^&*].*")) {
            System.out.print(" Special Char: Pass |");
            strength += 1;
        } else {
            System.out.print(" Special Char: Fail |");
        }

        // Display Strength
        if (strength <= 1) {
            System.out.print(" Strength: Weak");
        } else if (strength == 2 || strength == 3) {
            System.out.print(" Strength: Medium");
        } else if (strength == 4) {
            System.out.print(" Strength: Strong");
        }

    }
}
