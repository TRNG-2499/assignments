import java.util.Scanner;

public class PasswordStrengthChecker{

    public static void main(String[] args) {
        System.out.println("Some common examples of weak passwords are: \"password\", \"123456\", \"qwerty\"");
        System.out.println("Your password must have at least 8 characters.");
        System.out.println("Your password must contain at least one digit (0-9).");
        System.out.println("Your password must contain at least one uppercase letter.");
        System.out.println("Your password must contatin at least one special character from the list \"!@#$%^&*\" .");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the strong Password : ");
        String password = scanner.nextLine();
        String result =  passwordStrengthChecker(password);
        System.out.println(result);
        scanner.close();


    }

    public static String passwordStrengthChecker (String password) {
        //Check for empty password
        if (password.length() == 0) {
            return "Password can not be empty, please enter the password!";
        }

        boolean lengthPassed = password.length() >= 8;
        boolean digitPassed = false;
        boolean uppercasePassed = false;
        boolean specialCharPassed = false;
        String specialCharacters = "!@#$%^&*";

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                digitPassed = true;
            }
            if (Character.isUpperCase(ch)) {
                uppercasePassed = true;
            }
            if (specialCharacters.indexOf(ch) > 0) {
                specialCharPassed = true;
            }

            int points = 0;
            if (lengthPassed)
                points = points + 1;
            if (digitPassed)
                points = points + 1;
            if (uppercasePassed)
                points = points + 1;
            if (specialCharPassed)
                points = points + 2;
            String strength;

            if (points == 5) {
                strength = "Strong";
            } else if (points >= 3) {
                strength = "Medium";
            } else {
                strength = "Weak";
            }
            // return "Overall score of your password is " + points + "/5" + " and \n Srength is : " + strength;


            //Let's return individual results and overall strength
            return "Length: " + (lengthPassed ? "Pass" : "Fail") +
                    " | Digit: " + (digitPassed ? "Pass" : "Fail") +
                    " | UpperCase: " + (uppercasePassed ? "Pass" : "Fail")+
                    "  | Special Character: " + (specialCharPassed ? "Pass" : "Fail") +
                    " ---------  Strength: " + strength;

        }
        return "";
    }
}