public class Solution {
    public int missingNumber(int[] nums) {
        return bucketSort(nums);
    }
    
    public int bitwise(int[] nums) {
        int res = nums.length;
        for(int i = 0; i < nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
    
    public int bucketSort(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != i) {
                if (nums[i] != nums.length) {
                    swap(nums, i, nums[i]);
                } else {
                    res = i;
                    break;
                }
            }
        }
        return res;
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
