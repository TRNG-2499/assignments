package java_assignment_07;

import java.util.Scanner;

public class JA07 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void processSelection(int selection){
        switch(selection){
            case(1):
                Animal dog = new Dog();
                dog.makeSound();
                dog.describe();
                break;
            case(2):
                Animal cat = new Cat();
                cat.makeSound();
                cat.describe();
                break;
            case(3):
                Animal bird = new Bird();
                bird.makeSound();
                bird.describe();
                break;
            default:
                System.out.printf("%d is not a valid selection. Please choose a number from the menu.\n", selection);
                return;
        }
    }

    public static void receiveSelection(){
        while(true){
            System.out.println("1. Dog\n 2. Cat\n 3. Bird\n 0. Exit\n Enter your selection:");
            int selection = scanner.nextInt();
            if (selection == 0){
                System.out.println("Goodbye! Thanks for visiting the zoo.\n");
                scanner.close();
                break;
            }
            processSelection(selection);
        }
    }
    public static void main(String[] args){
        receiveSelection();
    }
}
