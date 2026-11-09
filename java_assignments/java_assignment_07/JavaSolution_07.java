package java_assignments.java_assignment_07;

import java.util.Scanner;

public class JavaSolution_07 {
    public static void main(String[] args) {
        animalMenuStretch();

        Animal dog = new Dog("Golden Doodle");
        Animal cat = new Cat("Black");
        Animal bird = new Bird (true);

        System.out.println("Dog: "+dog.toString());
        System.out.println("Cat: "+cat.toString());
        System.out.println("Bird: "+bird.toString());
        
        
        
    }

    public static void animalMenu(){
        Scanner userIn = new Scanner(System.in);

        System.out.println("Select an animal! \n1. Dog \n2. Cat \n3. Bird \n0. Exit");

        String input = userIn.nextLine();

        while(!input.equals("0")){
            
            switch(input){
                case("1"): 
                    Animal dog = new Dog();
                    dog.makeSound();
                    dog.describe();
                    break;
                case("2"): 
                    Animal cat = new Cat();
                    cat.makeSound();
                    cat.describe();
                    break;
                case("3"): 
                    Animal bird = new Bird();
                    bird.makeSound();
                    bird.describe();
                    break;
                default: 
                    System.out.println("Invalid selection: "+input);
            }

            System.out.println("Make another selection! \n1. Dog \n2. Cat \n3. Bird \n0. Exit");
            input = userIn.nextLine();

        }

        System.out.println("Goodbye! Thanks for visitng.");
        userIn.close();
    }

     public static void animalMenuStretch(){
        Scanner userIn = new Scanner(System.in);

        System.out.println("Select an animal! \n1. Dog \n2. Cat \n3. Bird \n4. Random \n0. Exit");

        String input = userIn.nextLine();

        while(!input.equals("0")){
            
            switch(input){
                case("1"): 
                    Animal dog = new Dog();
                    dog.makeSound();
                    dog.describe();
                    break;
                case("2"): 
                    Animal cat = new Cat();
                    cat.makeSound();
                    cat.describe();
                    break;
                case("3"): 
                    Animal bird = new Bird();
                    bird.makeSound();
                    bird.describe();
                    break;
                case("4"):
                    input = ""+((char) ('0' + (int)(Math.random() * 4)+1));
                    randomHelper(input);
                    break;
                default: 
                    System.out.println("Invalid selection: "+input);
            }

            System.out.println("Make another selection! \n1. Dog \n2. Cat \n3. Bird \n0. Exit");
            input = userIn.nextLine();

        }

        System.out.println("Goodbye! Thanks for visitng.");
        userIn.close();
    }

    public static void randomHelper(String input){
         switch(input){
                case("1"): 
                    Animal dog = new Dog();
                    dog.makeSound();
                    dog.describe();
                    break;
                case("2"): 
                    Animal cat = new Cat();
                    cat.makeSound();
                    cat.describe();
                    break;
                case("3"): 
                    Animal bird = new Bird();
                    bird.makeSound();
                    bird.describe();
                    break;
                default: 
                    System.out.println("Invalid selection: "+input);
            }
    }
}
