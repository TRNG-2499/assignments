package java_assignment_04;

import java.util.Scanner;

public class JA04 {
    
    public static void checker(String password){
        String label = new String();
        int score = 0;
        
        // Check null/empty (return)
        if (password == null || password.length() == 0){
            System.out.println("Input password empty.");
            return;
        }

        // Check length
        String lenResult = new String();
        if (password.length() >= 8){
            ++score;
            lenResult = "Pass";
        } else {
            lenResult = "Fail";
        }

        // Check digit count
        String digResult = "Fail";
        for (int i = 0; i < password.length(); i++){
            if(Character.isDigit(password.charAt(i))){
                ++score;
                digResult = "Pass";
                break;
            }
        }

        // Check upper count
        String upResult = "Fail";
        for (int i = 0; i < password.length(); i++){
            if(Character.isUpperCase(password.charAt(i))){
                ++score;
                upResult = "Pass";
                break;
            }
        }     
        // Check special char count
        String specResult = "Fail"; 
        if (password.matches(".*[!@#$%^&*].*")){
            ++score;
            specResult = "Pass";
        }

        // Calc label
        String strength = new String();
        if (score > 0 && score <= 1){
            strength = "Weak";
        } else if (score > 1 && score <= 3){
            strength = "Medium";
        } else if (score > 3){
            strength = "Strong";
        }

        // Report
        System.out.printf("Length: %s | Digit: %s | Uppercase: %s | Special Character: %s -- Strength: %s", lenResult, digResult, upResult, specResult, strength);

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        scanner.close();
        checker(password);
    }
}
