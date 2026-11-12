package java.java_algorithm_assignment_04;

public class ClosestValue {
    public static int Closest (int[] nums, int target){
        if (nums == null || nums.length == 0){
            return -1;
        }
        int best = nums[0];
        long bestDiff = distance(best, target);
        for (int i = 1; i < nums.length; i++){
            int current = nums[i];
            long diff = distance(current, target);
            if (diff < bestDiff || (diff == bestDiff && current < best)){
                best = current;
                bestDiff = diff;
            }
        }
        return best;
    }

    private static long distance(int a, int b){
        return Math.abs((long) a - b);
    }
}
