public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] < nums[right] && nums[left] < nums[right] ||
                nums[mid] < nums[left] && nums[left] > nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }
}
