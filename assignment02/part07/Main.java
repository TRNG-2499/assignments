package assignment02.part07;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        String [] menuOption = {"Dog", "Cat", "Bird", "Surprise me"};
        Dog dog = new Dog("Labrador");
        Cat cat = new Cat(false);
        Bird bird = new Bird(true);
        Animal [] animals = {dog, cat, bird};
        for(int i = 0; i < menuOption.length; i++){
            System.out.printf("%d. %s%n", i+1, menuOption[i]);
        }
        System.out.println("0. Exit");

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
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
                    System.out.println("What dog breed would you like to see next? ");
                    String dogBreed = sc.nextLine();
                    dog.setBreed(dogBreed);
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
                case "4" -> {
                    int number = random.nextInt(animals.length);
                    Animal pick = animals[number];
                    pick.makeSound();
                    pick.describe();
                }
                default -> System.out.printf("'%s' is not a valid selection. Please choose a number from the menu.");
            }
        }
        sc.close();
    }
}
