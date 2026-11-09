import java.util.Scanner;

public static void main(String[] args){
    
    Calculator();

}

//Use a switch statement for the various cases
public static void Calculator(){
    int value = 0;
    Scanner scanner = new Scanner(System.in);
    int option;
    do{
        System.out.println("Please provide what calculation you wish to do. The default starting value is 0:\n1: Add\n2: Subtract\n3: Reset\n4: Total\n5: Exit");
        option = scanner.nextInt();
        switch(option){
            case 1:
                System.out.println("Print the number you would like to add to the current value: " + value);
                value += scanner.nextInt();
                System.out.println("New value is now: " + value);
                break;
            case 2:
                System.out.println("Print the number you would like to subtract form the current value: " + value);
                value -= scanner.nextInt();
                System.out.println("New value is now: " + value);
                break;
            case 3:
                value = 0;
                System.out.println("The value has now been reset to 0");
                break;
            case 4:
                System.out.println("The current total is: " + value);
                break;
        }
    }
    while(option != 5);

    System.out.println("Calculator will now close. Have a good day.");

    scanner.close();
}