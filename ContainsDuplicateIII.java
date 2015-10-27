public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Integer> kNumsSet = new TreeSet<>();
		for (int i = 0; i < nums.length; ++i) {
			Integer ceiling = kNumsSet.ceiling(nums[i] - t);
			Integer floor = kNumsSet.floor(nums[i] + t);
			if (ceiling != null && ceiling >= nums[i] ||
				floor != null && floor <= nums[i]) {
				return true;
			}
			kNumsSet.add(nums[i]);
			if (kNumsSet.size() > k) {
				kNumsSet.remove(nums[i - k]);
			}
		}
		return false;
	}
}
