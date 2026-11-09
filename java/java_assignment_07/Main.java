import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int choice = 1;
    while (choice != 0) {
      try {
        Animal.printInstructions();
        choice = s.nextInt();
        Animal a = Animal.lookupAnimal(choice);
        if (a != null) {
          System.out.printf("%n%s!%nThe %s %s.%n%n", a.makeSound(), a.getNameLowercase(), a.describe());
        } else if (choice != 0) {
          System.out.printf("%nThat number was not associated with an animal. Please try again.%n%n");
        }
      } catch (InputMismatchException e) {
        System.out.printf("%nThat was not a valid number. Please try again.%n%n");
        s.next();
      }
    }

    s.close();
  }
}
