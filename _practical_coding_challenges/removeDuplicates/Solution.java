class Solution {
    public int removeDuplicates(int[] nums) {
        int[] tmpNums = Arrays.stream(nums).distinct().toArray();

        for(int i = 0; i < tmpNums.length; i++) {
            nums[i] = tmpNums[i];
        }

        return tmpNums.length;
    }
}