import java.util.Arrays;

public class ClosestValueInArray {

    public static int Solution1(int[] intArray, int target) {
        if (intArray.length == 0) {
            return -1;
        }

        // Sorting gives us the guarantee that the next closest value to the target
        // will be the correct value to return because we don't have to deal with the
        // potential for a later value having the same distance from target, since
        // they would be a larger integer anyways
        Arrays.sort(intArray);

        int closest = 0;
        int minDist = 0;
        for (int i = 0; i < intArray.length; i++) {
            int diff = Math.abs(target - intArray[i]);

            if (i == 0) {
                closest = intArray[i];
                minDist = diff;
                continue;
            }

            if (diff < minDist) {
                closest = intArray[i];
                minDist = diff;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        System.out.println(Solution1(new int[] {4, 9, 1, 15, 8, 3}, 2));
    }
}