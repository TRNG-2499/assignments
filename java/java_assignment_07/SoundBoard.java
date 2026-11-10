
import java.util.Random;
import java.util.Scanner;

public class SoundBoard {
    public static void main(String... args) {
        int sel = -1;
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        while (true) {

            switch (sel) {
                case 1 -> {
                    Animal dog = new Dog();
                    dog.sayHi();
                }
                case 2 -> {
                    Animal snake = new Snake();
                    snake.sayHi();
                }
                case 3 -> {
                    Animal fish = new Fish();
                    fish.sayHi();
                }
                case 4 -> {
                    Animal bird = new Bird();
                    bird.sayHi();
                }
                case 5 -> {
                    Animal frog = new Frog();
                    frog.sayHi();
                }
                case 6 -> {
                    System.out.println("Picking a random friend to say Hi!");
                    sel = rand.nextInt(5) + 1;
                    continue;
                }
                case 0 -> {
                    System.out.println("Goodbye! Thanks for visiting the zoo!");
                    return;
                }
                case -1 -> {}
                default -> {
                    System.out.printf("'%d' is not a valid selection. Please choose a number from the menu.\n",sel);
                    //sel = -1;
                }            
            }
            System.out.print("\n\n1. Dog\n2. Snake\n3. Fish\n4. Bird\n5. Frog\n6. Surprise Me!\n0. Exit\nEnter your selection: ");

            try {
                sel = Integer.parseInt(in.nextLine().strip());
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid number. Please choose a number from the menu.");
                sel = -1;
            }
            
        }
    }

    public static abstract class Animal {
        public abstract void makeSound();
        public abstract void describe();
        public abstract void move();

        public void sayHi(){
            makeSound();
            describe();
            move();
        }
    }

    public static class Dog extends Animal {
        private final String breed;

        public Dog(String breed){
            this.breed = breed;
        }

        public Dog(){
            this.breed = "Dalmatian";
        }
        
        @Override
        public void makeSound() {
            System.out.println("Woof woof!");
        }

        @Override
        public void describe() {
            System.out.printf("The dog wags its tail excitedly! It's a %s.\n", this.breed);
        }

        @Override
        public void move() {
            System.out.println("The dog runs across the field");
        }
        
    }

    public static class Snake extends Animal {
        private final double length;

        public Snake(double length){
            this.length = length;
        }

        public Snake(){
            this.length = 1.8;
        }
        
        @Override
        public void makeSound() {
            System.out.println("Hisssssssss....");
        }

        @Override
        public void describe() {
            System.out.printf("The snake flicks its tongue in your direction, it looks to be around %.2f metres long!\n", this.length);
        }

        @Override
        public void move() {
            System.out.println("The snake is slithering through the grass...");
        }
        
    }

    public static class Fish extends Animal {
        private final String primaryColour;

        public Fish(String primaryColour){
            this.primaryColour = primaryColour;
        }

        public Fish(){
            this.primaryColour = "Silver";
        }
        
        @Override
        public void makeSound() {
            System.out.println("blub.. blub..... blub..");
        }

        @Override
        public void describe() {
            System.out.printf("The fishes' bright %s scales glint under the surface of the stream.\n", this.primaryColour);
        }

        @Override
        public void move() {
            System.out.println("The fish swims gracefully between the reeds.");
        }
        
    }

    public static class Bird extends Animal {
        private boolean canFly;
        
        public Bird(boolean canFly){
            this.canFly = canFly;
        }

        public Bird(){
            this.canFly = true;
        }

        @Override
        public void makeSound() {
            System.out.println("Chirp chirp chirp!");
        }

        @Override
        public void describe() {
            System.out.println("The bird ruffles its feathers a bit and tilts its head at you.");
        }

        @Override
        public void move() {
            System.out.printf("%s\n", this.canFly?"The bird flies swiftly through the air":"The bird darts across the plain.");
        }
        
    }

    public static class Frog extends Animal {
        private final boolean isPoisonous;

        public Frog(boolean isPoisonous){
            this.isPoisonous = isPoisonous;
        }

        public Frog(){
            this.isPoisonous = false;
        }
        
        @Override
        public void makeSound() {
            System.out.println("riBIT... riBIT...!");
        }

        @Override
        public void describe() {
            System.out.printf("The frog pauses and expands its throat... you%s think its poisonous\n", this.isPoisonous?"":" don't");
        }

        @Override
        public void move() {
            System.out.println("The frog hops deftly between the rocks acorss the pond.");
        }
        
    }
}