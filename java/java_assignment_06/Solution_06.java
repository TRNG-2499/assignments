import java.util.Scanner;
import java.util.Set;

public class Solution_06 {

  private int total = 0;
  private String command;
  private int value;
  private Set<String> noArgOptions = Set.of("reset", "total", "exit");
  private Set<String> argOptions = Set.of("add", "subtract");

  public void startCalc() {
    runningLoop();
  }

  // running loop
  private void runningLoop() {
    boolean running = true;
    Scanner scanner = new Scanner(System.in);

    while (running) {
      prompt();
      String input = scanner.nextLine();

      if (!sanitizeText(input)) continue;

      switch (command) {
        case "add" -> add(value);
        case "subtract" -> subtract(value);
        case "reset" -> reset();
        case "total" -> printTotal();
        case "exit" -> running = exit(scanner);
      }
    }
  }

  // add
  private void add(int toAdd) {
    total += toAdd;
    System.out.println("Added " + toAdd + ". Running total: " + total);
  }

  // subtract
  private void subtract(int toSubtract) {
    total -= toSubtract;
    System.out.println(
      "Subtracted " + toSubtract + ". Running total: " + total
    );
  }

  // reset
  private void reset() {
    total = 0;
    System.out.println("Running total has been reset to 0");
  }

  // total
  private void printTotal() {
    System.out.println("Current total: " + total);
  }

  // exit
  private boolean exit(Scanner scanner) {
    System.out.println("Goodbye! Final total: " + total);
    scanner.close();
    return false;
  }

  private void prompt() {
    String promptString = """
      **************************************************************************
      Enter a command:
      add [number]          - adds the given number to the running total.
      subtract [number]     - subtracts the given number from the running total.
      reset                 - resets the running total.
      total                 - prints the current running value.
      exit                  - ends the program
      **************************************************************************
      """;
    System.out.println(promptString);
  }

  private boolean sanitizeText(String input) {
    if (input == null || input.isBlank()) {
      System.out.println("Input cannot be empty please try again");
      return false;
    }

    String[] splitInput = input.split("\\s+");
    splitInput[0] = splitInput[0].toLowerCase();

    if (
      !noArgOptions.contains(splitInput[0]) &&
      !argOptions.contains(splitInput[0])
    ) {
      System.out.println(
        "\"" + splitInput[0] + "\" - is not a valid command, Please try again."
      );
      return false;
    }

    if (noArgOptions.contains(splitInput[0])) {
      if (splitInput.length != 1) {
        System.out.println(
          "This command does not take a second argument, Please try again"
        );
        return false;
      }
    }
    if (argOptions.contains(splitInput[0])) {
      if (splitInput.length != 2) {
        System.out.println(
          "This command requires only one argument, Please try again"
        );
        return false;
      }
      try {
        value = Integer.parseInt(splitInput[1]);
      } catch (NumberFormatException e) {
        System.out.println("This command requires a whole number.");
        return false;
      }
    }
    command = splitInput[0];
    return true;
  }
}
