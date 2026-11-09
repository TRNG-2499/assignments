import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissingNumberFinder {
    static void main() {
        MissingNumberFinder instance = new MissingNumberFinder();

        /*
        Test core
         */
        int[] input1 = {3, 7, 1, 2, 8, 4, 5};
//        instance.findMissingNumber(input1);
        int[] input2 = {13, 3, 7, 11, 4, 6, 2, 10, 9, 5, 8, 1};
//        instance.findMissingNumber(input2);

        /*
        Test stretch
         */
        int[] input3 = {7, 1, 2, 8, 4, 5};
        instance.stretchCustomStartingValue(input3, 5);

        int[] input4 = {1, 2, 4, 6};
        instance.stretchTwoMissingNumbers(input4);

        int[] input5 = {1, 2, 2, 4};
        instance.stretchMissingAndDuplicate(input5);
    }

    public void findMissingNumber(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            System.out.println("Error: Input array cannot be blank.");
            return;
        }
        Map<Integer, Integer> entries = new HashMap<>();

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        // Initial scan to add to dictionary and extract max and mins
        for (int i : iArr) {
            minValue = Math.min(minValue, i);
            maxValue = Math.max(maxValue, i);

            if (entries.containsKey(i)) {
                entries.put(i, entries.get(i) + 1);
            } else {
                entries.put(i, 0);
            }
        }

        // Final scan through keys to find missing values
        for (int key : entries.keySet()) {
            if (key != minValue && !entries.containsKey(key - 1)) {
                System.out.println("Missing value: " + (key - 1));
                return;
            }
        }
        System.out.println("No missing values provided within the range. The missing value is either "
        + (minValue - 1) + " or " + (maxValue + 1));
    }

    public void stretchCustomStartingValue(int[] iArr, int start) {
        if (iArr == null || iArr.length == 0) {
            System.out.println("Error: Input array cannot be blank.");
            return;
        }

        Map<Integer, Integer> entries = new HashMap<>();

        // Initial scan to add to dictionary and extract max and mins
        for (int i : iArr) {

            if (entries.containsKey(i)) {
                entries.put(i, entries.get(i) + 1);
            } else {
                entries.put(i, 0);
            }
        }

        // Final scan through keys to find missing values
        for (int key : entries.keySet()) {
            if (key > start && !entries.containsKey(key - 1)) {
                System.out.println("Missing value: " + (key - 1));
                return;
            }
        }
        System.out.println("No missing values provided within the given range and start value.");
    }

    public void stretchTwoMissingNumbers(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            System.out.println("Error: Input array cannot be blank.");
            return;
        }
        Map<Integer, Integer> entries = new HashMap<>();

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        // Initial scan to add to dictionary and extract max and mins
        for (int i : iArr) {
            minValue = Math.min(minValue, i);
            maxValue = Math.max(maxValue, i);

            if (entries.containsKey(i)) {
                entries.put(i, entries.get(i) + 1);
            } else {
                entries.put(i, 0);
            }
        }

        // Final scan through keys to find missing values
        int missingCount = 0;
        List<Integer> missingValues = new ArrayList<Integer>();
        for (int key : entries.keySet()) {
            if (key != minValue && !entries.containsKey(key - 1)) {
                // Add in sorted order
                if (missingCount > 0 && missingValues.get(0) > (key - 1)) {
                    missingValues.add(key - 1, 0);
                } else {
                    missingValues.add(key - 1);
                }
                missingCount += 1;
                if (missingCount >= 2) {
                    break;
                }
            }
        }
        if (missingValues.isEmpty()) {
            System.out.println("No missing values provided within the range. The missing value is either "
                    + (minValue - 1) + " or " + (maxValue + 1));
        } else {
            System.out.println("Missing values: " + missingValues.toString());
        }

    }

    public void stretchMissingAndDuplicate(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            System.out.println("Error: Input array cannot be blank.");
            return;
        }
        Map<Integer, Integer> entries = new HashMap<>();

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        // Initial scan to add to dictionary and extract max and mins
        for (int i : iArr) {
            minValue = Math.min(minValue, i);
            maxValue = Math.max(maxValue, i);

            if (entries.containsKey(i)) {
                entries.put(i, entries.get(i) + 1);
            } else {
                entries.put(i, 1);
            }
        }

        // Final scan through keys to find missing values
        String missingValue = "";
        String duplicateValue = "";

        for (int key : entries.keySet()) {
            if (key != minValue && !entries.containsKey(key - 1)) {
                missingValue = String.valueOf(key - 1);
            }
            if (entries.get(key) > 1) {
                duplicateValue = String.valueOf(key);
            }
        }
        if (missingValue.isEmpty() || duplicateValue.isEmpty()) {
            System.out.println("Error: Array does not contain a missing or duplicate value.");
        }
        System.out.println("Missing value: " + missingValue + "\nDuplicate value: " + duplicateValue);
    }
}
