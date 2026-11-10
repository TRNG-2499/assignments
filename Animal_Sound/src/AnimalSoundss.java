import java.util.Scanner;

public class AnimalSoundss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selection = -1;

        while(selection != 0){
            System.out.print("Press 1 for Dog, \nPress 2 for Cat, \npress 3 for Bird.");
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
}
