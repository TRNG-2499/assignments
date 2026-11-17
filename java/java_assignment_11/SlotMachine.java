import java.util.Scanner;
import java.util.Random;

class SlotMachine extends Entity {
    private final String name = "At-Home Slot Machine";
    private final String Description = "A compact and convenient slot machine suitable for at-home use";

    public String getName() {
        return name;
    }
    public String getDescription() {
        return Description;
    }

    private static void runSlots() {
        Random rand = new Random();
        String[] array = {"Spades", "Diamonds", "Clubs", "Hearts"};
        int min = 0, max = 3;
        System.out.print(" || ");

        System.out.print(array[rand.nextInt(max - min + 1) + min] + " || " + array[rand.nextInt(max - min + 1) + min] + " || " + array[rand.nextInt(max - min + 1) + min] + " || \n");
    }

    public static final void interact() {
        // Generates a number in a custom range [min, max] (All Java versions)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press any key to spin");
        scanner.nextLine();
        runSlots();
    }
}