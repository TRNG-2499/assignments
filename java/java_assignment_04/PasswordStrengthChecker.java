public class PasswordStrengthChecker {
    public static void main(String[] args) {
        passwordStrength("mypaSSword3#");
    }
    public static void passwordStrength(String password){
        String specialChars = "!@#$%^&*";
        int checker = 4;

        if(password == null || password.isEmpty()) {
            System.out.println("Password is empty");
            return;
        }
        
        if(password.length() < 8){
            System.out.println("length too short, password weaker " + --checker);
        }
        if(password.chars().noneMatch(Character::isDigit)){
            System.out.println("missing digits, password weaker " + --checker);
        }if(password.chars().noneMatch(Character::isUpperCase)){
            System.out.println("missing upper case, password weaker " + --checker);
        }
        boolean hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (specialChars.indexOf(c) != -1) {
                hasSpecial = true;
                break;
            }
        }
        if(!hasSpecial){
            System.out.println("missing special character, password weaker " + --checker);
        }
        
        if(checker == 4){
            System.out.println("Strong");
        }else if (checker >= 2) {
            System.out.println("Medium");
        }else{
            System.out.println("weak");
        }
    }


}
