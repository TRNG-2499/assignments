import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Zoo Animal Sound Board.
 * 
 */
public class ZooSoundBoard {

    // One menu entry: the label shown to the user and how to create the animal.
    private record MenuOption(String label, Supplier<Animal> factory) {
    }

    // ---------- Base activity animals ----------
    private static final List<MenuOption> BASIC_ANIMALS = List.of(
            new MenuOption("Dog", Dog::new),
            new MenuOption("Cat", Cat::new),
            new MenuOption("Bird", Bird::new));

    // ---------- Stretch 1: Additional Animal Attributes ----------
    // Same animals, created through subclasses that add a unique field each.
    private static final List<MenuOption> DETAILED_ANIMALS = List.of(
            new MenuOption("Dog", () -> new ShowDog("Golden Retriever")),
            new MenuOption("Cat", () -> new HouseCat("ball of yarn")),
            new MenuOption("Bird", () -> new ExoticBird("Scarlet Macaw", true)));

    private static final Random RANDOM = new Random();

    // ---------- Base activity ----------
    // Shows the menu and handles selections until the user enters 0.
    public static void runSoundBoard(Scanner scanner) {
        runMenu(scanner, BASIC_ANIMALS, false);
    }

    // ---------- Full version (base + both stretch goals) ----------
    public static void runFullSoundBoard(Scanner scanner) {
        runMenu(scanner, DETAILED_ANIMALS, true);
    }

    // Shared menu loop. When includeSurprise is true, an extra
    // "Surprise Me" option is listed right after the animals.
    private static void runMenu(Scanner scanner, List<MenuOption> animals, boolean includeSurprise) {
        int surpriseNumber = includeSurprise ? animals.size() + 1 : -1;

        while (true) {
            printMenu(animals, surpriseNumber);
            System.out.print("Enter your selection: ");
            if (!scanner.hasNextLine()) {
                System.out.println();
                break; // input stream closed
            }
            String input = scanner.nextLine().trim();

            Integer choice = parseSelection(input);
            if (choice == null) {
                System.out.println("'" + input + "' is not a valid selection. Please enter a number from the menu.");
            } else if (choice == 0) {
                System.out.println("Goodbye! Thanks for visiting the zoo.");
                return;
            } else if (choice >= 1 && choice <= animals.size()) {
                animals.get(choice - 1).factory().get().perform();
            } else if (choice == surpriseNumber) {
                surpriseMe(animals);
            } else {
                System.out.println("'" + input + "' is not a valid selection. Please choose a number from the menu.");
            }
            System.out.println();
        }
    }

    private static void printMenu(List<MenuOption> animals, int surpriseNumber) {
        for (int i = 0; i < animals.size(); i++) {
            System.out.println((i + 1) + ". " + animals.get(i).label());
        }
        if (surpriseNumber > 0) {
            System.out.println(surpriseNumber + ". Surprise Me");
        }
        System.out.println("0. Exit");
    }

    // Returns the number the user typed, or null if it is not a whole number.
    private static Integer parseSelection(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // ---------- Stretch 2: Random Animal Selector ----------
    // Picks one of the available animals at random and shows its output.
    public static void surpriseMe(List<MenuOption> animals) {
        MenuOption pick = animals.get(RANDOM.nextInt(animals.size()));
        System.out.println("Surprise! You got the " + pick.label() + ".");
        pick.factory().get().perform();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (args.length > 0 && args[0].equalsIgnoreCase("basic")) {
            runSoundBoard(scanner);
        } else {
            runFullSoundBoard(scanner);
        }
        scanner.close();
    }
}

// ====================================================================

/**
 * Base class for every animal on the sound board.
 */
abstract class Animal {

    private final String name;

    protected Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // The animal's sound, e.g. "Woof! Woof!"
    public abstract String makeSound();

    // A short description specific to this animal.
    public abstract String describe();

    // Shared by every subclass: prints the sound followed by the description.
    public void perform() {
        System.out.println(makeSound());
        System.out.println(describe());
    }
}

// ====================================================================

class Dog extends Animal {

    public Dog() {
        super("Dog");
    }

    @Override
    public String makeSound() {
        return "Woof! Woof!";
    }

    @Override
    public String describe() {
        return "The dog wags its tail excitedly and looks up at you.";
    }
}

// ====================================================================

class Cat extends Animal {

    public Cat() {
        super("Cat");
    }

    @Override
    public String makeSound() {
        return "Meow! Meow!";
    }

    @Override
    public String describe() {
        return "The cat stretches lazily and blinks slowly at you.";
    }
}

// ====================================================================

class Bird extends Animal {

    public Bird() {
        super("Bird");
    }

    @Override
    public String makeSound() {
        return "Tweet! Tweet!";
    }

    @Override
    public String describe() {
        return "The bird tilts its head and hops along its perch.";
    }
}

// ====================================================================

/**
 * Stretch goal: Additional Animal Attributes.
 * Extends Dog (instead of changing it) to add a breed.
 */
class ShowDog extends Dog {

    private final String breed;

    public ShowDog(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String describe() {
        return super.describe() + " This one is a " + breed + ".";
    }
}

// ====================================================================

/**
 * Stretch goal: Additional Animal Attributes.
 * Extends Cat (instead of changing it) to add a favorite toy.
 */
class HouseCat extends Cat {

    private final String favoriteToy;

    public HouseCat(String favoriteToy) {
        this.favoriteToy = favoriteToy;
    }

    public String getFavoriteToy() {
        return favoriteToy;
    }

    @Override
    public String describe() {
        return super.describe() + " Its favorite toy is a " + favoriteToy + ".";
    }
}

// ====================================================================

/**
 * Stretch goal: Additional Animal Attributes.
 * Extends Bird (instead of changing it) to add a species and whether it can
 * fly.
 */
class ExoticBird extends Bird {

    private final String species;
    private final boolean canFly;

    public ExoticBird(String species, boolean canFly) {
        this.species = species;
        this.canFly = canFly;
    }

    public String getSpecies() {
        return species;
    }

    public boolean canFly() {
        return canFly;
    }

    @Override
    public String describe() {
        String flight = canFly ? "It flaps its wings, ready to take off."
                : "It cannot fly, so it waddles around instead.";
        return super.describe() + " It is a " + species + ". " + flight;
    }
}
