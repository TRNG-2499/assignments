import java.util.Arrays;
import java.util.Scanner;

public class ClosestValue {

    public static int findClosest(int[] numbers, int target) {
        if (numbers.length == 0) {
            return -1;
        }

        int best = numbers[0];
        int bestDistance = Math.abs(numbers[0] - target);

        for (int i = 1; i < numbers.length; i++) {
            int distance = Math.abs(numbers[i] - target);

            if (distance < bestDistance || (distance == bestDistance && numbers[i] < best)) {
                best = numbers[i];
                bestDistance = distance;
            }
        }

        return best;
    }

    // stretch goal 1
    public static int[] findClosestK(int[] numbers, int target, int k) {
        Integer[] sorted = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            sorted[i] = numbers[i];
        }

        Arrays.sort(sorted, (a, b) -> {
            int distanceA = Math.abs(a - target);
            int distanceB = Math.abs(b - target);
            if (distanceA != distanceB) {
                return distanceA - distanceB;
            }
            return a - b;
        });

        int size = Math.max(0, Math.min(k, numbers.length));
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = sorted[i];
        }

        return result;
    }

    // stretch goal 2
    public static int findFarthest(int[] numbers, int target) {
        if (numbers.length == 0) {
            return -1;
        }

        int best = numbers[0];
        int bestDistance = Math.abs(numbers[0] - target);

        for (int i = 1; i < numbers.length; i++) {
            int distance = Math.abs(numbers[i] - target);

            if (distance > bestDistance || (distance == bestDistance && numbers[i] < best)) {
                best = numbers[i];
                bestDistance = distance;
            }
        }

        return best;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numbers: ");
        String line = scanner.nextLine().trim();

        int[] numbers;
        if (line.isEmpty()) {
            numbers = new int[0];
        } else {
            String[] parts = line.split("\\s+");
            numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }
        }

        System.out.print("Enter target: ");
        int target = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter k: ");
        int k = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Closest: " + findClosest(numbers, target));
        System.out.println("Closest " + k + ": " + Arrays.toString(findClosestK(numbers, target, k)));
        System.out.println("Farthest: " + findFarthest(numbers, target));

        scanner.close();
    }
}