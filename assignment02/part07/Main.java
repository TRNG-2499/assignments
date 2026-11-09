package assignment02.part07;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String [] menuOption = {"Dog", "Cat", "Bird"};
        Dog dog = new Dog();
        Cat cat = new Cat();
        Bird bird = new Bird();
        for(int i = 0; i < menuOption.length; i++){
            System.out.printf("%d. %s%n", i+1, menuOption[i]);
        }
        System.out.println("0. Exit");
        
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("Enter your selection: ");
            String userInput = sc.nextLine();
            switch(userInput){
                case "0" -> {
                    System.out.println("Goodbye! Thanks for visiting the zoo.");
                    running = false;
                }
                case "1" -> {
                    dog.makeSound();
                    dog.describe();
                }
                case "2" -> {
                    cat.makeSound();
                    cat.describe();
                }
                case "3" -> {
                    bird.makeSound();
                    bird.describe();
                }
                default -> System.out.printf("'%s' is not a valid selection. Please choose a number from the menu.");
            }
        }
        sc.close();
    }
}
