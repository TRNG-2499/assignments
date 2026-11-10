import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestValue {
    static void main() {
        ClosestValue instance = new ClosestValue();

        /*
        Core test
         */
        System.out.println("Core test:\n-------------");
        System.out.println(instance.findClosestValue(new int[]{4,9,1,15,8}, 10));
        System.out.println(instance.findClosestValue(new int[]{4,9,1,15,8}, 2));
        System.out.println(instance.findClosestValue(new int[]{15,5}, 10));
        System.out.println(instance.findClosestValue(new int[]{}, 10));

        /*
        Stretch test
         */
        System.out.println("Stretch test:\n-------------");
        System.out.println(Arrays.toString(instance.findKClosestValues(new int[]{1, 2, 3, 4, 5, 7, 8, 9}, 6, 4)));
        System.out.println(instance.findFurthestMatch(new int[]{4,9,1,15,8}, 15));
        System.out.println(instance.findClosestValueHigherOrLower(new int[]{15,5}, 10, true));
        System.out.println(instance.findClosestValueHigherOrLower(new int[]{15,5}, 10, false));

    }

    public int findClosestValue(int[] unsortedValues, int targetValue) {
        if (unsortedValues.length == 0) {
            return -1;
        }

        int closestValue = -1;
        int closestValueDistance = Integer.MAX_VALUE;

        for (int value : unsortedValues) {
            if (value < 0) {
                // Array is required to contain only positive digits
                return -1;
            }

            int distance = Math.abs(value - targetValue);

            if (closestValue < 0 || closestValueDistance > distance) {
                closestValue = value;
                closestValueDistance = distance;
            } else if (closestValueDistance == distance) {
                closestValue = Math.min(closestValue, value);
            }
        }

        return closestValue;
    }

    public int[] findKClosestValues(int[] unsortedValues, int targetValue, int k) {
        if (unsortedValues.length == 0 || k < 1 || k > unsortedValues.length) {
            return new int[]{-1};
        }

        Arrays.sort(unsortedValues);
        int[] sortedValues = unsortedValues;

        int minStartIndex = -1;
        int minTotalDistances = Integer.MAX_VALUE;

        for (int i = 0; i < (sortedValues.length - (k-1)); i++) {
            int totalDistances = 0;
            for (int j = 0; j < k; j++) {
                totalDistances += Math.abs(sortedValues[i+j] - targetValue);
            }

            if (minTotalDistances > totalDistances) {
                minTotalDistances = totalDistances;
                minStartIndex = i;
            }
        }
        return Arrays.copyOfRange(unsortedValues, minStartIndex, minStartIndex + k);
    }

    public int findFurthestMatch(int[] unsortedValues, int targetValue) {
        if (unsortedValues.length == 0) {
            return -1;
        }

        int furthestValue = -1;
        int furthestValueDistance = Integer.MIN_VALUE;

        for (int value : unsortedValues) {
            if (value < 0) {
                // Array is required to contain only positive digits
                return -1;
            }

            int distance = Math.abs(value - targetValue);

            if (furthestValue < 0 || furthestValueDistance < distance) {
                furthestValue = value;
                furthestValueDistance = distance;
            } else if (furthestValueDistance == distance) {
                furthestValue = Math.min(furthestValue, value);
            }
        }

        return furthestValue;
    }

    public int findClosestValueHigherOrLower(int[] unsortedValues, int targetValue, boolean higher) {
        if (unsortedValues.length == 0) {
            return -1;
        }

        int closestValue = -1;
        int closestValueDistance = Integer.MAX_VALUE;

        for (int value : unsortedValues) {
            if (value < 0) {
                // Array is required to contain only positive digits
                return -1;
            }

            int distance = Math.abs(value - targetValue);

            if (closestValue < 0 || closestValueDistance > distance) {
                closestValue = value;
                closestValueDistance = distance;
            } else if (closestValueDistance == distance) {
                if (higher) {
                    closestValue = Math.max(closestValue, value);
                } else {
                    closestValue = Math.min(closestValue, value);
                }
            }
        }

        return closestValue;
    }
}