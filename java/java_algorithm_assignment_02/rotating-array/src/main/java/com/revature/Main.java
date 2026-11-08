package com.revature;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numbers (separated by spaces): ");
        int[] numbers = readNumbers(scanner);
        System.out.print("Enter the number of steps to rotate: ");
        int k = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Rotated right: " + Arrays.toString(rotateRight(numbers, k)));

        System.out.println();
        System.out.println("-----Stretch Goal 1-----");
        // stretch goal 1
        System.out.println("Rotated left: " + Arrays.toString(rotateLeft(numbers, k)));

        System.out.println();
        System.out.println("-----Stretch Goal 2-----");
        // stretch goal 2
        System.out.print("Enter the number of steps to rotate (negative rotates left): ");
        int signedK = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Rotated: " + Arrays.toString(rotateSigned(numbers, signedK)));

        System.out.println();
        System.out.println("-----Stretch Goal 3-----");
        // stretch goal 3
        // runs last because it changes the original array instead of returning a new one
        rotateRightInPlace(numbers, k);
        System.out.println("Rotated right in place: " + Arrays.toString(numbers));

        scanner.close();
    }

    public static int[] readNumbers(Scanner scanner) {
        // split on any run of spaces so double spaces don't create empty entries
        String[] parts = scanner.nextLine().trim().split("\\s+");

        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        return numbers;
    }

    // normal solution
    public static int[] rotateRight(int[] array, int k) {
        int n = array.length;
        // an empty array has nothing to rotate, and % 0 would throw
        if (n == 0) {
            return array;
        }
        // rotating by the array's length gives the same array back, so only the remainder matters
        k = k % n;

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            // each element moves k spots right, wrapping back to the start past the end
            result[(i + k) % n] = array[i];
        }
        return result;
    }

    // stretch goal 1
    public static int[] rotateLeft(int[] array, int k) {
        int n = array.length;
        if (n == 0) {
            return array;
        }
        k = k % n;

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            // each spot takes the element k spots to its right
            result[i] = array[(i + k) % n];
        }
        return result;
    }

    // stretch goal 2
    public static int[] rotateSigned(int[] array, int k) {
        int n = array.length;
        if (n == 0) {
            return array;
        }
        // in Java -7 % 5 is -2, so adding n and taking % again turns any k into a right rotation from 0 to n - 1
        // e.g. -7 on 5 elements becomes 3 right, which is the same as 2 left
        int rightSteps = ((k % n) + n) % n;
        return rotateRight(array, rightSteps);
    }

    // stretch goal 3
    public static void rotateRightInPlace(int[] array, int k) {
        int n = array.length;
        if (n == 0) {
            return;
        }
        k = k % n;

        // reversing the whole array puts the last k elements at the front but backwards,
        // so reversing each part again puts them back in order
        // e.g. [1, 2, 3, 4, 5], k = 2 -> [5, 4, 3, 2, 1] -> [4, 5, 3, 2, 1] -> [4, 5, 1, 2, 3]
        reverse(array, 0, n - 1);
        reverse(array, 0, k - 1);
        reverse(array, k, n - 1);
    }

    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
