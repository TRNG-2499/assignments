import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class solution {
    public static void main(String[] args) {

        // original test cases using elevatorStats
        System.out.println(elevatorStats(new int[]{150, 200, 300, 250, 180}, 1000));
        System.out.println(elevatorStats(new int[]{150, 200, 300}, 1000));
        System.out.println(elevatorStats(new int[]{200, 300}, 500));
        System.out.println(elevatorStats(new int[]{200, 300}, 100));
        System.out.println(elevatorStats(new int[]{}, 1000));

        System.out.println();

        // stretch goal 1 test cases using maxSafePassengers
        // in the first case, passengers 1-4 in order would hit 900 and 5 would overload,
        // but picking the lightest ones first still only fits 4
        // in the second case, the 600 lb passenger blocks everyone after them in line,
        // but skipping them lets the 3 lighter passengers all fit
        System.out.println(maxSafePassengers(new int[]{150, 200, 300, 250, 180}, 1000));
        System.out.println(maxSafePassengers(new int[]{600, 100, 150, 200}, 500));
        System.out.println(maxSafePassengers(new int[]{150, 200, 300}, 1000));
        System.out.println(maxSafePassengers(new int[]{200, 300}, 100));
        System.out.println(maxSafePassengers(new int[]{}, 1000));

        System.out.println();

        // stretch goal 2 test cases using heaviestAndLightest
        // in the first case passenger 5 causes the overload, so all 5 are considered
        // in the second case passenger 2 causes it, so passengers 3 and 4 (the 50 and 400) are ignored
        System.out.println(heaviestAndLightest(new int[]{150, 200, 300, 250, 180}, 1000));
        System.out.println(heaviestAndLightest(new int[]{200, 300, 50, 400}, 500));
        System.out.println(heaviestAndLightest(new int[]{150, 200, 300}, 1000));
        System.out.println(heaviestAndLightest(new int[]{}, 1000));

        System.out.println();

        // stretch goal 3 test cases using multipleTrips
        System.out.println(multipleTrips(new int[]{150, 200, 300, 250, 180}, 1000));
        System.out.println(multipleTrips(new int[]{200, 300, 100, 250, 150}, 500));
        System.out.println(multipleTrips(new int[]{150, 200, 300}, 1000));
        System.out.println(multipleTrips(new int[]{200, 600, 100}, 500));
        System.out.println(multipleTrips(new int[]{}, 1000));
    }


    public static String elevatorStats(int[] passengerWeights, int limit) {
        if (passengerWeights.length == 0) {
            return "No passengers aboard the elevator.";
        }

        int weightCounter = 0;
        int stepCounter = 1;


        for (int i = 0; i <= passengerWeights.length-1; i++) {
            weightCounter = passengerWeights[i] + weightCounter;
            if (weightCounter < limit) {
                stepCounter++;
            } else {
                return "Passenger " + stepCounter + " caused an overload. Total weight at that point: "+ weightCounter + " lbs.";
            }

        } return "All passengers boarded safely. Total weight: " + weightCounter + " lbs.";
    }

    // stretch goal 1: maximum safe passenger count
    // instead of stopping at the first overload, this finds the most passengers from the array
    // that could fit without meeting or exceeding the limit
    // the passengers dont have to board in their original order here, so the lightest ones are picked first,
    // since filling up with the lightest people always leaves the most room for more people

    public static String maxSafePassengers(int[] passengerWeights, int limit) {
        if (passengerWeights.length == 0) {
            return "No passengers aboard the elevator.";
        }

        // making a copy before sorting so the original array passed in doesnt get rearranged
        int[] sortedWeights = Arrays.copyOf(passengerWeights, passengerWeights.length);
        Arrays.sort(sortedWeights);

        int weightCounter = 0;
        int safeCount = 0;

        // going from lightest to heaviest, each passenger is only added if they keep the total under the limit
        // once one doesnt fit, nobody after them will either since everyone after is the same weight or heavier
        for (int i = 0; i < sortedWeights.length; i++) {
            if (weightCounter + sortedWeights[i] < limit) {
                weightCounter = weightCounter + sortedWeights[i];
                safeCount++;
            } else {
                break;
            }
        }

        // listing out which weights made it on so the result can be checked
        String boardedWeights = "";

        for (int i = 0; i < safeCount; i++) {
            boardedWeights = boardedWeights + sortedWeights[i];
            if (i < safeCount - 1) {
                boardedWeights = boardedWeights + ", ";
            }
        }

        if (safeCount == 0) {
            return "No passengers can board safely. Even the lightest passenger meets or exceeds the limit.";
        }

        return "Maximum safe passengers: " + safeCount + " of " + passengerWeights.length + ". Weights boarded: [" + boardedWeights + "]. Total weight: " + weightCounter + " lbs.";
    }

    // stretch goal 2: heaviest and lightest passengers
    // reports the original elevatorStats result, plus the heaviest and lightest weights
    // if there was an overload, only passengers up to and including the one who caused it are looked at
    // if there was no overload, every passenger is looked at

    public static String heaviestAndLightest(int[] passengerWeights, int limit) {

        // reusing the original method for the main result instead of rewriting the message logic
        String originalResult = elevatorStats(passengerWeights, limit);

        if (passengerWeights.length == 0) {
            return originalResult;
        }

        int weightCounter = 0;

        // starting heaviest and lightest at the first passenger since they always board
        int heaviest = passengerWeights[0];
        int lightest = passengerWeights[0];

        // same boarding loop as elevatorStats, but tracking heaviest and lightest as each passenger gets on
        // the loop stops right after the passenger who causes the overload, so later passengers are never counted
        for (int i = 0; i < passengerWeights.length; i++) {
            int weight = passengerWeights[i];
            weightCounter = weightCounter + weight;

            if (weight > heaviest) {
                heaviest = weight;
            } if (weight < lightest) {
                lightest = weight;
            }

            if (weightCounter >= limit) {
                break;
            }
        }

        return originalResult + " Heaviest passenger: " + heaviest + " lbs. Lightest passenger: " + lightest + " lbs.";
    }

    // stretch goal 3: multiple elevator trips
    // groups the passengers into trips in their original order, without any trip meeting or exceeding the limit
    // each passenger gets added to the current trip if they fit, otherwise the current trip leaves
    // and that passenger starts the next one

    public static String multipleTrips(int[] passengerWeights, int limit) {
        if (passengerWeights.length == 0) {
            return "No passengers aboard the elevator.";
        }

        // if any one passenger meets or exceeds the limit alone, they can never ride
        // so no amount of trips will work and the whole thing is reported as impossible
        for (int i = 0; i < passengerWeights.length; i++) {
            if (passengerWeights[i] >= limit) {
                return "Trips cannot be planned. Passenger " + (i + 1) + " (" + passengerWeights[i] + " lbs) meets or exceeds the limit alone.";
            }
        }

        int tripCount = 1;
        int tripWeight = 0; // running total for the current trip only, resets each new trip
        String tripLog = "Trip 1: ";
        boolean firstOnTrip = true; // used to only put commas between passengers on the same trip

        for (int i = 0; i < passengerWeights.length; i++) {
            int weight = passengerWeights[i];

            // if this passenger would push the current trip to or over the limit,
            // the current trip is finished and a new one is started with this passenger
            if (tripWeight + weight >= limit) {
                tripLog = tripLog + " (" + tripWeight + " lbs)";
                tripCount++;
                tripWeight = 0;
                tripLog = tripLog + "\nTrip " + tripCount + ": ";
                firstOnTrip = true;
            }

            if (!firstOnTrip) {
                tripLog = tripLog + ", ";
            }

            // passengers are reported starting from 1, same as elevatorStats
            tripLog = tripLog + "Passenger " + (i + 1);
            tripWeight = tripWeight + weight;
            firstOnTrip = false;
        }

        // closing out the last trip with its total since the loop ends before it gets one
        tripLog = tripLog + " (" + tripWeight + " lbs)";

        return "Trips required: " + tripCount + "\n" + tripLog;
    }
}