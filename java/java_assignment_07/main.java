import java.util.Scanner;

class main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\n1. Dog \n2. Cat \n3. Bird \n0. Exit \nEnter your selection");
            String input = scanner.nextLine();

            if(input.equals("1")) {
                Animal dog = new Dog();
                dog.makeSound();
                dog.describe();
            } else if(input.equals("2")) {

                Animal cat = new Cat();
                cat.makeSound();
                cat.describe();
            } else if(input.equals("3")) {
                Animal bird = new Bird();
                bird.makeSound();
                bird.describe();
            } else if (input.equals("0")) {
                System.out.println("quitting.\n");
                break;
            } else {
                System.out.println("Invalid selection, try again.");
            }
        }
    }
}