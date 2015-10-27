public class Solution {
    public int removeDuplicates(int[] nums) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int uni = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                ++i;
            }
            nums[uni++] = nums[i];
        }
        return uni;
    }
}
