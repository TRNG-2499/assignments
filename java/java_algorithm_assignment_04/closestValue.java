package java_algorithm_assignment_04;

public class closestValue {
    public static int ClosestValFinder(int[] nums, int target) {

        //Check if the array is empty
        if (nums.length == 0) {
            return -1;
        }

        //Initialize the closest value
        int closest = nums[0];

        //loop through the array
        for (int i = 0; i < nums.length; i++) {

            //calculate the current distance
            int currentDistance = Math.abs(nums[i] - target);

            //Calculate the closest value's distance
            int closestDistance = Math.abs(closest - target);

            //Comparing distances
            if (currentDistance < closestDistance || 
                (currentDistance == closestDistance && nums[i] < closest)) {

                    //update the closest value
                    closest = nums[i];
                }
        }

        // Return the closest Value
        return closest;
    }

    public static void main(String[] args) {

        int[] nums = {4, 12, 13, 8, 20};
        int target = 11;

        int result = ClosestValFinder(nums, target);

        System.out.println("Closest value: " + result);

    }
}
