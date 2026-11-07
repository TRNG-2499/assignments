import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a4_solution{
    public void solution(String password){
        if(password == null){ // check null first and foremost
            System.out.println("Password can not be null.");
            return;
        }

        int rulesPassed = 0;
        String strength;
        String lengthPassed = "Fail";
        String numberPassed = "Fail";
        String capitalPassed = "Fail";
        String specialPassed = "Fail";

        if(password.length()>=8){ // checks at least 8 characters
            rulesPassed++;
            lengthPassed = "Pass";
        }
        Pattern numP = Pattern.compile("\\d+");
        Matcher mP = numP.matcher(password);
        if(mP.find()){ // checks for any numbers
            rulesPassed++;
            numberPassed = "Pass";
        }
        Pattern capP = Pattern.compile("[A-Z]+");
        Matcher mC = capP.matcher(password);
        if(mC.find()){ // checks for any capital letters
            rulesPassed++;
            capitalPassed = "Pass";
        }
        Pattern specP = Pattern.compile("[^a-zA-Z0-9]");
        Matcher mS = specP.matcher(password);
        if(mS.find()){ // checks for any special characters
            rulesPassed++;
            specialPassed = "Pass";
        }
        switch (rulesPassed){
            case 0:
                strength = "Weak";
                break;
            case 1:
                strength = "Weak";
                break;
            case 2:
                strength = "Medium";
                break;
            case 3:
                strength = "Medium";
                break;
            case 4:
                strength = "Strong";
                break;
            default:
                strength = "Weak";
                break;
        }
        System.out.println("Length: " + lengthPassed + " | Digit: " +  numberPassed + " | Uppercase: " +
                capitalPassed + " | Special Character:  " + specialPassed + " -- Strength: " + strength);
    }
    public void customRule(String password){
        if(password == null){ // check null first and foremost
            System.out.println("Password can not be null.");
            return;
        }

        int rulesPassed = 0;
        String strength;
        String lengthPassed = "Fail";
        String numberPassed = "Fail";
        String capitalPassed = "Fail";
        String specialPassed = "Fail";

        if(password.length()>=8){ // checks at least 8 characters
            rulesPassed++;
            lengthPassed = "Pass";
        }
        Pattern numP = Pattern.compile("\\d+");
        Matcher mP = numP.matcher(password);
        if(mP.find()){ // checks for any numbers
            rulesPassed++;
            numberPassed = "Pass";
        }
        Pattern capP = Pattern.compile("[A-Z]+");
        Matcher mC = capP.matcher(password);
        if(mC.find()){ // checks for any capital letters
            rulesPassed++;
            capitalPassed = "Pass";
        }
        Pattern specP = Pattern.compile("[^a-zA-Z0-9]");
        Matcher mS = specP.matcher(password);
        if(mS.find()){ // checks for any special characters
            rulesPassed+=2;
            specialPassed = "Pass";
        }
        switch (rulesPassed){
            case 0:
                strength = "Weak";
                break;
            case 1:
                strength = "Weak";
                break;
            case 2:
                strength = "Weak";
                break;
            case 3:
                strength = "Medium";
                break;
            case 4:
                strength = "Medium";
                break;
            case 5:
                strength = "Strong";
                break;
            default:
                strength = "Weak";
                break;
        }
        System.out.println("Length: " + lengthPassed + " | Digit: " +  numberPassed + " | Uppercase: " +
                capitalPassed + " | Special Character:  " + specialPassed + " -- Strength: " + strength);
    }
    public void blacklist(String password){
        if(password == null){ // check null first and foremost
            System.out.println("Password can not be null.");
            return;
        }

        String[] blacklisted = {"password","123456","qwerty123","abcdefgh","Admin@123","iloveyou123"};

        int rulesPassed = 0;
        String strength;
        String lengthPassed = "Fail";
        String numberPassed = "Fail";
        String capitalPassed = "Fail";
        String specialPassed = "Fail";

        if(password.length()>=8){ // checks at least 8 characters
            rulesPassed++;
            lengthPassed = "Pass";
        }
        Pattern numP = Pattern.compile("\\d+");
        Matcher mP = numP.matcher(password);
        if(mP.find()){ // checks for any numbers
            rulesPassed++;
            numberPassed = "Pass";
        }
        Pattern capP = Pattern.compile("[A-Z]+");
        Matcher mC = capP.matcher(password);
        if(mC.find()){ // checks for any capital letters
            rulesPassed++;
            capitalPassed = "Pass";
        }
        Pattern specP = Pattern.compile("[^a-zA-Z0-9]");
        Matcher mS = specP.matcher(password);
        if(mS.find()){ // checks for any special characters
            rulesPassed++;
            specialPassed = "Pass";
        }
        switch (rulesPassed){
            case 0:
                strength = "Weak";
                break;
            case 1:
                strength = "Weak";
                break;
            case 2:
                strength = "Medium";
                break;
            case 3:
                strength = "Medium";
                break;
            case 4:
                strength = "Strong";
                break;
            default:
                strength = "Weak";
                break;
        }
        for(String s : blacklisted){
            if(s.equals(password)){
                strength = "Weak";
            }
        }
        System.out.println("Length: " + lengthPassed + " | Digit: " +  numberPassed + " | Uppercase: " +
                capitalPassed + " | Special Character:  " + specialPassed + " -- Strength: " + strength);
    }

    public static void main(String[] args){
        a4_solution s = new a4_solution();
        s.solution("12345");
        s.solution("abcde#");
        s.solution("A1bcdefghi");
        s.solution("A1@D3F5T$");
        s.solution("");
        s.solution(null);
        System.out.println("----------- Stretch Goals ----------");
        s.customRule("abcde#");
        s.customRule("A1bcdefghi");
        s.customRule("A1@D3F5T$");
        s.blacklist("12345");
        s.blacklist("A1bcdefghi");
        s.blacklist("A1@D3F5T$");
        s.blacklist("Admin@123");
    }
}