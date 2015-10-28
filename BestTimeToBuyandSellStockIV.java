public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        if (k > n / 2) {
            return fastMaxProfit(prices);
        }
        int[][] dp = new int[k + 1][n];
        
        for (int i = 1; i <= k; ++i) {
            int tmpMax = -prices[0];
            for (int j = 1; j < n; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        
        return dp[k][n - 1];
    }
    
    public int fastMaxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            maxProfit += (prices[i] > prices[i - 1]) ? prices[i] - prices[i - 1] : 0; 
        }
        return maxProfit;
    }
}
