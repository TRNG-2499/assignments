import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

    public static void main(String[] args) {
        System.out.println("Rotate Array");

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the numbers: ");
            int[] numbers = parseNumbers(scanner.nextLine());

            System.out.print("Enter k: ");
            int k = Integer.parseInt(scanner.nextLine().trim());

            System.out.println();
            if (k >= 0) {
                System.out.println("Rotate right: " + Arrays.toString(rotateRight(numbers, k)));
            }
            else{
            System.out.println("Negative rotate: " + Arrays.toString(rotateWithNegative(numbers, k)));
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    // Base requirement
    public static int[] rotateRight(int[] array, int k) {
        int n = array.length;
        if (n == 0) {
            return new int[0];
        }
        k = k % n;

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = array[i];
        }
        return result;
    }

    // Stretch goal 2
    public static int[] rotateWithNegative(int[] array, int k) {
        int n = array.length;
        if (n == 0) {
            return new int[0];
        }
        int steps = ((k % n) + n) % n;
        return rotateRight(array, steps);
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