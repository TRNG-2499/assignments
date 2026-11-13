import java.util.Arrays;

// Author: Tyler Pyrzenski 

public class solution {
    public static void main(String[] args) {

        // original test cases using findMissingNumber
        System.out.println(findMissingNumber(new int[]{1, 2, 3, 4, 5, 6, 8, 9}));
        System.out.println(findMissingNumber(new int[]{13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1}));
        System.out.println(findMissingNumber(new int[]{3, 7, 1, 2, 8, 4, 5}));

        System.out.println();

        // stretch goal 1 test cases using findMissingNumberFromStart
        System.out.println(findMissingNumberFromStart(new int[]{5, 6, 8, 9}, 5));
        System.out.println(findMissingNumberFromStart(new int[]{22, 20, 24, 21}, 20));
        System.out.println(findMissingNumberFromStart(new int[]{3, 7, 1, 2, 8, 4, 5}, 1));

        System.out.println();

        // stretch goal 2 test cases using findTwoMissingNumbers
        // Arrays.toString is used so the array prints its values instead of its memory address
        System.out.println(Arrays.toString(findTwoMissingNumbers(new int[]{1, 2, 4, 6})));
        System.out.println(Arrays.toString(findTwoMissingNumbers(new int[]{7, 3, 1, 5, 6})));
        System.out.println(Arrays.toString(findTwoMissingNumbers(new int[]{2, 3, 4, 5})));

        System.out.println();

        // stretch goal 3 test cases using findMissingAndDuplicate
        // the returned array holds the duplicate first, then the missing value
        int[] result1 = findMissingAndDuplicate(new int[]{1, 2, 2, 4});
        System.out.println("Duplicate: " + result1[0] + ", Missing: " + result1[1]);

        int[] result2 = findMissingAndDuplicate(new int[]{3, 1, 5, 5, 2});
        System.out.println("Duplicate: " + result2[0] + ", Missing: " + result2[1]);

        int[] result3 = findMissingAndDuplicate(new int[]{2, 2});
        System.out.println("Duplicate: " + result3[0] + ", Missing: " + result3[1]);
    }

    public static int findMissingNumber(int[] input) {
        int fullTotal = 0;
        int arrayTotal = 0;
        int finalTotal = 0;


        for (int i = 0; i < input.length; i++) {

            arrayTotal = arrayTotal + input[i];

        }

        for (int i = 1; i < input.length + 2; i++) {
            fullTotal = fullTotal + i;
        }

        finalTotal = fullTotal - arrayTotal;


        return finalTotal;
    }

    // stretch goal 1: custom starting value
    // same idea as findMissingNumber, but the range starts at start instead of always 1
    // the array has one number missing, so the full range has input.length + 1 numbers in it,
    // which means it runs from start up to start + input.length

    public static int findMissingNumberFromStart(int[] input, int start) {
        int fullTotal = 0;
        int arrayTotal = 0;
        int finalTotal = 0;

        // what we actually have, every number in the array added up
        for (int i = 0; i < input.length; i++) {
            arrayTotal = arrayTotal + input[i];
        }

        // what we should have, counting from start up to and including the last number in the range
        int end = start + input.length;

        for (int i = start; i <= end; i++) {
            fullTotal = fullTotal + i;
        }

        // the only number left over after subtracting is the missing one
        finalTotal = fullTotal - arrayTotal;

        return finalTotal;
    }

    // stretch goal 2: two missing numbers
    // the subtraction trick from findMissingNumber only gives the sum of the two missing numbers,
    // not which two they are, so this uses a checklist instead
    // a boolean array has one slot for every number from 1 to n, and each number in the input
    // checks off its slot, so whatever slots are still unchecked at the end are the missing ones

    public static int[] findTwoMissingNumbers(int[] input) {

        // two numbers are missing, so the full range has two more numbers than the array
        int n = input.length + 2;

        // size n + 1 so the slots line up with the numbers directly, slot 3 is for the number 3
        // slot 0 is never used since the range starts at 1
        // every slot starts as false (not seen yet)
        boolean[] seen = new boolean[n + 1];

        // checking off every number that is in the array
        for (int i = 0; i < input.length; i++) {
            seen[input[i]] = true;
        }

        int[] missing = new int[2];
        int found = 0; // keeps track of which spot in missing to fill next

        // going through every number from 1 to n, any slot that wasnt checked off is missing
        // since this goes from smallest to largest, the results come out in ascending order automatically
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                missing[found] = i;
                found++;
            }
        }

        return missing;
    }

    // stretch goal 3: missing and duplicate
    // the array has the same length as the range 1 to n, but one number shows up twice and another not at all
    // instead of true/false, each slot keeps a count of how many times that number showed up
    // a count of 2 is the duplicate, and a count of 0 is the missing number
    // returns an array with the duplicate first and the missing value second

    public static int[] findMissingAndDuplicate(int[] input) {

        // nothing is missing from the length here, so n is just the length of the array
        int n = input.length;

        // same slot setup as findTwoMissingNumbers, slot 3 counts the number 3
        // every slot starts at 0
        int[] counts = new int[n + 1];

        // adding 1 to the slot for every number that shows up
        for (int i = 0; i < input.length; i++) {
            counts[input[i]]++;
        }

        int duplicate = 0;
        int missing = 0;

        // checking every slot from 1 to n for the one that showed up twice and the one that never showed up
        for (int i = 1; i <= n; i++) {
            if (counts[i] == 2) {
                duplicate = i;
            } else if (counts[i] == 0) {
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }
}
