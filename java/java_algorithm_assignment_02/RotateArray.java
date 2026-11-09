


public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; 
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        rotateArray.rotate(nums1, k1);
        System.out.print("Rotated array 1: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] nums2 = {1, 2, 3};
        int k2 = 4;
        rotateArray.rotate(nums2, k2);
        System.out.print("Rotated array 2: ");
        for (int num : nums2) {
            System.out.print(num + " ");
        }
        
    }
}