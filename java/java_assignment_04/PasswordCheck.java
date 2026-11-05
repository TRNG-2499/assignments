public class PasswordCheck {
    public static void main(String[] args) {
        blacklistCheck("password");
        blacklistCheck("Password1");
        blacklistCheck("P@ssw0rd");
        blacklistCheck("");
        blacklistCheck(null);
        
    }

    public static void strengthCheck(String password) {
        if (password == null || password.length() == 0) {
            System.out.println("Empty/Null password -- Strength: Weak");
            return;
        }
        int lenCheck = 0;
        int digitCheck = 0;
        int caseCheck = 0;
        int spCharCheck = 0;
        String specialChars = "!@#$%^&*";
        
        if (password.length() >= 8 ) lenCheck = 1;
        if (password.chars().anyMatch(c -> specialChars.indexOf(c) >= 0)) spCharCheck = 1;
        if (password.chars().anyMatch(Character::isDigit)) digitCheck = 1;
        if (password.chars().anyMatch(Character::isUpperCase)) caseCheck = 1;

        printResults(lenCheck, digitCheck, caseCheck, spCharCheck, 0);

    }

    public static void weightedCheck(String password) {
        if (password == null || password.length() == 0) {
            System.out.println("Empty/Null password -- Strength: Weak");
            return;
        }

        int lenCheck = 0;
        int digitCheck = 0;
        int caseCheck = 0;
        int spCharCheck = 0;
        String specialChars = "!@#$%^&*";

        int lenWeight = 1;
        int digitWeight = 2;
        int caseWeight = 3;
        int spCharWeight = 4;

        if (password.length() >= 8 ) lenCheck = lenWeight;
        if (password.chars().anyMatch(c -> specialChars.indexOf(c) >= 0)) spCharCheck = spCharWeight;
        if (password.chars().anyMatch(Character::isDigit)) digitCheck = digitWeight;
        if (password.chars().anyMatch(Character::isUpperCase)) caseCheck = caseWeight;



        printResults(lenCheck, digitCheck, caseCheck, spCharCheck, 1,
        lenWeight + digitWeight + caseWeight + spCharWeight);

    }

    public static void blacklistCheck(String password) {
        String[] blacklist = {"password", "password1", "password123", "123456", "qwerty", "admin"};

        for (String p : blacklist) {
            if (p.equalsIgnoreCase(password)) {
            System.out.println("Generic password -- Strength: Weak");
            return;
            }
        }

        strengthCheck(password);
    }

    public static void printResults(int lenCheck, int digitCheck, int caseCheck, int spCharCheck, int... mode) {
        String strength;
        switch (mode[0]) {
            case 0 -> {
                switch (lenCheck + digitCheck + caseCheck + spCharCheck) {
                    case 0, 1 -> strength = "Weak";
                    case 2, 3 -> strength = "Medium";
                    case 4 -> strength = "Strong";
                    default -> {return;}
                }
                
            }
            case 1 -> {
                double strengthScore = lenCheck + digitCheck + caseCheck + spCharCheck;
                double maxScore = mode[1];
                strength = strengthScore >= 0.8*maxScore ? "Strong" : strengthScore < 0.4*maxScore ? "Weak" : "Medium";
            }
            default -> {return;}
        }
        String s = String.format("Length: %s | Digit: %s | Uppercase: %s | Special Character: %s -- Strength: %s", (lenCheck > 0 ? "Pass" : "Fail"),
                (digitCheck > 0 ? "Pass" : "Fail"),(caseCheck > 0 ? "Pass" : "Fail"),(spCharCheck > 0 ? "Pass" : "Fail"), strength);
        System.out.println(s);
    }
}