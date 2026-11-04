import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int limit = Integer.parseInt(args[0]);
    int[] passengers = new int[args.length - 1];
    for (int i = 0; i < args.length - 1; i++) {
      passengers[i] = Integer.parseInt(args[i + 1]);
    }

    checkWeightLimit(limit, passengers);
    checkWeightLimitMaxPassengers(limit, passengers);
  }

  private static int checkWeightLimit(int limit, int[] passengers) {
    return checkWeightLimit(limit, passengers, true);
  }

  private static int checkWeightLimit(int limit, int[] passengers, boolean print) {
    int currentWeight = 0;
    for (int i = 0; i < passengers.length; i++) {
      currentWeight += passengers[i];

      if (currentWeight >= limit) {
        if (print) {
          System.out.printf("Weight limit exceeded at passenger %d with a total weight of %d.%n", i + 1, currentWeight);
        }
        return i;
      }
    }

    if (currentWeight < limit) {
      if (print) {
        System.out.printf("All passengers boarded safely with a total weight of %d.%n", currentWeight);
      }
      return passengers.length;
    }

    return passengers.length - 1;
  }

  private static void checkWeightLimitMaxPassengers(int limit, int[] passengers) {
    Arrays.sort(passengers);

    int failIndex = checkWeightLimit(limit, passengers, false);

    if (failIndex == passengers.length) {
      System.out.println("All passengers boarded safely.");
    } else {
      System.out.printf("Only %d passengers can board safely.%n", failIndex);
    }
  }
}
