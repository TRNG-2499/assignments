package java_algorithm_assignment_02;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateRight(new int[] {1, 2, 3, 4, 5}, 2)));
        System.out.println(Arrays.toString(rotateRight(new int[] {1, 2, 3}, 4)));
        System.out.println(Arrays.toString(rotateRight(new int[] {1, 2, 3, 4}, 0)));
        System.out.println(Arrays.toString(rotateLeft(new int[] {1, 2, 3, 4, 5}, 2)));
        System.out.println(Arrays.toString(rotateWithSignedSteps(new int[] {1, 2, 3, 4, 5}, -7)));
        int[] inPlaceExample = {1, 2, 3, 4, 5};
        rotateRightInPlace(inPlaceExample, 2);
        System.out.println(Arrays.toString(inPlaceExample));
    }

    private static int[] rotateRight(int[] numbers, int k) {
        if (numbers.length == 0) {
            return numbers;
        }

        int steps = Math.floorMod(k, numbers.length);
        int[] rotated = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            rotated[(i + steps) % numbers.length] = numbers[i];
        }
        return rotated;
    }

    private static int[] rotateLeft(int[] numbers, int k) {
        if (numbers.length == 0) {
            return numbers;
        }

        int steps = Math.floorMod(k, numbers.length);
        int[] rotated = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            rotated[(i - steps + numbers.length) % numbers.length] = numbers[i];
        }
        return rotated;
    }

    private static int[] rotateWithSignedSteps(int[] numbers, int k) {
        if (numbers.length == 0) {
            return numbers;
        }

        int steps = Math.floorMod(k, numbers.length);
        int[] rotated = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            rotated[(i + steps) % numbers.length] = numbers[i];
        }
        return rotated;
    }

    private static void rotateRightInPlace(int[] numbers, int k) {
        if (numbers.length == 0) {
            return;
        }

        int steps = Math.floorMod(k, numbers.length);
        reverse(numbers, 0, numbers.length - 1);
        reverse(numbers, 0, steps - 1);
        reverse(numbers, steps, numbers.length - 1);
    }

    private static void reverse(int[] numbers, int left, int right) {
        while (left < right) {
            int temporary = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temporary;
            left++;
            right--;
        }
    }
}
