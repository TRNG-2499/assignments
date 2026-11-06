package javaAssignments.algorithms01;
import java.util.HashSet;
import java.util.Set;

public class missing_number {
    
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 8, 7, 10}; // Example array with a missing number
        int missingNumber = findMissingNumber(numbers);
        System.out.println("Missing number: " + missingNumber);

        int[] numbersWithStart = {4, 5, 6, 8, 7, 9}; // Example array with a missing number and a custom start point
        int missingNumberWithStart = findMissingNumberWithStart(numbersWithStart, 4);
        System.out.println("Missing number with start: " + missingNumberWithStart);


        int[] numbersWithTwoMissing = {1, 2, 3, 5, 6, 8, 7, 10, 11, 12, 13, 4}; // Example array with two missing numbers
        int[] missingNumbers = findMissingNumbers(numbersWithTwoMissing);
        System.out.println("Missing numbers: " + missingNumbers[0] + " and " + missingNumbers[1]);

        int[] numbersWithMissingAndDuplicate = {1, 2, 3, 4, 5, 6, 8, 7, 10, 11, 12, 13, 3}; // Example array with a missing number and a duplicate number
        int[] missingAndDuplicate = findMissingAndDuplicateNumber(numbersWithMissingAndDuplicate);
        System.out.println("Missing number: " + missingAndDuplicate[0] + ", Duplicate number: " + missingAndDuplicate[1]);
    }

    //the array will be a set of numbers that will contain all numbers from 1 to n except one missing number
    public static int findMissingNumber(int[] numbers) { 
        int n = numbers.length + 1;
        int sum = n * (n + 1) / 2; //this formula was recommended automatically and after a bit of math i'm fairly certain it works regardless of scale
        for (int number : numbers) {
            sum -= number;
        }
        return sum;
    }

    //an array with a custom "start" point
    public static int findMissingNumberWithStart(int[] numbers, int start) {
        int n = numbers.length; //not adding one, our start point does not start at 0.
        int sum = ((n + start) * (n + start + 1) / 2);  //Adding start to the equation from above to compensate for missing numbers.
        //System.out.println(sum);  //TEST STATEMENT                                 
        for (int number : numbers) {                             
            sum -= number;
        }
        sum -= (start - 1) * start / 2; //removing the sum of numbers before the start point.
        return sum;
    }

    //array missing 2 numbers
    public static int[] findMissingNumbers(int[] numbers) {
        int n = numbers.length + 2;
        int sum = n * (n + 1) / 2; //this gives us the sum of all numbers from 1 to n;
        for (int number : numbers) {
            sum -= number;
        }
        //now sum is two missing numbers combined
        int[] missingNumbers = new int[2]; //since all our missing numbers must be unique, we are not at risk of duplicate entries.
        for (int i = 1; i <= n; i++) {
            int otherMissingNumber = sum - i;
            if (otherMissingNumber > 0 //check if the other missing number is positive
                    && areBothMissing(numbers, i, otherMissingNumber)) {
                missingNumbers[0] = i;
                missingNumbers[1] = otherMissingNumber;
                break;
            }
        }
        return missingNumbers;
    }

    //ended up making a second method to call instead of writing it into the main method
    private static boolean areBothMissing(int[] numbers, int first, int second) {
        for (int number : numbers) { //iterates through the list to look for the numbers
            if (number == first || number == second) { //if either are found, return false
                return false;
            }
        }
        return true;
    }


    //missing number and a duplicate number
    public static int[] findMissingAndDuplicateNumber(int[] numbers) {
        int dupe = -1;
        Set<Integer> cleaned = new HashSet<>();
        for (int number : numbers) {
            if (cleaned.contains(number)) {
                dupe = number;
            } else {
                cleaned.add(number);
            }
        }
        int missing = findMissingNumber(cleaned.stream().mapToInt(Integer::intValue).toArray());
        return new int[]{missing, dupe};
    }
}
