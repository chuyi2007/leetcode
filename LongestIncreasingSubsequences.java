public class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> longest = new ArrayList<>();
        for (int num : nums) {
            if (longest.size() == 0 || longest.get(longest.size() - 1) < num) {
                longest.add(num);
            } else {
                int i = Collections.binarySearch(longest, num);
                longest.set(i < 0 ? -i - 1 : i, num);
            }
        }
        return longest.size();
    }
}

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
