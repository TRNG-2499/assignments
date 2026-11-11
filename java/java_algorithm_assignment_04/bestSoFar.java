package java_algorithm_assignment_04;

public class bestSoFar {
    public static int closestToTarget(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        int closest = -1;
        int difference = Integer.MAX_VALUE;

        for (int a : arr) {
            int temp = Math.abs((a - target));
            if (temp < difference) {
                closest = a;
                difference = temp;
            } else if (temp == difference) {
                if (a < closest) closest = a;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        System.out.println(closestToTarget(new int[]{4,9,1,15,8}, 10));
        System.out.println(closestToTarget(new int[]{4,9,1,15,8}, 2));
        System.out.println(closestToTarget(new int[]{5,15}, 10));
        System.out.println(closestToTarget(new int[]{}, 2));
    }
}
