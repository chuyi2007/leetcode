public class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int mid = 0; mid <= right; ++mid) {
            if (nums[mid] == 0) {
                swap(nums, left, mid);
                ++left;
            } else if (nums[mid] == 2) {
                swap(nums, right, mid);
                --mid;
                --right;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

//O(N)
public void twoPass(int[] nums) {
    int[] counts = new int[3];
    for (int i = 0; i < nums.length; i++) {
        ++counts[nums[i]];
    }
    for (int i = 0; i < nums.length; i++) {
        if (i < counts[0]) {
            nums[i] = 0;
        }
        else if (i < counts[0] + counts[1]) {
            nums[i] = 1;
        }
        else {
            nums[i] = 2;
        }
    }
}
