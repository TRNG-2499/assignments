package java_algorithm_assignment_04;

import java.util.*;

public class close {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        // This is manual entering array

        // System.out.print("Enter array size: ");
        // int size = scanner.nextInt();
        // int[] array = new int[size];
        // System.out.println("Enter array elements: ");
        // for (int i = 0; i < size; i++) {
        // array[i] = scanner.nextInt();
        // }

        // System.out.println("Choose your target: ");
        // int target = scanner.nextInt();

        // This is hard coded array for efficient testing
        int[] array = { 4, 9, 1, 8, 15 };
        int target = 2;

        System.out.println("Enter program mode");
        System.out.println("1 for default");
        System.out.println("2 for keep k values");

        int mode = scanner.nextInt();
        if (mode == 1) {
            System.out.println("Default mode selected");
            DefaultMode(array, target);
        } else if (mode == 2) {
            System.out.println("Keep k values mode selected");
            System.out.println("Enter value for k: ");
            int k = scanner.nextInt();
            KeepValues(array, target, k);
        } else {
            System.out.println("Invalid mode selected");
        }

    }

    public static void DefaultMode(int[] array, int target) {

        if (array == null || array.length == 0) {
            System.out.println("-1");
        }

        int difference = Integer.MAX_VALUE;
        int closest = array[0];

        for (int i = 0; i < array.length; i++) {
            if (Math.abs(target - array[i]) < difference) {
                difference = Math.abs(target - array[i]);
                closest = array[i];
            } else if (Math.abs(target - array[i]) == difference) {
                closest = Math.min(closest, array[i]);
            }
        }

        System.out.println(closest);
    }

    public static void KeepValues(int[] array, int target, int k) {

        if (array == null || array.length == 0) {
            System.out.println("-1");
        }

        Map<Integer, Integer> result = new HashMap<>();

        int maxDifference = 0;
        int key = -1;
        int i;

        // loading first k elements into the result map
        for (i = 0; i < k; i++) {
            result.put(array[i], Math.abs(target - array[i]));
        }

        // loop to find maximum difference
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue() > maxDifference) {
                maxDifference = entry.getValue();
                key = entry.getKey();
            }
        }

        int difference = maxDifference;

        for (i = k; i < array.length; i++) {

            if (Math.abs(target - array[i]) < difference) {
                result.put(array[i], Math.abs(target - array[i]));
                result.remove(key);
                difference = Math.abs(target - array[i]);
                key = array[i];

                for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
                    if (entry.getValue() > maxDifference) {
                        maxDifference = entry.getValue();
                        key = entry.getKey();
                    }
                }
            }

        }

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.print(entry.getKey() + " | ");
        }
    }
}
