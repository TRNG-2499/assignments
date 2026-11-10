package assignments.java.java_assignment_07;
import java.util.Scanner;


public class Main {

    public static void main(String args[]){


        try (Scanner myObj = new Scanner(System.in)) {
            String input;
            String options = "1. Dog \n2. Cat \n3. Bird \n0. Exit \nEnter your selection";
            
            Animal Dog1 = new Dog();
            Animal Cat1= new Cat();
            Animal Bird1 = new Bird();
            
            OUTER:
            while (true) {
                System.out.println(options);
                input = myObj.nextLine();
                switch (input) {
                    case "0" -> {
                        System.out.println("Goodbye, thanks for visiting the zoo");
                        break OUTER;
                    }
                    case "1" -> {
                        Dog1.makeSound();
                        Dog1.describe();
                    }
                    case "2" -> {
                        Cat1.makeSound();
                        Cat1.describe();
                    }
                    case "3" -> {
                        Bird1.makeSound();
                        Bird1.describe();
                    }
                    default -> System.out.println("Invalid number.");
                }
            }
        }

    }
    
}
