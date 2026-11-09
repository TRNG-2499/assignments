/**
     * @param args the command line arguments
     * Java algorithm assignment 02 - Rotate Array
     * Objective: Practice manipulating array elements in place (or into a new array), handling positional shifts based on a given step count, and accounting for step counts that wrap around the array's length.
     * 1. Write a method that accepts a single parameter: an array of integers.
     * 2. The array will always contain all of the distinct integers from 1 to n, in some order, with exactly one value missing from that range (where n is one more than the length of the array).
     * 3. The method should return the single missing integer.
     * 4. You can assume the array will always have exactly one missing number — you do not need to handle the case of zero or multiple missing numbers.
*/

import java.util.Arrays;

public class RotateArray {
    public static int[] rotateArray(int[] numbers, int k) {
        int length = numbers.length;
        if (length == 0) {
            return numbers;
        }
        k = k % length;
        int[] rotated = new int[length];
        for (int i = 0; i < length; i++) {
            int newPosition = (i + k) % length;
            rotated[newPosition] = numbers[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        int[] numbers = {8, 22, 3, 14, 50};
        int k = 3;
        int[] result = rotateArray(numbers, k);
        System.out.println(Arrays.toString(result));
    }
}
