public class Solutuib_Algo04 {
    
    public static void main(String[] args) {

        System.out.println(findClosestValue(new int[]{4, 9, 1, 15, 8}, 10)); 
        System.out.println(findClosestValue(new int[]{4, 9, 1, 15, 8}, 2));   
        System.out.println(findClosestValue(new int[]{5, 15}, 10));            
        System.out.println(findClosestValue(new int[]{}, 10));       
        
    }

    public static int findClosestValue(int[] nums, int target) {
        // handeling empety array
        if (nums == null || nums.length == 0 ) {
            return  -1;
        }

        int closest = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int diffClosest = Math.abs(closest - target);
            int diffCurrent = Math.abs(current - target);

            if (diffCurrent < diffClosest) {
                closest = current;
            }
            else if (diffCurrent == diffClosest) {
                if (current < closest) {
                    closest = current;
                }
            }
        }
        return closest;
    }
}
