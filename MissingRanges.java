public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
       List<String> ranges = new ArrayList<String>();
       int pre = lower - 1;
       for (int i = 0; i < nums.length; ++i) {
           int cur = nums[i];
           if (cur - pre > 1) {
               ranges.add(setRange(pre + 1, cur - 1));
           }
           pre = cur;
       }
       if (upper - pre > 0) {
           ranges.add(setRange(pre + 1, upper));
       }
       return ranges;
    }
    
    private String setRange(int start, int end) {
        return (start == end) ? String.valueOf(start) : start + "->" + end;
    }
}
