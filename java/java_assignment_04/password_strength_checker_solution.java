import java.util.*;
//import java.util.regex.*;

public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Input a password:");
    String password = scanner.nextLine();

    Checker(password);

    scanner.close();
}

/*
    Is at least 8 characters long - if(password.length() < 8) then fail
    Contains at least one digit - 
    Contains at least one upper case - 
    Contains at least one special case -
    Doesn't end if tests fail, just make sure to count which ones fail and succeed

    Fail if the string is null
*/
public static void Checker(String password){
    int testTracker = 0;
    System.out.println("|Length: " + ((password.length() >= 8) ? "Pass" : "Fail"));
    if(password.length() >= 8)
        testTracker++;
    
    System.out.println("|Digit: " + ((password.matches(".*\\d.*")) ? "Pass" : "Fail"));
    if(password.matches(".*\\d.*"))
        testTracker++;
    
    System.out.println("|Uppercase: " + ((password.matches(".*[A-Z].*")) ? "Pass" : "Fail"));
    if(password.matches(".*[A-Z].*"))
        testTracker++;
    
    System.out.println("|Special Case: " + ((password.matches(".*[^a-zA-Z0-9].*")) ? "Pass" : "Fail"));
    if(password.matches(".*[^a-zA-Z0-9].*"))
        testTracker++;
    
    switch(testTracker){
        case 0:
            System.out.println("|Strengh: Weak");
            break;
        case 1:
            System.out.println("|Strengh: Weak");
            break;
        case 2:
            System.out.println("|Strengh: Medium");
            break;
        case 3:
            System.out.println("|Strengh: Medium");
            break;
        case 4:
            System.out.println("|Strengh: Strong");
            break;
    }
}