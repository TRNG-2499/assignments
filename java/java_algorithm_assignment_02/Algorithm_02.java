public class Algorithm_02 {
    public static int[] rotateArray(int[] nums, int k)
    {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        int[] rotated = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rotated[(i + k) % nums.length] = nums[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 9;
        int[] rotated = rotateArray(nums, k);
        System.out.print("Rotated array: ");
        for (int num : rotated) {
            System.out.print(num + " ");
        }
    }
}
