public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numIndex = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            if (!numIndex.containsKey(nums[i])) {
                numIndex.put(nums[i], i);
            } else {
                int index = numIndex.get(nums[i]);
                if (i - index <= k) {
                    return true;
                }
                numIndex.put(nums[i], i);
            }
        }
        return false;
    }
}
