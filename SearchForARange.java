public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target - 1);
        int second = binarySearch(nums, target);
        if (first == second) {
            return new int[]{-1, -1};
        }
        return new int[]{first, second - 1};
    }
    
    public int binarySearch(int[] nums, int target) {
        int min = 0, max = nums.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (nums[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}
