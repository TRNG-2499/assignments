/**
     * @param args the command line arguments
     * Java algorithm assignment 01 - Missing Number Finder
     * Objective: Practice iterating through an array and comparing its values against an expected range to detect a single missing value.
     * 1. Write a method that accepts a single parameter: an array of integers.
     * 2. The array will always contain all of the distinct integers from 1 to n, in some order, with exactly one value missing from that range (where n is one more than the length of the array).
     * 3. The method should return the single missing integer.
     * 4. You can assume the array will always have exactly one missing number — you do not need to handle the case of zero or multiple missing numbers.
*/

public class MissingNumberFinder {
    public static int findMissingNumber(int[] numbers) {
        int n = numbers.length + 1;
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args)  {
        int[] numbers = {8, 2, 1, 3, 4, 6, 5, 7, 10};
        int missingNumber = findMissingNumber(numbers);
        System.out.println("Missing number: " + missingNumber);
    }
}
