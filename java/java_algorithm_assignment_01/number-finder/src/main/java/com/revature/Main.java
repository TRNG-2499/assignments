package com.revature;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // each part takes a differently shaped array, so each one asks for its own input
        System.out.print("Enter numbers from 1 to n with one missing (separated by spaces): ");
        int[] numbers = readNumbers(scanner);
        System.out.println("Missing number: " + findMissingNumber(numbers));

        System.out.println();
        System.out.println("-----Stretch Goal 1-----");
        // stretch goal 1
        System.out.print("Enter the starting value: ");
        int start = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Enter numbers from " + start + " up with one missing (separated by spaces): ");
        int[] startNumbers = readNumbers(scanner);
        System.out.println("Missing number: " + findMissingNumberFromStart(startNumbers, start));

        System.out.println();
        System.out.println("-----Stretch Goal 2-----");
        // stretch goal 2
        System.out.print("Enter numbers from 1 to n with two missing (separated by spaces): ");
        int[] twoMissingNumbers = readNumbers(scanner);
        System.out.println("Missing numbers: " + Arrays.toString(findTwoMissingNumbers(twoMissingNumbers)));

        System.out.println();
        System.out.println("-----Stretch Goal 3-----");
        // stretch goal 3
        System.out.print("Enter numbers from 1 to n with one duplicate and one missing (separated by spaces): ");
        int[] duplicateNumbers = readNumbers(scanner);
        int[] result = findDuplicateAndMissing(duplicateNumbers);
        System.out.println("Duplicate: " + result[0] + ", Missing: " + result[1]);

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
    public static int findMissingNumber(int[] numbers) {
        // n is one more than the length since one number is missing
        int n = numbers.length + 1;
        // the sum of 1 to n minus the sum of the array leaves only the missing number
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int number : numbers) {
            actualSum += number;
        }
        return expectedSum - actualSum;
    }

    // stretch goal 1
    public static int findMissingNumberFromStart(int[] numbers, int start) {
        int end = start + numbers.length;
        // same idea as the normal solution, but the range starts at start instead of 1
        int expectedSum = (start + end) * (end - start + 1) / 2;

        int actualSum = 0;
        for (int number : numbers) {
            actualSum += number;
        }
        return expectedSum - actualSum;
    }

    // stretch goal 2
    public static int[] findTwoMissingNumbers(int[] numbers) {
        int n = numbers.length + 2;
        // index i is true once i shows up in the array, index 0 is unused
        boolean[] seen = new boolean[n + 1];
        for (int number : numbers) {
            seen[number] = true;
        }

        // checking 1 to n in order means the missing numbers come out ascending
        int[] missing = new int[2];
        int found = 0;
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                missing[found] = i;
                found++;
            }
        }
        return missing;
    }

    // stretch goal 3
    // returns {duplicate, missing}
    public static int[] findDuplicateAndMissing(int[] numbers) {
        int n = numbers.length;
        boolean[] seen = new boolean[n + 1];

        int duplicate = 0;
        for (int number : numbers) {
            if (seen[number]) {
                duplicate = number;
            }
            seen[number] = true;
        }

        int missing = 0;
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                missing = i;
            }
        }
        return new int[] { duplicate, missing };
    }
}
