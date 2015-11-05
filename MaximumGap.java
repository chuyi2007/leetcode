public class Solution {
    // pigeon hole method
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        int min = Integer.MAX_VALUE, max = 0;
        // find min and max value of the array
        for (int num: nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        // find gap, remember to use Math.ceil
        // The reason for this is if we use Math.floor, the value close to max will overflow when calculating index
        int gap = (int) Math.ceil((max - min) / ((double) n - 1));
        int[] minBuckets = new int[n - 1];
        int[] maxBuckets = new int[n - 1];
        Arrays.fill(minBuckets, Integer.MAX_VALUE);
        Arrays.fill(maxBuckets, Integer.MIN_VALUE);
        for (int num: nums) {
            // We don't need min and max
            // fill rest of n - 2 numbers into n - 1 holes
            if (num == min || num == max) {
                continue;
            }
            int i = (num - min) / gap;
            minBuckets[i] = Math.min(num, minBuckets[i]);
            maxBuckets[i] = Math.max(num, maxBuckets[i]);
        }
        int maxGap = 0, pre = min;
        for (int i = 0; i < n - 1; ++i) {
            // there must be an empty bucket, so skip it
            if (minBuckets[i] == Integer.MAX_VALUE && 
                maxBuckets[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(minBuckets[i] - pre, maxGap);
            pre = maxBuckets[i];
        }
        maxGap = Math.max(max - pre, maxGap);
        return maxGap;
    }
}
