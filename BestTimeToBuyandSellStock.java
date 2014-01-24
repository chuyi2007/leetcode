//O(N)
public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < prices.length; ++i) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}