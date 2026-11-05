public class Stretch1 {

    //Custom Weights
    //Length = 2
    //Digit = 1
    //Upper = 1
    //Special = 3

    public static void passwordCheckerWithCustomWeights(String password) {

        int rulesPassed = 0;
        boolean lengthPassed = false;
        boolean digitPassed = false;
        boolean uppercasePassed = false;
        boolean specialPassed = false;


        if(password==null || password.equals("")){
            System.out.println("Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Very Weak\n");
        } else {
            //Password is valid, run tests

            //Length Check
            if(password.length() >= 8){
                lengthPassed = true;
                rulesPassed+=2;
            }

            //My approach here is to crawl through the password 1 char at a time
            //It's a bit more cluttered and harder to read compared to simply using the matches() method
            //but my reasoning is that its more optimal to crawl through the password 1 time than 3 times
            for(int i = 0; i < password.length(); i++){

                //if all rules are good, can stop crawling through password.
                if(rulesPassed==7){
                    break;
                }

                if(!digitPassed && Character.isDigit(password.charAt(i))){
                    digitPassed = true;
                    rulesPassed+=1;
                }

                if(!uppercasePassed && Character.isUpperCase(password.charAt(i))){
                    uppercasePassed = true;
                    rulesPassed+=1;
                }

                if(!specialPassed){
                    switch(password.charAt(i)){
                        case '!':
                        case '@':
                        case '#':
                        case '$':
                        case '%':
                        case '^':
                        case '&':
                        case '*':
                            specialPassed = true;
                            rulesPassed+=3;
                            break;
                    }

                }
            }

            //Debug Statement
            System.out.println("Password Strength Level: " + rulesPassed);

            //Time to build the output Message:
            //Using print to build the message on the same line
            if(lengthPassed){
                System.out.print("Length: Pass | ");
            } else {
                System.out.print("Length: Fail | ");
            }

            if(digitPassed){
                System.out.print("Digit: Pass | ");
            } else {
                System.out.print("Digit: Fail | ");
            }

            if(uppercasePassed){
                System.out.print("Uppercase: Pass | ");
            } else {
                System.out.print("Uppercase: Fail | ");
            }

            if(specialPassed){
                System.out.print("Special: Pass -- ");
            } else {
                System.out.print("Special: Fail -- ");
            }

            //Finishing output with println to space out the message tail and the next test case
            switch(rulesPassed){
                case 0:
                    System.out.println("Strength: Very Weak\n");
                    break;
                case 1:
                case 2:
                    System.out.println("Strength: Weak\n");
                    break;
                case 3:
                case 4:
                    System.out.println("Strength: Medium\n");
                    break;
                case 5:
                    System.out.println("Strength: Strong\n");
                    break;
                case 6:
                case 7:
                    System.out.println("Strength: Very Strong\n");
                    break;

            }


        }

    }

    public static void main(String[] args) {
        //Passes 0 Rules
        System.out.println("Input: idk");
        passwordCheckerWithCustomWeights("idk");

        //Passes 1 Rule
        System.out.println("Input: password");
        passwordCheckerWithCustomWeights("password");

        //Passes 2 Rules
        System.out.println("Input: password1");
        passwordCheckerWithCustomWeights("password1");

        //Passes 3 Rules
        System.out.println("Input: Password1");
        passwordCheckerWithCustomWeights("Password1");

        //Passes 2 Rules, but gets Strength Level 5 for Strong
        System.out.println("Input: password!");
        passwordCheckerWithCustomWeights("password!");

        //Passes all rules
        System.out.println("Input: P@ssword1");
        passwordCheckerWithCustomWeights("P@ssword1");

        //Empty Input
        System.out.println("Input: (Empty String Given)");
        passwordCheckerWithCustomWeights("");

        //Null Input
        System.out.println("Input: (Null Given)");
        passwordCheckerWithCustomWeights(null);

    }
}
