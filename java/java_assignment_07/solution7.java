import java.util.Scanner;
public class solution7{
    private static final Dog dog = new Dog();
    private static final Cat cat = new Cat();
    private static final Bird bird = new Bird();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("1. Dog\n2. Cat\n3. Bird\n4. Surprise me\n0. Exit\nEnter your selection: ");
            int userInput = input.nextInt();
            switch(userInput){
                case 1:
                    animalAction(dog);;
                    break;
                case 2:
                    animalAction(cat);
                    break;
                case 3:
                    animalAction(bird);
                    break;
                case 4: //Stretch Goal Random Animal Selector
                    double rand = Math.random() * 3;
                    if(rand <= 1)
                        animalAction(dog);
                    else if(rand <= 2)
                        animalAction(cat);
                    else
                        animalAction(bird);
                    break;
                case 0:
                    System.out.println("Goodbye! Thanks for visiting the zoo.");
                    System.exit(0);
                default:
                    System.out.println(userInput + " is not a valid selection. Please choose a number from the menu.");
            }
        }
    }

    public static void animalAction(Animal a){
        System.out.println(a.makeSound());
        System.out.println(a.describe());
    }
}

abstract class Animal{
    public abstract String makeSound();
    public abstract String describe();
}

class Dog extends Animal{
    public String makeSound(){
        return "Woof! Woof!";
    }
    public String describe(){
        return "The dog wags its tail excitedly and looks up at you.";
    }
}

class Cat extends Animal{
    public String makeSound(){
        return "Meow! Meow!";
    }
    public String describe(){
        return "The cat looks you with disgust.";
    }
}

class Bird extends Animal{
    public String makeSound(){
        return "Tweet! Tweet!";
    }
    public String describe(){
        return "The bird tilts its head and hops along its perch.";
    }
}