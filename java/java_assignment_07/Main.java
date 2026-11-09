package java.java_assignment_07;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        soundBoard();
    }


    public static void soundBoard(){
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal bird = new Bird();
        Animal fish = new Fish();
        Scanner scan = new Scanner(System.in);
        int option;
        do{
            System.out.println("Print the number of the animal you would like to learn more about.\n1: Dog\n2: Cat\n3: Bird\n4: Fish\n0: Exit");
            option = scan.nextInt();
            if(option >= 5){
                System.out.println("Invalid input, please provide a proper one");
            }
            else{
            switch(option) {
                case 1:
                    dog.makeSound();
                    System.out.println(dog.describe());
                    ((Dog)dog).extraDescribe();
                    break;
                case 2:
                    cat.makeSound();
                    System.out.println(cat.describe());
                    ((Cat)cat).extraDescribe();
                    break;
                case 3:
                    bird.makeSound();
                    System.out.println(bird.describe());
                    ((Bird)bird).extraDescribe();
                    break;
                case 4:
                    fish.makeSound();
                    System.out.println(fish.describe());
                    ((Fish)fish).extraDescribe();
                    break;
                }
            }
        }
        while(option != 0);

        System.out.println("Thank you for using the soundboard. I hope you have a good day!");
        scan.close();
    }
}