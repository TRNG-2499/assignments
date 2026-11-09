import java.util.Random;
import java.util.Scanner;

public class Stretch2 {

    public static void animalActions(Animal currentAnimal){
        currentAnimal.makeSound();
        currentAnimal.describe();
    }

    public static void readInput(){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean continueReading = true;
        String command = "";
        Animal currentAnimal;

        while(continueReading){
            System.out.println("1.) Dog\n" +
                    "2.) Cat\n" +
                    "3.) Bird\n" +
                    "4.) Surprise Me\n" +
                    "0.) Exit");

            command = scanner.nextLine();

            if(command.equals("4")){
                command = String.valueOf(random.nextInt(3) + 1);
            }

            switch(command){
                case "0":
                    continueReading = false;
                    break;
                case "1":
                    currentAnimal = new Dog();
                    animalActions(currentAnimal);
                    break;
                case "2":
                    currentAnimal = new Cat();
                    animalActions(currentAnimal);
                    break;
                case "3":
                    currentAnimal = new Bird();
                    animalActions(currentAnimal);
                    break;
                case "4":
                    break; //case 4 here to prevent it from reading as invalid.
                default:
                    System.out.println(command + " is not a valid selection. Please choose a number from the menu");
            }

        }

        scanner.close();
        System.out.print("Goodbye! Thank you for visiting the zoo.");
    }

    public static void main(String[] args){
        readInput();
    }

}
