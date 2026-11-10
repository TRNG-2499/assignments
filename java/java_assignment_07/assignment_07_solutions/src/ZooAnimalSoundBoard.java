import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class ZooAnimalSoundBoard {

    static void main() {
        ZooAnimalSoundBoard instance = new ZooAnimalSoundBoard();

        /*
        Test core loop
         */
//        instance.loop();

        /*
        Test stretch loop
         */
        instance.stretchLoop();
    }

    public void loop() {
        boolean endLoop = false;
        Scanner scanner = new Scanner(System.in);
        String userPrompt = """
                    1. Dog
                    2. Cat
                    3. Bird
                    0. Exit
                    Enter your selection:\s""";

        while(!endLoop) {
            System.out.println(userPrompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a valid selection.");
                System.out.println(userPrompt);
                scanner.next();
            }
            int userAnimalSelection = scanner.nextInt();

            switch(userAnimalSelection) {
                case 1 -> {
                    Dog dog = new Dog();
                    System.out.println(dog.makeSound());
                    System.out.println(dog.describe());
                }
                case 2 -> {
                    Cat cat = new Cat();
                    System.out.println(cat.makeSound());
                    System.out.println(cat.describe());
                }
                case 3 -> {
                    Bird bird = new Bird();
                    System.out.println(bird.makeSound());
                    System.out.println(bird.describe());
                }
                case 0 -> {
                    System.out.println("Farewell my dear user.");
                    endLoop = true;
                }
                default -> System.out.println("Error: Please enter a valid selection.");
            }
        }
        scanner.close();
    }

    public void stretchLoop() {
        boolean endLoop = false;
        Scanner scanner = new Scanner(System.in);
        String userPrompt = """
                    1. Dog
                    2. Cat
                    3. Bird
                    4. Random Selection
                    0. Exit
                    Enter your selection:\s""";

        while(!endLoop) {
            System.out.println(userPrompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a valid selection.");
                System.out.println(userPrompt);
                scanner.next();
            }
            int userAnimalSelection = scanner.nextInt();

            if (userAnimalSelection == 4) {
                Random random = new Random();
                userAnimalSelection = random.nextInt(1, 4);
            }

            switch(userAnimalSelection) {
                case 1 -> {
                    DogStretch dog = new DogStretch("Poodle");
                    System.out.println(dog.makeSound());
                    System.out.println(dog.describe());
                    System.out.println("Dog breed: " + dog.getBreed());
                }
                case 2 -> {
                    CatStretch cat = new CatStretch("Orange");
                    System.out.println(cat.makeSound());
                    System.out.println(cat.describe());
                    System.out.println("Cat color: " + cat.getColor());
                }
                case 3 -> {
                    BirdStretch bird = new BirdStretch(true);
                    System.out.println(bird.makeSound());
                    System.out.println(bird.describe());
                    System.out.println("Bird can fly: " + bird.getCanFly());
                }
                case 0 -> {
                    System.out.println("Farewell my dear user.");
                    endLoop = true;
                }
                default -> System.out.println("Error: Please enter a valid selection.");
            }
        }
        scanner.close();
    }
}