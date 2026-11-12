import java.util.Arrays;

public class Solution_02 {

  public static void main(String[] args) {
    System.out.println(waitLimitChecker(850));
    System.out.println(waitLimitChecker(300, 325, 150, 200));
    System.out.println(waitLimitChecker(700, 180, 250, 290, 120, 150));
    System.out.println(waitLimitChecker(950, 125, 210, 300, 315, 100));
    System.out.println(waitLimitChecker(1200, 175, 220, 185, 240, 195));

    System.out.println(maxPass(650, 180, 240, 125, 310, 95));
    System.out.println(maxPass(400, 450, 520, 475));
    System.out.println(maxPass(900, 150, 200, 175, 225, 140));
    System.out.println(maxPass(500, 250, 125, 200, 175, 100));
  }

  public static String waitLimitChecker(double weightLimit, double... weight) {
    // no passengers
    if (weight.length == 0) {
      return "No Passengers waiting to ride";
    }
    // first passenger exceeds weight limit
    if (weightLimit <= weight[0]) {
      return (
        "Passenger 1 meets or exceeds the weight limit please try again without that passenger. Total weight of " +
        weight[0]
      );
    }

    int linePosition = 1;
    double totalWeight = 0;

    // loop passengers stopping when weight limit has been exceeded returning values
    for (int i = 0; i < weight.length; i++) {
      totalWeight = totalWeight + weight[i];
      if (weightLimit <= totalWeight) {
        return (
          "No further passengers. Passenger " +
          linePosition +
          " would cause and overload with a total weight of " +
          totalWeight
        );
      }
      linePosition++;
    }

    return (
      "All passengers boarded safely with a total weight of " + totalWeight
    );
  }

  public static String maxPass(double weightLimit, double... weight) {
    Arrays.sort(weight);
    int passCount = 0;
    // no passengers
    if (weight.length == 0) {
      return "No Passengers waiting to ride";
    }

    // First passenger exceeds weight limit
    if (weightLimit <= weight[0]) {
      return "Maximum safe passengers: " + passCount;
    }

    passCount = 1;
    double totalWeight = weight[0];

    for (int i = 1; i < weight.length; i++) {
      if (totalWeight + weight[i] >= weightLimit) {
        return "Maximum safe passengers: " + passCount;
      }

      totalWeight = totalWeight + weight[i];
      passCount++;
    }

    return "Maximum safe passengers: " + passCount;
  }

  // Heaviest and Lightest Passengers — Alongside your original result, also determine and report the heaviest and lightest passenger weights.
  // If an overload occurred, only consider the passengers who boarded before (and including) the one who caused the overload;
  // if no overload occurred, consider all passengers.

  // Multiple Elevator Trips — Given the full list of passengers and the weight limit, group the passengers into consecutive trips, preserving their original order,
  // such that no single trip's total weight meets or exceeds the limit. Report how many trips are required and which passengers ride on each trip.
}
