import java.util.Random;
import java.util.Scanner;

//With Stretch Goals 1 and 2
public class AnimalSoundss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selection = -1;

        while(selection != 0){
            System.out.print("Press 1 for Dog, \nPress 2 for Cat, \nPress 3 for Bird, \nPress 4 for 'Surprise Me'");
            System.out.println("\nPlease enter your selection: ");

            if(scanner.hasNext()){
                selection = scanner.nextInt();
                Animal animal = null;

                switch(selection){
                    case 1:
                        animal = new Dog();
                        break;

                    case 2:
                        animal = new Cat();
                        break;

                    case 3:
                        animal = new Bird();
                        break;
                    case 4:
                        animal = getRandomAnimal();
                        break;

                    case 0:
                        System.out.println("GoodBye: Thank you for visiting the zoo. ");
                        break;

                    default:
                        System.out.println("'" + selection + " is not a valid selection. Please choose a number from the menu. ");
                }

            if(animal != null){
                animal.makeSound();
                animal.describe();
            }
            else {
                System.out.println("Invalid Input: Please enter a valid number: ");
                scanner.nextInt();
            }

            }

        }
    scanner.close();
    }


    public static Animal getRandomAnimal(){
        Random random = new Random();

        int number = random.nextInt(3) + 1;

        if(number == 1){
            return  new Dog("Golden Retriever");
        } else if (number == 2){
            return  new Cat("Orange");
        } else {
            return new Bird("Yes can fly.");
        }
    }
}
