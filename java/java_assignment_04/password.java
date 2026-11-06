import java.util.Scanner;

public class password {
    

    /**
 
- Write a method that accepts a single parameter: a password `String`.
- Evaluate the password against the following four rules:
  - At least 8 characters long
  - Contains at least one digit (`0`–`9`)
  - Contains at least one uppercase letter
  - Contains at least one special character (use the set `!@#$%^&*`)
- Your method should report which of the four rules passed and which failed, clearly identifying the result of each rule individually — not just a single overall pass/fail.
- Based on how many of the four rules passed, assign an overall strength label using the following scale:
  - **4 rules passed** → Strong
  - **2–3 rules passed** → Medium
  - **0–1 rules passed** → Weak
- Your method should handle an empty string, or a `null` input, without crashing. Decide what strength label and per-rule results make sense to report in that case.
- How you check each rule (manually iterating character by character, or using built-in `String`/`Character` methods) is left up to y
 
 */

    public static void main(String args[]){
    
    Scanner myObj = new Scanner(System.in);

    String quit = "N";
    String pass = "";

    while(!(quit.equals("Y"))){

        
        System.out.println("Insert password:");
        pass = myObj.nextLine();

        System.out.println(check_password(pass));

        System.out.println("Quit? Insert Y");
        quit = myObj.nextLine();
    }

    
    }

    public static String check_password(String s){

        //8 char, 1 digit, 1 uppercase, 1 special
        //probably just switches and helpers
        
        if(s == null){
            return "Invalid input (None-null or no password). Cannot assess";
        }

        //Tests

        int passes = 0;
        
        
        if(has_length(s)){
            passes++;
        }

        if(has_capital(s)){
            passes++;
        }

        if(has_special_char(s)){
            passes++;
        }

        if(has_numbers(s)){
            passes++;
        }

        String hl = has_length(s) ? "Passed" : "Failed";
        String hc = has_capital(s) ? "Passed" : "Failed";
        String hsc = has_special_char(s) ? "Passed" : "Failed";
        String hn = has_numbers(s) ? "Passed" : "Failed";
        String strength = passes < 3 ? "Weak" :
                            passes < 4 ? "Medium" : 
                            "Strong";

        return String.format("Length: %s | Capital: %s | Special Character: %s | Numbers: %s | Strength: %s", hl, hc, hsc, hn, strength);
        
    }

    

    public static boolean has_length(String s){

        return (s.length() >= 8);

    }

    public static boolean has_capital(String s){
        String s2 = s.toUpperCase();
        

        for(int i = 0; i < s.length(); i++){

            if(s.charAt((i)) == (s2.charAt(i))){
                return true;
            }

        }

        return false;
    }

    public static boolean has_special_char(String s){

        char[] specialchars = {'!', '@', '#', '$', ',', '%', '^', '&', '*'};

        for(int i = 0; i < s.length(); i++){

            for(int j = 0; j < specialchars.length; j++){
                if (s.charAt(i) == specialchars[j]){
                    return true;
                }
            }
        }

        return false;

    }

    public static boolean has_numbers(String s){

        char[] numbers = {'0','1', '2', '3' ,'4', '5', '6', '7', '8', '9'};


        for(int i = 0; i < s.length(); i++){
            
            for(int j = 0; j < numbers.length; j++){
            if(s.charAt(i) == numbers[j]){
                return true;
            }
            }
        }

        return false;


    }

}
