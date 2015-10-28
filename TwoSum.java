public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> intToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!intToIndex.containsKey(nums[i])) {
                intToIndex.put(nums[i], i);
            } else if (2 * nums[i] == target) {
                return new int[]{intToIndex.get(nums[i]) + 1, i + 1};
            }
        }
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j;) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                ++i;
            } else if (sum > target) {
                --j;
            } else {
                return new int[]{
                    Math.min(intToIndex.get(nums[i]), intToIndex.get(nums[j])) + 1,
                    Math.max(intToIndex.get(nums[i]), intToIndex.get(nums[j])) + 1
                };
            }
        }
        return new int[2];
    }
}
