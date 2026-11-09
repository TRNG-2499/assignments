import java.io.*;
import java.util.*;

public abstract class Animal {

    public abstract String makeSound();

    public abstract String describe();

    public static void main(String... args){
        Scanner user = new Scanner(System.in);

        boolean running = true;
        while(running){
            Animal currentAnimal = null;
            String choice = "";

            System.out.println("1. Dog");
            System.out.println("2. Lion");
            System.out.println("3. Peacock");
            System.out.println("4. Whale");
            System.out.println("5. Frog");
            System.out.println("0. Exit");

            System.out.print("Enter your selection: ");
            choice = user.next();
            try {
                switch(Integer.parseInt(choice)){
                    case 0:
                        running = false;
                        break;
                    case 1:
                        currentAnimal = new Dog();
                        break;
                    case 2:
                        currentAnimal = new Lion();
                        break;
                    case 3:
                        currentAnimal = new Peacock();
                        break;
                    case 4:
                        currentAnimal = new Whale();
                        break;
                    case 5:
                        currentAnimal = new Frog();
                        break;
                    default:
                        logError(choice);
                        continue;
                }
                if(!running){
                    System.out.println("Goodbye! Thanks for visiting the zoo.");
                } else {
                    if(currentAnimal != null){
                        System.out.println(currentAnimal.makeSound());
                        System.out.println(currentAnimal.describe());
                        System.out.println();
                    }
                }
            } catch (NumberFormatException e){
                logError(choice);
                System.out.println();
            }
        }
        user.close();
    }

    private static void logError(String selection){
        System.out.println("\'" + selection + "\' is not a valid selection. Please choose a number from the menu.");
    }
}