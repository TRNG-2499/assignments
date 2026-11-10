import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Menu {

  private int userInput;
  private boolean running = true;
  private Scanner scanner = new Scanner(System.in);
  private Random random = new Random();

  public void start() {
    menuLoop();
  }

  private void menuLoop() {
    while (running) {
      printMenu();
      if (!inputValid()) continue;
      switch (userInput) {
        case 1 -> animalCall(new Dog());
        case 2 -> animalCall(new Cat());
        case 3 -> animalCall(new Bird());
        case 4 -> surpriseMe();
        case 0 -> exit();
        default -> System.out.println(
          userInput + " - is not a number between 0 - 4.\n"
        );
      }
    }
  }

  private void printMenu() {
    String menu = """
      Please enter a number from 0 to 4.
        1. Dog
        2. Cat
        3. Bird
        4. Surprise Me
        0. Exit \n""";
    System.out.println(menu);
  }

  private boolean inputValid() {
    try {
      System.out.println("Enter your selection: ");
      userInput = scanner.nextInt();
      return true;
    } catch (InputMismatchException e) {
      System.out.println("Not a valid input - Must be a number!\n");
      scanner.next();
      return false;
    }
  }

  private void exit() {
    scanner.close();
    System.out.println("Have a great day!!!");
    running = false;
  }

  private void animalCall(Animal animalType) {
    animalType.makeSound();
    animalType.describe();
  }

  private void surpriseMe() {
    switch (random.nextInt(1, 3)) {
      case 1 -> animalCall(new Dog());
      case 2 -> animalCall(new Cat());
      case 3 -> animalCall(new Bird());
    }
  }
}
