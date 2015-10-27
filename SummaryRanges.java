public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<String>();
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[j] - nums[i] != j - i) {
                result.add(createRange(i, j, nums));
                i = j++;
            } else {
                ++j;
            }
        }
        result.add(createRange(i, j, nums));
        return result;
    }
    
    // j is exclusive    
    public String createRange(int i, int j, int[] nums) {
        return j - i == 1 ? String.valueOf(nums[i]) : String.valueOf(nums[i]) + "->" + String.valueOf(nums[j - 1]);
    }
}
