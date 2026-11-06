public class Solution_04 {

    public static void main(String[] args) {
        // Test for Req.
        String[] testCases = {"password", "Password1", "P@ssw0rd", ""};
        System.out.println("--- Standard Requirement Tests ---");
        for (String input : testCases) {
            System.out.println("Input: \"" + input + "\" -> " + checkPassword(input));
        }

        System.out.println("\n--- Stretch Goal 1: Weighted Results ---");
        for (String input : testCases) {
            System.out.println("Input: \"" + input + "\" -> " + checkWeightedPassword(input));
        }

        System.out.println("\n--- Stretch Goal 2: Blacklist Results ---");
        String[] blacklistTests = {"password", "123456", "P@ssw0rd", "qwerty"};
        for (String input : blacklistTests) {
            System.out.println("Input: \"" + input + "\" -> " + checkWithBlacklist(input));
        }

    }
    
    public static String checkPassword(String password) {
        boolean lengthPass = false;
        boolean digitPass = false;
        boolean upperPass = false;
        boolean specialPass = false;

        if (password != null && !password.isEmpty()) {
            if (password.length() >= 8) 
                lengthPass = true;

            for (char c : password.toCharArray()) {
                if (Character.isDigit(c))
                    digitPass = true;
                else if (Character.isUpperCase(c))
                    upperPass = true;
                else if ("!@#$%^&*".indexOf(c) != -1)
                    specialPass = true;
            }
        }

        int count = 0;
        if (lengthPass) count++;
        if (digitPass) count++;
        if (upperPass) count++;
        if (specialPass) count++;

        String strength;
        if (count == 4) {
            strength = "Strong";
        }
        else if (count >= 2) {
            strength = "Medium";
        }
        else {
            strength = "Weak";
        }

        return  String.format("Length: %s | Digit: %s | Uppercase: %s | Special Character: %s -- Strength: %s",
            lengthPass ? "Pass" : "Fail",
            digitPass ? "Pass" : "Fail",
            upperPass ? "Pass" : "Fail",
            specialPass ? "Pass" : "Fail",
            strength);
    }

    // Stretch Goal 1 
    public static String checkWeightedPassword(String password) {
        int points = 0;
        boolean lengthPass = false;
        boolean digitPass = false;
        boolean upperPass = false;
        boolean specialPass = false;

        if (password != null &&  !password.isEmpty()) {
            if (password.length() >= 8) 
                lengthPass = true;
            for (char c : password.toCharArray()) {
                if (Character.isDigit(c)) 
                    digitPass = true;
                else if (Character.isUpperCase(c)) 
                    upperPass = true;
                else if ("!@#$%^&*".indexOf(c) != -1) 
                    specialPass = true;
            }
        }

        if (lengthPass) 
            points += 1;
        if (digitPass)
            points += 1;
        if (upperPass)
            points += 1;
        if (specialPass)
            points += 2;

        String strength;
        if (points == 5) {
            strength = "Strong";
        }
        else if (points >= 3) {
            strength = "Medium";
        }
        else {
            strength = "Weak";
        }

        return String.format("Weighted Points: %d/5 | Length: %s | Digit: %s | Uppercase: %s | Special: %s -- Strength: %s", 
        points, 
        lengthPass ? "Pass" : "Fail",
        digitPass ? "Pass" : "Fail",
        upperPass ? "Pass" : "Fail",
        specialPass ? "Pass" : "Fail",
        strength);
    }

    // Stretch Goal 2
    public static String checkWithBlacklist(String password) {
        String[] blacklist = {"password", "123456", "qwerty", "admin123", "welcome"};

        if (password == null)
            return "Input is Null -- Strength: Weak";

        for (String weak : blacklist) {
            if (password.equalsIgnoreCase(weak)) {
                return "Blacklisted Match (" + weak + ") -- Strength: Weak";
            }
        }

        return checkPassword(password);
    }
}
