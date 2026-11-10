package assignments.java.java_algorithm_assignment_01;
import java.util.Arrays;

public class MissingNumberFinder {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    // Finds the missing number in an array with a custom starting value.
    public static int findMissingNumber(int[] arr, int start) {
        int n = arr.length + 1;
        int expectedSum = (start + (start + n - 1)) * n / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
    // find two missing numbers where n is two more than length of array. Return both in ascending order.
    public static int[] findTwoMissingNumbers(int[] arr) {
        int n = arr.length + 2;
        int totalSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        int sumOfMissing = totalSum - actualSum;
        int[] result = new int[2];
        for (int i = 1; i <=n; i++) {
            boolean found = false;
            for (int num : arr) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                if (result[0] == 0) {
                    result[0] = i;
                } else {
                    result[1] = i;
                }
            }
        }
        return result;
    }
    /*
    * method for missing and duplicate number
    intialize counter to track occurrences of each number and find duplicate
    return the duplicate and the missing number
    
    */
    public static int[] findMissingAndDuplicate(int[] arr) {
        int n = arr.length;
        int duplicate = 0;
        int missing = 0;
        
        for (int i = 1; i <= n; i++) {
            //create counter for how many times i appears
            int count = 0;
            for (int num : arr) {
                if (num == i) {
                    count++;
                }
            }
            if (count == 0) {
                missing = i;
            } else if (count > 1) {
                duplicate = i;
            }

            //loop through array and update counter
            //use count to decide if i is missing or duplicate, or neither
        }
        return new int[]{duplicate, missing};
    }
    
    
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 2, 8, 4, 5};
        System.out.println(findMissingNumber(arr));
        int[] arr2 = {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1};
        System.out.println(findMissingNumber(arr2));
        int[] arr3 = {5, 6, 8, 9};
        System.out.println(findMissingNumber(arr3, 5));
        int[] arr4 = {1, 2, 4, 6};
        System.out.println(Arrays.toString(findTwoMissingNumbers(arr4)));
        int[] arr5 = {1, 2, 2, 4, 5};
        System.out.println("Missing and Duplicate: " + Arrays.toString(findMissingAndDuplicate(arr5)));
    }
}
