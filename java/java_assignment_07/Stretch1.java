import java.util.Scanner;

public class Stretch1 {

    public static void animalActions(Animal currentAnimal){
        currentAnimal.makeSound();
        currentAnimal.describe();
    }

    public static void readInput(){
        Scanner scanner = new Scanner(System.in);
        boolean continueReading = true;
        String command = "";
        Animal currentAnimal;

        while(continueReading){
            System.out.println("1.) Dog\n" +
                    "2.) Cat\n" +
                    "3.) Bird\n" +
                    "0.) Exit");

            command = scanner.nextLine();

            switch(command){
                case "0":
                    continueReading = false;
                    break;
                case "1":
                    currentAnimal = new NewDog();
                    animalActions(currentAnimal);
                    break;
                case "2":
                    currentAnimal = new NewCat();
                    animalActions(currentAnimal);
                    break;
                case "3":
                    currentAnimal = new NewBird();
                    animalActions(currentAnimal);
                    break;
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
