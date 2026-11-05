package javaAssignments.java_assignment_04;

import java.util.ArrayList;
import java.util.List;

public class password_strength_checker_assignent {
    
    public static void main(String[] args) {
        // System.out.println(strengthCheck("Password123!"));
        // System.out.println(strengthCheck("password"));
        // System.out.println(strengthCheck("PASSWORD"));
        // System.out.println(strengthCheck("Passw0rd"));
        // System.out.println(strengthCheck("P@ssw0rd"));
        // System.out.println(strengthCheck(""));
        // System.out.println(strengthCheckWeighted("Password123!"));
        // System.out.println(strengthCheckWeighted("password"));
        // System.out.println(strengthCheckWeighted("PASSWORD"));
        // System.out.println(strengthCheckWeighted("Passw0rd"));
        // System.out.println(strengthCheckWeighted("P@ssw0rd"));
        // System.out.println(strengthCheckWeighted("L4short"));
        // System.out.println(checkToBlacklist("123456"));
        // System.out.println(checkToBlacklist("password"));
        // System.out.println(checkToBlacklist("123456789"));
        // System.out.println(checkToBlacklist("jklasdfow;lknzxjkclnvpaouihe"));
    }
    //this lets me use this one piece of logic for both strengthCheck and the stretch goals of the assignment. No reason to write it twice!
    public static String strengthReturn(int score) {
        if (score == 8) {
            return "Strong";
        } else if (score <= 7 && score > 2) {
            return "Medium";
        } else {
            return "Weak";
        }
    }

    public static String strengthCheck(String password) {

        //our criteria are the following:
        //1. The password must be at least 8 characters long.
        //2. The password must contain at least one uppercase letter.
        //3. The password must contain at least one digit.
        //4. The password must contain at least one special character.

        //We will compare input string to the above criteria and return the strength of the password. 
        //To cheat a little I will assign each of these criteria a score of 2 and create an unrelated method that returns a string for strength based on the score.
        int score = 0;
        List<String> passcriteria = new ArrayList<>(); //I will use this to store the criteria that the password passes, and return it in the final string.
        List<String> failcriteria = new ArrayList<>();
        if (password.length() >= 8) {
            score += 2;
            passcriteria.add("length");
        }
        else{
            failcriteria.add("length");
        }
        if (password.matches(".*[A-Z].*")) {
            score += 2;
            passcriteria.add("uppercase");
        }
        else{
            failcriteria.add("uppercase");
        }
        if (password.matches(".*[0-9].*")) {
            score += 2;
            passcriteria.add("digit");
        }
        else{
            failcriteria.add("digit");
        }
        if (password.matches(".*[^A-Za-z0-9].*")) { //Cheated a bit on this one, found a tool to search for any non alphanumeric ASCII character.
            score += 2;
            passcriteria.add("special character");
            }
        else{
            failcriteria.add("special character");
        }

        return "Passing criteria: " + passcriteria.toString() + " - Failing criteria: " + failcriteria.toString() + " - " + strengthReturn(score);
    }


    //This one applies custom weights to the criteria, and returns a strength based on the total score.
    public static String strengthCheckWeighted(String password) {

        //We will compare input string to the above criteria and return the strength of the password. 
        int score = 0;
        List<String> passcriteria = new ArrayList<>(); //I will use this to store the criteria that the password passes, and return it in the final string.
        List<String> failcriteria = new ArrayList<>();
        if (password.length() >= 8) {
            score += 3;
            passcriteria.add("length");
        }
        else{
            failcriteria.add("length");
        }
        if (password.matches(".*[A-Z].*")) {
            score += 1;
            passcriteria.add("uppercase");
        }
        else{
            failcriteria.add("uppercase");
        }
        if (password.matches(".*[0-9].*")) {
            score += 1;
            passcriteria.add("digit");
        }
        else{
            failcriteria.add("digit");
        }
        if (password.matches(".*[^A-Za-z0-9].*")) { //Cheated a bit on this one, found a tool to search for any non alphanumeric ASCII character.
            score += 3;
            passcriteria.add("special character");
            }
        else{
            failcriteria.add("special character");
        }

        return "Passing criteria: " + passcriteria.toString() + " - Failing criteria: " + failcriteria.toString() + " - " + strengthReturn(score);
    }

    public static Boolean checkToBlacklist(String password){
        //I have found a compelling candidate for most interesting wikipedia article of my month!
        //https://en.wikipedia.org/wiki/List_of_the_most_common_passwords
        //Behold the most common passowords, this method will check against this as a blacklist
        if (password.equals("123456")
            || password.equals("password")
            || password.equals("123456789")
            || password.equals("12345678")
            || password.equals("12345")
            || password.equals("111111")
            || password.equals("1234567")
            || password.equals("sunshine")
            || password.equals("qwerty")
            || password.equals("iloveyou")
            || password.equals("princess")
            || password.equals("admin")
            || password.equals("Aa123456")
            || password.equals("1234567890")
            || password.equals("Pass@123")
            || password.equals("admin123")
            || password.equals("1234567")
            || password.equals("P@ssw0rd")
            || password.equals("Aa@123456")
            || password.equals("admintelecom")
            || password.equals("Admin@123" ) //Obviously there are more that could be had on this list but I will stop here for now, this is a good enough sample to demonstrate the concept.
            ){
                return true;
        }
        else{
            return false;
        }
    }
}
