public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;
        while (end < nums.length) {
            while (sum < s && end < nums.length) {
                sum += nums[end];
                ++end;
            }
            if (sum < s) {
                break;
            }
            while (sum >= s && start < end) {
                sum -= nums[start];
                ++start;
            }
            min = Math.min(end - start + 1, min);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
