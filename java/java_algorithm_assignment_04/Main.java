import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(findClosest(new int[]{4, 9, 1, 15, 8}, 10));
        System.out.println(findClosest(new int[]{4, 9, 1, 15, 8}, 2));
        System.out.println(findClosest(new int[]{5, 15}, 10));
        System.out.println(findClosest(new int[]{}, 10));

        System.out.println(findClosestK(new int[]{4, 9, 1, 15, 8}, 10, 3));

        System.out.println(findFarthest(new int[]{4, 9, 1, 15, 8}, 10));
        System.out.println(findFarthest(new int[]{4, 9, 1, 15, 8}, 2));
        System.out.println(findFarthest(new int[]{5, 15}, 10));
        System.out.println(findFarthest(new int[]{}, 10));

        System.out.println(findClosestBool(new int[]{5, 15}, 10, true));
        System.out.println(findClosestBool(new int[]{5, 15}, 10, false));
    }

    /**
     * Finds the value in the array numerically closest to the target.
     * If there is a tie, returns the smaller of the two tied values.
     * 
     * @param nums The array of positive integers (unsorted)
     * @param target The target integer value
     * @return The closest integer, or -1 if the array is null or empty
     */
    public static int findClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int closest = nums[0];
        int diff = Math.abs(target - nums[0]);

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int currDiff = Math.abs(target - nums[i]);

            if (currDiff == 0) {
                return current;
            }

            if (currDiff < diff) {
                diff = currDiff;
                closest = current;
            } else if (currDiff == diff) {
                closest = Math.min(closest, current);
            }
        }
        return closest;
    }

    /**
     * Finds the k values in the array numerically closest to the target.
     * If there is a tie, returns the smaller of the two tied values.
     * 
     * @param nums The array of positive integers (unsorted)
     * @param target The target integer value
     * @param k The number of values to find
     * @return The array of k closest integer, or -1 if the array is null or empty
     */
    public static List<Integer> findClosestK(int[] nums, int target, int k) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        PriorityQueue<Integer> closest = new PriorityQueue<>((a, b) -> {
            int diffA = Math.abs(a - target);
            int diffB = Math.abs(b - target);
            if (diffA != diffB) {
                return Integer.compare(diffB, diffA);
            }
            return Integer.compare(b, a);
        });

        for (int i = 0; i < nums.length; i++) {
            closest.offer(nums[i]);
            if (closest.size() > k) {
                closest.poll();
            }
        }
        return new ArrayList<>(closest);
    }

    /**
     * Finds the value in the array numerically farthest to the target.
     * If there is a tie, returns the smaller of the two tied values.
     * 
     * @param nums The array of positive integers (unsorted)
     * @param target The target integer value
     * @return The farthest integer, or -1 if the array is null or empty
     */
    public static int findFarthest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int farthest = nums[0];
        int diff = Math.abs(target - nums[0]);

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int currDiff = Math.abs(target - nums[i]);

            if (currDiff > diff) {
                diff = currDiff;
                farthest = current;
            } else if (currDiff == diff) {
                farthest = Math.min(farthest, current);
            }
        }
        return farthest;
    }

    /**
     * Finds the value in the array numerically closest to the target.
     * If there is a tie, returns the smaller of the two tied values if tieBreaker is false.
     * 
     * @param nums The array of positive integers (unsorted)
     * @param target The target integer value
     * @param tieBreaker The boolean to determine if we want smallest value or not in tie break
     * @return The closest integer, or -1 if the array is null or empty
     */
    public static int findClosestBool(int[] nums, int target, boolean tieBreaker) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int closest = nums[0];
        int diff = Math.abs(target - nums[0]);

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int currDiff = Math.abs(target - nums[i]);

            if (currDiff == 0) {
                return current;
            }

            if (currDiff < diff) {
                diff = currDiff;
                closest = current;
            } else if (currDiff == diff) {
                if (tieBreaker) {
                    closest = Math.max(closest, current);
                } else {
                    closest = Math.min(closest, current);
                }
            }
        }
        return closest;
    }
}