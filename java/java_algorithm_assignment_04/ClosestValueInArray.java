public class ClosestValueInArray {

    // Find the number in the array that is closest to the target.
    public static int findClosest(int[] numbers, int target) {
        // An empty array has no first element, so return -1 right away.
        if (numbers.length == 0) {
            return -1;
        }

        // Start with the first number as our best match so far.
        int closest = numbers[0];

        // Math.abs gives us the distance as a nonnegative number.
        // Cast to long before subtracting so large differences fit.
        long bestDistance = Math.abs((long) closest - target);

        // Start at index 1 because we already used the first number.
        for (int i = 1; i < numbers.length; i++) {
            int number = numbers[i];
            long distance = Math.abs((long) number - target);

            // Update the best match if this number is closer.
            // If the distances are equal, choose the smaller number.
            if (distance < bestDistance
                    || (distance == bestDistance && number < closest)) {
                closest = number;
                bestDistance = distance;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        // Both values are 5 away from 10, so the smaller value wins.
        int[] numbers = {15, 5};
        int target = 10;

        System.out.println(findClosest(numbers, target)); // 5
    }
}