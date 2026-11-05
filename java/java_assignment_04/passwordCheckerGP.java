import static java.lang.Character.isUpperCase;

public class passwordCheckerGP {
    public static void main(String[] args) {
        System.out.println(checker("Hi2#hhhhhhhhhh"));
    }

    public static String checker(String mypassword) {
        int passwordStrength = 0;

        if (mypassword == null) {
            return "Password is null, strength is weak";
        }
        boolean hasLength = false;
        if (mypassword.length() > 8) {
            passwordStrength++;
            hasLength = true;
        }

        boolean hasNum = false;
        boolean hasUpp = false;
        boolean hasSpecial = false;
        String special = "!@#$%^&*";

        for(int i = 0; i < mypassword.length(); i++) {
            char currentChar = mypassword.charAt(i);
                if (Character.isUpperCase(currentChar)) {
                    hasUpp = true;
                }
                if (Character.isDigit(currentChar)) {
                    hasNum = true;
                }
                if (special.indexOf(currentChar) != -1) {
                    hasSpecial = true;
                }

        }
        if (hasNum) {
            passwordStrength++;
        }
        if (hasUpp) {
            passwordStrength++;
        }
        if (hasSpecial) {
            passwordStrength++;
        }
        String passStrengthString = "idk";
        switch (passwordStrength) {
            case 0:
                passStrengthString = "Weak";
                break;
            case 1:
                passStrengthString = "Weak";
                break;
            case 2:
                passStrengthString = "Medium";
                break;
            case 3:
                passStrengthString = "Medium";
                break;
            case 4:
                passStrengthString = "Strong";
                break;
        }
        return "Length: "+hasLength+" Digit: "+hasNum+" Uppercase: "+hasUpp+" Special: "+hasSpecial+" Strength: "+passStrengthString;
    }

}
