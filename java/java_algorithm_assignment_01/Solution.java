package java_algorithm_assignment_01;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[] {3, 7, 1, 2, 8, 4, 5}));
        System.out.println(findMissingNumber(
                new int[] {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1}));
        System.out.println(findMissingNumberFromStart(new int[] {5, 6, 8, 9}, 5));
        System.out.println(findMissingNumberFromStart(new int[] {6, 7, 8, 9}, 5));
    }

    private static int findMissingNumber(int[] numbers) {
        int expectedSum = (numbers.length + 1) * (numbers.length + 2) / 2;
        int actualSum = 0;
        for (int number : numbers) {
            actualSum += number;
        }
        return (expectedSum - actualSum);
    }

    private static int findMissingNumberFromStart(int[] numbers, int start) {
        int end = start + numbers.length;
        int expectedSum = (start + end) * (numbers.length + 1) / 2;
        int actualSum = 0;
        for (int number : numbers) {
            actualSum += number;
        }
        return expectedSum - actualSum;
    }
}
