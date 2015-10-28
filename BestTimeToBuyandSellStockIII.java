//O(N^2)
public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int total = 0;
        for(int i = 0; i < prices.length; ++i){
            total = Math.max(total, singleTrade(prices, 0, i + 1)
                    + singleTrade(prices, i, prices.length));
        }
        return total;
    }
    public int singleTrade(int[] prices, int start, int end) {
        int maxProfit = 0;
        int minStock = Integer.MAX_VALUE;
        for (int j = start; j < end; ++j) {
            minStock = Math.min(minStock, prices[j]);
            maxProfit = Math.max(maxProfit, prices[j] - minStock);
        }
        return max;
    }
}
