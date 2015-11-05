public class Solution {
    public int findDuplicate(int[] nums) {
        return linearSearch(nums);
    }
    
    public int linearSearch(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // Imagine this nums array is a linked list
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast) {
                break;
            }
        }
        return slow;
    }
    
    public int binarySearch(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // find mid point
            int mid = left + (right - left) / 2;
            // calculate whats below mid
            // the general idea is
            // if left is too crowded, switch to left
            // else switch to right
            int lowerCount  = 0;
            for (int i = 0; i < nums.length; ++i) {
                // check if left is too crowded
                // remember mid is always the lower bound of the middle number
                // i.e. 1, 2, 2, 3
                // 1: left = 0, right = 3, mid = 1
                // 2: left = 0, right = 1, mid = 0
                // 3: left = 1, right = 1, mid = 1
                
                if (nums[i] <= mid) {
                    ++lowerCount;
                }
            }
            if (lowerCount <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
