public class Stretch2 {

    public static void passwordCheckerWithBlacklist(String password) {

        int rulesPassed = 0;
        boolean lengthPassed = false;
        boolean digitPassed = false;
        boolean uppercasePassed = false;
        boolean specialPassed = false;

        String[] commonPasswords = {"querty", "aabbccdd", "1234567890", "welcome123", "q1w2e3r4"};

        for(String s : commonPasswords){
            if(s.equals(password)){
                System.out.println("Special Error: Common Password Entered -- Strength: Weak \n");
                return;
            }
        }


        if(password==null || password.equals("")){
            System.out.println("Length: Fail | Digit: Fail | Uppercase: Fail | Special Character: Fail -- Strength: Weak\n");
        } else {
            //Password is valid, run tests

            //Length Check
            if(password.length() >= 8){
                lengthPassed = true;
                rulesPassed++;
            }

            //My approach here is to crawl through the password 1 char at a time
            //It's a bit more cluttered and harder to read compared to simply using the matches() method
            //but my reasoning is that its more optimal to crawl through the password 1 time than 3 times
            for(int i = 0; i < password.length(); i++){

                //if all rules are good, can stop crawling through password.
                if(rulesPassed==4){
                    break;
                }

                if(!digitPassed && Character.isDigit(password.charAt(i))){
                    digitPassed = true;
                    rulesPassed++;
                }

                if(!uppercasePassed && Character.isUpperCase(password.charAt(i))){
                    uppercasePassed = true;
                    rulesPassed++;
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
                            rulesPassed++;
                            break;
                    }

                }
            }

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
                case 1:
                    System.out.println("Strength: Weak\n");
                    break;
                case 2:
                case 3:
                    System.out.println("Strength: Medium\n");
                    break;
                case 4:
                    System.out.println("Strength: Strong\n");
                    break;
            }


        }

    }

    public static void main(String[] args) {

        //Blacklist (Opted not to use password in the blacklist filter to not break my other test cases)
        System.out.println("Input: querty");
        passwordCheckerWithBlacklist("querty");

        System.out.println("Input: aabbccdd");
        passwordCheckerWithBlacklist("aabbccdd");

        System.out.println("Input: 1234567890");
        passwordCheckerWithBlacklist("1234567890");

        System.out.println("Input: welcome123");
        passwordCheckerWithBlacklist("welcome123");

        System.out.println("Input: q1w2e3r4");
        passwordCheckerWithBlacklist("q1w2e3r4");

        //Passes 1 Rule
        System.out.println("Input: password");
        passwordCheckerWithBlacklist("password");

        //Passes 2 Rules
        System.out.println("Input: password1");
        passwordCheckerWithBlacklist("password1");

        //Passes 3 Rules
        System.out.println("Input: Password1");
        passwordCheckerWithBlacklist("Password1");

        //Passes all rules
        System.out.println("Input: P@ssword1");
        passwordCheckerWithBlacklist("P@ssword1");

        //Empty Input
        System.out.println("Input: (Empty String Given)");
        passwordCheckerWithBlacklist("");

        //Null Input
        System.out.println("Input: (Null Given)");
        passwordCheckerWithBlacklist(null);

    }
}
