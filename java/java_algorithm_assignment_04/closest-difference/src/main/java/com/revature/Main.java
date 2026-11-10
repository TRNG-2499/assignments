package com.revature;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an array of positive numbers: ");
        int[] numbers = readNumbers(scanner);
        System.out.print("Enter the target number: ");
        int target = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Closest value: " + findClosestValue(numbers, target));

        System.out.println();
        System.out.println("-----Stretch Goal 1-----");
        // stretch goal 1
        System.out.print("How many closest values do you want: ");
        int k = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Closest " + k + " values: " + Arrays.toString(findClosestKValues(numbers, target, k)));

        System.out.println();
        System.out.println("-----Stretch Goal 2-----");
        // stretch goal 2
        System.out.println("Farthest value: " + findFarthestValue(numbers, target));

        System.out.println();
        System.out.println("-----Stretch Goal 3-----");
        // stretch goal 3
        System.out.println("Closest value, ties go lower: " + findClosestValueWithTieBreak(numbers, target, false));
        System.out.println("Closest value, ties go higher: " + findClosestValueWithTieBreak(numbers, target, true));

        scanner.close();
    }

    public static int[] readNumbers(Scanner scanner) {
        String line = scanner.nextLine().trim();
        // a blank line would split into one empty entry, so treat it as an empty array instead
        if (line.isEmpty()) {
            return new int[0];
        }

        // split on any run of spaces so double spaces don't create empty entries
        String[] parts = line.split("\\s+");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        return numbers;
    }

    // normal solution
    public static int findClosestValue(int[] numbers, int target) {
        // the array only holds positive numbers, so -1 can mean nothing was found
        if (numbers.length == 0) {
            return -1;
        }

        // the first number is the closest so far until something beats it
        int closest = numbers[0];
        int closestDifference = Math.abs(numbers[0] - target);
        for (int i = 1; i < numbers.length; i++) {
            int difference = Math.abs(numbers[i] - target);
            // on a tie, only switch if the new number is smaller
            if (difference < closestDifference || (difference == closestDifference && numbers[i] < closest)) {
                closest = numbers[i];
                closestDifference = difference;
            }
        }
        return closest;
    }

    // stretch goal 1
    public static int[] findClosestKValues(int[] numbers, int target, int k) {
        // can't return more values than the array has, or fewer than none
        k = Math.max(0, Math.min(k, numbers.length));

        // Integer[] instead of int[] because Arrays.sort only takes custom ordering rules for objects
        Integer[] sorted = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            sorted[i] = numbers[i];
        }

        // order by distance from the target, and by the smaller value when two are equally close,
        // so the first k entries are the k closest values
        Arrays.sort(sorted, (a, b) -> {
            int differenceA = Math.abs(a - target);
            int differenceB = Math.abs(b - target);
            if (differenceA != differenceB) {
                return differenceA - differenceB;
            }
            return a - b;
        });

        int[] closest = new int[k];
        for (int i = 0; i < k; i++) {
            closest[i] = sorted[i];
        }
        return closest;
    }

    // stretch goal 2
    public static int findFarthestValue(int[] numbers, int target) {
        if (numbers.length == 0) {
            return -1;
        }

        // same as the normal solution, but a bigger difference wins instead of a smaller one
        int farthest = numbers[0];
        int farthestDifference = Math.abs(numbers[0] - target);
        for (int i = 1; i < numbers.length; i++) {
            int difference = Math.abs(numbers[i] - target);
            if (difference > farthestDifference || (difference == farthestDifference && numbers[i] < farthest)) {
                farthest = numbers[i];
                farthestDifference = difference;
            }
        }
        return farthest;
    }

    // stretch goal 3
    public static int findClosestValueWithTieBreak(int[] numbers, int target, boolean preferHigher) {
        if (numbers.length == 0) {
            return -1;
        }

        int closest = numbers[0];
        int closestDifference = Math.abs(numbers[0] - target);
        for (int i = 1; i < numbers.length; i++) {
            int difference = Math.abs(numbers[i] - target);
            // only the tie rule changes: true keeps the larger value, false keeps the smaller one
            boolean winsTie = preferHigher ? numbers[i] > closest : numbers[i] < closest;
            if (difference < closestDifference || (difference == closestDifference && winsTie)) {
                closest = numbers[i];
                closestDifference = difference;
            }
        }
        return closest;
    }
}
