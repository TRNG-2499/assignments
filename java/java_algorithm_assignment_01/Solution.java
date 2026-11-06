import java.io.*;
import java.util.*;

public class Solution {
    /*
    * PSEUDOCODE (Solution 1):
    * input: a -> array of integers
    * output: missing integer in a
    * 
    * initialize expectedSum 0
    * initialize actualSum 0
    * 
    * initialize greatestNumber length of a + 1
    * while greatestNumber greater than 0
    *   add greatestNumber to expectedSum
    * for every i in a
    *   add i in actualSum
    * 
    * return expectedSum - actualSum
    * 
    * Evaluation: O(n) where n is the length of a
     */
    public static int missingNumber(int[] integers){
        //Used to calculate the difference between the sums of the array with the missing number and the one without it
        int expectedSum = 0;
        int actualSum = 0;

        //Calculate the expected sum
        int greatestNumber = integers.length + 1;
        while(greatestNumber > 0){
            expectedSum += greatestNumber;
            greatestNumber--;
        }

        //Calculate the actual sum
        for(int i : integers){
            actualSum += i;
        }

        // Return the missing number
        return expectedSum - actualSum;
    }

    public static void main(String... args){
        System.out.println(missingNumber(new int[]{3, 7, 1, 2, 8, 4, 5}));
        System.out.println(missingNumber(new int[]{13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1}));
    }
}