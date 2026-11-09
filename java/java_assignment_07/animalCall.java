package assignments.java.java_assignment_07;

import java.util.Scanner;

public class animalCall {
    static Dog leo = new Dog();
    static Cat daisy = new Cat();
    static Bird bird = new Bird();
    public static void main(String[] args) {
        inputReader();
    }

    public static void inputReader(){
        Scanner scanner = new Scanner(System.in);
        String line;
        boolean end = false;

        while(!end){
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Bird");
            System.out.println("0. Exit");
            System.out.print("Enter your selection: ");
            line = scanner.nextLine();
            end = callAnimal(line);
            System.out.println();
        }
        scanner.close();
    }

    public static boolean callAnimal(String commandLine) {
        boolean exit = false;

        /*int num = 0;
        int space = commandLine.indexOf(' ');
        boolean twoParts = true;
        boolean validNum = true;*/

        /*if (space > 0) { //2 parts
            command = commandLine.substring(0, space);
            //stringNum = commandLine.substring(space+1, commandLine.length());
            try {
                num = Integer.parseInt(commandLine.substring(space+1, commandLine.length()));
            } catch (NumberFormatException e) {
                validNum = false;
            }
            //num = Integer.parseInt(commandLine.substring(space+1, commandLine.length()));
        }else {//1 word
            command = commandLine;
            twoParts = false;
        }*/

        switch (commandLine) {
            case "1":
                leo.makeSound();
                leo.describe();
                break;
            case "2":
                daisy.makeSound();
                daisy.describe();
                break;
            case "3":
                bird.makeSound();
                bird.describe();
                break;
            case "0":
                System.out.println("Goodbye! Thanks for visiting my house.");
                exit = true;
                break;
            default:
                System.out.println("'"+ commandLine +"' is not a valid selection. Please choose a number from the menu.");
                break;
        }
        return exit;
    }
}
