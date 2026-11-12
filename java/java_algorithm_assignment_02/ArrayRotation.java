package java.java_algorithm_assignment_02;

public class ArrayRotation {
    public static int[] rotateRight(int[] nums, int k){
        if (nums == null || nums.length <= 1){
            return nums;
        }

        int n = nums.length;
        k = ((k % n) + n) % n;
        if(k == 0){
            return nums;
        }

        reverse(nums, 0, n-1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n-1);
        return nums;
    }

    private static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
