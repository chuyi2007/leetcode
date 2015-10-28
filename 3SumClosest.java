public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int minSum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - sum);
                if (diff < minDiff) {
                    minSum = sum;
                    minDiff = diff;
                }
                if (sum < target) {
                    while (j < k - 1 && nums[j] == nums[j + 1]) {
                        ++j;
                    }
                    ++j;
                } else if (sum > target) {
                    while (k > j + 1 && nums[k] == nums[k - 1]) {
                        --k;
                    }
                    --k;
                } else {
                    return target;
                }
            }
        }
        return minSum;
    }
}}
