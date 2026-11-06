import java.util.InputMismatchException;
import java.util.Scanner;

public class State {
  public State() {
    total = 0;
    scanner = new Scanner(System.in);
  }

  public String getNextString() {
    return scanner.next();
  }

  public int getNextInt() {
    while (true) {
      try {
        return scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Please enter a number.");
      }
    }
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public void close() {
    scanner.close();
  }

  private int total;
  private Scanner scanner;
}
