import java.util.Scanner;

public class AnimalSound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to hear Dog's sound, \nPress 2 to hear Cat's sound \nPress 3 to hear Bird's Sound");
        System.out.println("Enter your selection: ");

        int selection = -1;

        if (scanner.hasNext()) {

            selection = scanner.nextInt();

            Animal animal = null;  // Currently it does not refer to any objec and we don't know which animal the user will select

            switch (selection) {
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
                    System.out.println("GoodBye! Thanks for visiting the zoo!");
                    break;

                default:
                    System.out.println("'" + selection + " is not a valid selection. Please choose a number from the menu.");
            }
        if  (animal != null){
            animal.makeSound();
            animal.describe();

        } else {
            System.out.println("Invalid Input: Please enter a valid number");

            scanner.nextInt();
            }

        }

        scanner.close();
    }


    }






   /*   Another way to handle ...


         int selection=  scanner.nextInt();
        Dog dog = new Dog();
       Cat cat = new Cat();
       Bird bird = new Bird();

       if(selection >= 4 || selection < -1){
           System.out.println(selection + " is not a valid selection. Please choose a number from the menu.");
       }

       if(selection == 1){
           dog.makeSound();
           dog.describe();
       } else if (selection == 2){
           cat.makeSound();
           cat.describe();
       } else if (selection == 3){
           bird.makeSound();
           bird.describe();
       } else if (selection == 0){
           System.out.println("GoodBye! Thanks for visiting the zoo.");
       } */