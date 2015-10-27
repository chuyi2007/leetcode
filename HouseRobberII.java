public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    public int rob(int[] nums, int start, int end) {
        int max = 0, maxPre = 0, maxPrePre = 0;
        for (int i = start; i <= end; ++i) {
            max = Math.max(nums[i] + maxPrePre, maxPre);
            maxPrePre = maxPre;
            maxPre = max;
        }
        return max;
    }
}
