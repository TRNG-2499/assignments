package java_assignments.java_assignment_04;

public class JavaSolution_04 {
    public static void main(String[] args) {
        System.out.println(passwordChecker(""));
    }

    public static String passwordChecker(String pass){
        boolean oneDigit = false;
        boolean oneUpperCase = false;
        boolean specialChar= false;
        String specialChars = "!@#$%^&*";
        String strength = "";

        pass = pass == null ? "" : pass;

        char[] chArr=pass.toCharArray();

        boolean lengthTest = (pass.length() >= 8) ? true : false;
        int rulesPassed = lengthTest ? 1 : 0;

        for(int i = 0; i < chArr.length; i++){
            if(Character.isDigit(chArr[i]) && !oneDigit){
                oneDigit = true;
                rulesPassed++;
            } else if(Character.isUpperCase(chArr[i]) && !oneUpperCase){
                oneUpperCase = true;
                rulesPassed++;
            } else if(specialChars.indexOf(chArr[i]) != -1 && !specialChar){
                specialChar = true;
                rulesPassed++;
            }
        }

        switch(rulesPassed){
            case 0, 1:
                strength = "Weak";
                break;
            case 2, 3:
                strength = "Medium";
                break;
            case 4:
                strength = "Strong";
                break;
        }
 
        return "Length: "+(lengthTest ? "Pass" : "Fail")+" | Digit: "+(oneDigit ? "Pass" : "Fail")+
        " | Uppercase: "+(oneUpperCase ? "Pass" : "Fail")+" | Special Char: "+(specialChar ? "Pass" : "Fail")+
        " -- Strength: "+strength;

    }
}
