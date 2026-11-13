// Author: Tyler Pyrzenski

import java.util.Arrays;

public class solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateMethod(new int[]{1, 2, 3, 4, 5}, 2)));
        System.out.println(Arrays.toString(rotateMethod(new int[]{1, 2, 3}, 4)));
        System.out.println(Arrays.toString(rotateMethod(new int[]{1, 2, 3, 4}, 0)));

        System.out.println();

        // rotate left tests
        System.out.println(Arrays.toString(rotateLeft(new int[]{1, 2, 3, 4, 5}, 2)));
        System.out.println(Arrays.toString(rotateLeft(new int[]{1, 2, 3}, 4)));
        System.out.println(Arrays.toString(rotateLeft(new int[]{1, 2, 3, 4}, 0)));

        System.out.println();

        // negative k tests
        System.out.println(Arrays.toString(rotateWithDirection(new int[]{1, 2, 3, 4, 5}, 2)));
        System.out.println(Arrays.toString(rotateWithDirection(new int[]{1, 2, 3, 4, 5}, -2)));
        System.out.println(Arrays.toString(rotateWithDirection(new int[]{1, 2, 3, 4, 5}, -7)));
        System.out.println(Arrays.toString(rotateWithDirection(new int[]{1, 2, 3, 4, 5}, 0)));

        System.out.println();

        // in place tests, the array itself gets changed so it's printed after
        int[] inPlace1 = {1, 2, 3, 4, 5};
        rotateInPlace(inPlace1, 2);
        System.out.println(Arrays.toString(inPlace1));

        int[] inPlace2 = {1, 2, 3};
        rotateInPlace(inPlace2, 4);
        System.out.println(Arrays.toString(inPlace2));

        int[] inPlace3 = {1, 2, 3, 4};
        rotateInPlace(inPlace3, 0);
        System.out.println(Arrays.toString(inPlace3));
    }

    public static int[] rotateMethod(int[] input, int k) {

        int[] newArray = new int[input.length];

        for (int i = 0; i < input.length; i++) {

            int newIndex = (i + k) % input.length;

            newArray[newIndex] =input[i];
        }

        return newArray;
    }

    // rotates left by moving each element back k spots
    public static int[] rotateLeft(int[] input, int k) {

        if (input.length == 0) {
            return input;
        }

        int[] newArray = new int[input.length];
        int steps = k % input.length;

        for (int i = 0; i < input.length; i++) {
            // adding length keeps the index from going negative
            int newIndex = (i - steps + input.length) % input.length;
            newArray[newIndex] = input[i];
        }

        return newArray;
    }

    // positive k rotates right, negative k rotates left
    public static int[] rotateWithDirection(int[] input, int k) {

        if (input.length == 0) {
            return input;
        }

        int[] newArray = new int[input.length];

        // turns any k (including negatives) into an equivalent right rotation
        int steps = ((k % input.length) + input.length) % input.length;

        for (int i = 0; i < input.length; i++) {
            int newIndex = (i + steps) % input.length;
            newArray[newIndex] = input[i];
        }

        return newArray;
    }

    // rotates right without a second array by reversing sections
    public static void rotateInPlace(int[] input, int k) {

        if (input.length == 0) {
            return;
        }

        int steps = k % input.length;

        reverseSection(input, 0, input.length - 1); // reverse whole array
        reverseSection(input, 0, steps - 1); // reverse first k
        reverseSection(input, steps, input.length - 1); // reverse the rest
    }

    // reverses part of an array by swapping from both ends inward
    public static void reverseSection(int[] array, int start, int end) {

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }
}
