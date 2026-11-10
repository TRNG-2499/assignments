import java.util.Scanner;

public class Main {

    public static int rand(int x, int y) {
        double r = Math.random();
        return (int) (x + (y - x) * r);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Animal[] animals = {
            new Dog(),
            new Cat(),
            new Horse()
        };

        String exitString = "Goodbye! Thanks for visiting the zoo.";

        while (true) {
            for (int i = 0; i < animals.length; i++) {
                String out = String.format("%d. %s", i + 1, animals[i].name());
                System.out.println(out);
            }
            System.out.println("0. Exit");
            System.out.println("-1. Random");
            System.out.print("Enter your selection: ");

            int opt = scanner.nextInt();
            
            if (opt == -1) {
                opt = rand(1,4);
            }

            Animal animal = 0 < opt && opt <= animals.length ? animals[opt - 1] : null;

            if (opt == 0) {
                System.out.println(exitString);
                break;
            } else if (animal != null) {
                System.out.println(
                    String.format("%s\n%s%n", animal.makeSound(), animal.describe())
                );
            } else {
                System.out.println(
                    String.format("'%d' is not a valid selection. Please choose a number from the menu.", opt)
                );
            }
        }

        scanner.close();
    }
}
