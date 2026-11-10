// Author: Tyler Pyrzenski

import java.util.Arrays;

public class solution {
    public static void main(String[] args) {
        System.out.println(findClosestValue(new int[]{4, 9, 1, 15, 8}, 10));
        System.out.println(findClosestValue(new int[]{4, 9, 1, 15, 8}, 2));
        System.out.println(findClosestValue(new int[]{5, 15}, 10));
        System.out.println(findClosestValue(new int[]{}, 10));

        System.out.println();

        // closest k tests
        System.out.println(Arrays.toString(findClosestK(new int[]{4, 9, 1, 15, 8}, 10, 3)));
        System.out.println(Arrays.toString(findClosestK(new int[]{5, 15, 10}, 10, 2)));
        System.out.println(Arrays.toString(findClosestK(new int[]{4, 9, 1}, 10, 5)));
        System.out.println(Arrays.toString(findClosestK(new int[]{}, 10, 2)));

        System.out.println();

        // farthest tests
        System.out.println(findFarthestValue(new int[]{4, 9, 1, 15, 8}, 10));
        System.out.println(findFarthestValue(new int[]{5, 15}, 10));
        System.out.println(findFarthestValue(new int[]{}, 10));

        System.out.println();

        // tie flag tests
        System.out.println(findClosestValueWithTieBreak(new int[]{5, 15}, 10, false));
        System.out.println(findClosestValueWithTieBreak(new int[]{5, 15}, 10, true));
        System.out.println(findClosestValueWithTieBreak(new int[]{4, 9, 1, 15, 8}, 10, true));
    }

    public static int findClosestValue(int[] input, int target) {

        int bestValue;
        int bestDistance;
        int current;
        int distanceToTarget;

        if (input.length == 0) {
            return -1;
        }

        bestValue = input[0];
        bestDistance = Math.abs(target - input[0]);


        for (int i = 1; i < input.length; i++) {
            current = input[i];
            distanceToTarget = Math.abs(target - current);
            if (distanceToTarget < bestDistance) {
                bestDistance = distanceToTarget;
                bestValue = current;
            } else if (distanceToTarget == bestDistance && current < bestValue) {
                bestValue = current;

            }


        }

        return bestValue;
    }

    // returns the k closest values, closest first
    // runs the best-so-far search k times, skipping values already picked
    public static int[] findClosestK(int[] input, int target, int k) {

        // can't return more values than the array has
        int count = Math.min(k, input.length);
        if (count <= 0) {
            return new int[0];
        }

        int[] result = new int[count];
        boolean[] used = new boolean[input.length]; // tracks which spots were already picked

        for (int r = 0; r < count; r++) {
            int bestIndex = -1;

            for (int i = 0; i < input.length; i++) {
                if (used[i]) {
                    continue;
                }

                if (bestIndex == -1) {
                    bestIndex = i;
                    continue;
                }

                int distance = Math.abs(target - input[i]);
                int bestDistance = Math.abs(target - input[bestIndex]);

                // closer wins, ties go to the smaller value
                if (distance < bestDistance || (distance == bestDistance && input[i] < input[bestIndex])) {
                    bestIndex = i;
                }
            }

            result[r] = input[bestIndex];
            used[bestIndex] = true;
        }

        return result;
    }

    // same idea as findClosestValue, but keeps the biggest distance instead
    public static int findFarthestValue(int[] input, int target) {

        if (input.length == 0) {
            return -1;
        }

        int bestValue = input[0];
        int bestDistance = Math.abs(target - input[0]);

        for (int i = 1; i < input.length; i++) {
            int current = input[i];
            int distanceToTarget = Math.abs(target - current);

            if (distanceToTarget > bestDistance) {
                bestDistance = distanceToTarget;
                bestValue = current;
            } else if (distanceToTarget == bestDistance && current < bestValue) {
                bestValue = current;
            }
        }

        return bestValue;
    }

    // same as findClosestValue, but preferLarger decides which value wins a tie
    public static int findClosestValueWithTieBreak(int[] input, int target, boolean preferLarger) {

        if (input.length == 0) {
            return -1;
        }

        int bestValue = input[0];
        int bestDistance = Math.abs(target - input[0]);

        for (int i = 1; i < input.length; i++) {
            int current = input[i];
            int distanceToTarget = Math.abs(target - current);

            if (distanceToTarget < bestDistance) {
                bestDistance = distanceToTarget;
                bestValue = current;
            } else if (distanceToTarget == bestDistance) {
                // true keeps the larger value, false keeps the smaller one
                if (preferLarger && current > bestValue) {
                    bestValue = current;
                } else if (!preferLarger && current < bestValue) {
                    bestValue = current;
                }
            }
        }

        return bestValue;
    }


}