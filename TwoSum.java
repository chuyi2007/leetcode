public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                return new int[] {
                    Math.min(i + 1, map.get(remain) + 1),
                    Math.max(i + 1, map.get(remain) + 1)
                };
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
