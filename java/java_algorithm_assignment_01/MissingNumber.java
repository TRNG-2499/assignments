import java.util.Scanner;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println("Missing Number Finder");

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the numbers: ");
            int[] numbers = parseNumbers(scanner.nextLine());

            System.out.println("Missing number: " + findMissing(numbers));

            System.out.print("Enter a start value for the custom range: ");
            int start = Integer.parseInt(scanner.nextLine().trim());

            System.out.println("Missing number from " + start + ": "+ findMissingFromStart(numbers, start));

        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    // Base requirement
    public static int findMissing(int[] numbers) {
        int n = numbers.length + 1;
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int number : numbers) {
            actualSum += number;
        }
        return expectedSum - actualSum;
    }

    // Stretch goal 1
    public static int findMissingFromStart(int[] numbers, int start) {
        int end = start + numbers.length;
        int expectedSum = (numbers.length + 1) * (start + end) / 2;

        int actualSum = 0;
        for (int number : numbers) {
            actualSum += number;
        }
        return expectedSum - actualSum;
    }
    private static int[] parseNumbers(String line) {
        String inner = line.replace("[", "").replace("]", "").trim();
        if (inner.isEmpty()) {
            return new int[0];
        }
        String[] parts = inner.split("\\s*,\\s*");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        return numbers;
    }
}