/**
     * @param args the command line arguments
     * Java algorithm assignment 04 - Closest Value In a Array
     * Objective: Practice linear iteration through an array while tracking the "best so far" result — comparing each element against a running best using a calculated difference, a common pattern that shows up across many search and optimization-style problems.
     * 1. Write a method that accepts two parameters: an array of integers and a target integer value. The array is not assumed to be sorted, and all numbers in the array will always be positive integers. The method should return the value from the array that is numerically closest to the target.
     * 2. If there is a tie (two values are equally close to the target), return the smaller of the two tied values. Since the array is not sorted, a straightforward linear scan comparing each element's distance from the target is the expected approach here. Sorting the array first is not required, but you are welcome to sort it as part of your solution if you'd like to explore whether it helps "optimize" your approach.
     * 3. If the array is empty, return -1. Since the array will otherwise always contain positive integers, -1 can be safely used as a signal that no result was found.

*/

public class ClosestValueInaArray {
    public static int findClosestValueInArray(int[] numbers, int target) {
        //empty array check.
        if (numbers.length == 0) {
            return -1;
        }
        //starting with the first element as the closest value and its difference from the target.
        int closest = numbers[0];
        long smallestDifference = Math.abs((long) numbers[0] - target);

        //iterate through the array starting from the second element, calculate the absolute difference between each element and the target, and update the closest value if a smaller difference is found or if there's a tie with a smaller number.
        for (int i = 1; i < numbers.length; i++) {
            long difference = Math.abs((long) numbers[i] - target);
            if (difference < smallestDifference || (difference == smallestDifference && numbers[i] < closest)) {
                closest = numbers[i];
                smallestDifference = difference;
            }
        }
        return closest;
    }
    public static void main(String[] args) {
        int[] numbers = {4, 9, 1, 15, 8};
        int target = 10;
        int result = findClosestValueInArray(numbers, target);
        System.out.println("Closest value: " + result);

        int[] numbers2 = {2, 4, 6, 8, 10};
        int target2 = 2;
        int result2 = findClosestValueInArray(numbers2, target2);
        System.out.println("Closest value: " + result2);

        int[] numbers3 = {};
        int target3 = 5;
        int result3 = findClosestValueInArray(numbers3, target3);
        System.out.println(result3);
    }
}
