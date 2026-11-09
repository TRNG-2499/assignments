package javaAssignments.java_assignment_07;
import java.util.Random;
import java.util.Scanner;

public class zoo_soundboard {
    static Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {

        System.out.println("Please select your operation mode:\n[1] Standard Description and name\n[2] Stretch goal Extra mode\n[3] Random mode");
        int mode = sc.nextInt();
        
        switch (mode) {
            case 1:
                standardMode();
                break;
            case 2:
                stretchGoalMode();
                break;
            case 3:
                randomMode();
                break;
            default:
                System.out.println("Invalid mode. Please try again.");
        }

    }
    public static void standardMode(){

            boolean running = true;

            while(running == true){
                //creating our objects
                bear bear = new bear("Roar!", "A big bear");
                cat cat = new cat("Meow!", "A cute cat");
                dog dog = new dog("Woof!", "A friendly dog");


                //display the welcome message and prompt the user for input
                System.out.println("Welcome to the Zoo Soundboard!");
                System.out.println("Choose an animal to hear its sounds:");
                System.out.println("[1] Dog \n[2] Cat \n[3] Bear \n[0] Exit");
                int choice = sc.nextInt();
                switch (choice) { //handles the user's input choice
                    case 1:
                        dog.makeSound();
                        dog.describe();
                        break;
                    case 2:
                        cat.makeSound();
                        cat.describe();
                        break;
                    case 3:
                        bear.makeSound();
                        bear.describe();
                        break;
                    case 0:
                        System.out.println("Exiting the Zoo Soundboard. Goodbye!");
                        running = false; //stops the main loop of the program
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again."); //this way any other input defaults to a fail stae
                    }
                }
            }

    public static void stretchGoalMode(){

            boolean running = true;

            while(running == true){
                //creating our objects
                bear bear = new bear("Roar!", "A big bear");
                cat cat = new cat("Meow!", "A cute cat");
                dog dog = new dog("Woof!", "A friendly dog");


                //display the welcome message and prompt the user for input
                System.out.println("Welcome to the Zoo Soundboard!");
                System.out.println("Choose an animal to hear its sounds:");
                System.out.println("[1] Dog \n[2] Cat \n[3] Bear \n[0] Exit");
                int choice = sc.nextInt();
                switch (choice) { //handles the user's input choice
                    case 1:
                        dog.makeSound();
                        dog.describe();
                        dog.play();
                        break;
                    case 2:
                        cat.makeSound();
                        cat.describe();
                        cat.lounge();
                        break;
                    case 3:
                        bear.makeSound();
                        bear.describe();
                        running = bear.smash();
                        break;
                    case 0:
                        System.out.println("Exiting the Zoo Soundboard. Goodbye!");
                        running = false; //stops the main loop of the program
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again."); //this way any other input defaults to a fail stae
                    }
                }
            }
     public static void randomMode(){

            Random random = new Random(); 
            boolean running = true;

            while(running == true){
                //creating our objects
                bear bear = new bear("Roar!", "A big bear");
                cat cat = new cat("Meow!", "A cute cat");
                dog dog = new dog("Woof!", "A friendly dog");


                //display the welcome message and prompt the user for input
                System.out.println("Welcome to the Zoo Soundboard!");
                System.out.println("Choose an animal to hear its sounds:");
                System.out.println("[1] Dog \n[2] Cat \n[3] Bear \n[4] Random \n[0] Exit");
                int choice = sc.nextInt();
                switch (choice) { //handles the user's input choice
                    case 1:
                        dog.makeSound();
                        dog.describe();
                        break;
                    case 2:
                        cat.makeSound();
                        cat.describe();
                        break;
                    case 3:
                        bear.makeSound();
                        bear.describe();
                        break;
                    case 4:
                        int randomChoice = random.nextInt(3) + 1; //generates a random number between 1 and 3
                        switch (randomChoice) {
                            case 1:
                                dog.makeSound();
                                dog.describe();
                                break;
                            case 2:
                                cat.makeSound();
                                cat.describe();
                                break;
                            case 3:
                                bear.makeSound();
                                bear.describe();
                                break;
                        }
                        break;
                    case 0:
                        System.out.println("Exiting the Zoo Soundboard. Goodbye!");
                        running = false; //stops the main loop of the program
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again."); //this way any other input defaults to a fail stae
                    }
                }
            }
    }
