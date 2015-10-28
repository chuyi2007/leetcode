public class Solution {
    public int maxProfit(int[] prices) {
        int curStock = -1;
        int profit = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i] < prices[i + 1] && curStock == -1) {
                curStock = prices[i];
            }
            if (prices[i] >= prices[i + 1] && curStock != -1) {
                profit += prices[i] - curStock;
                curStock = -1;
            }
        }
        if (curStock != -1 && prices[prices.length - 1] > curStock) {
            profit += prices[prices.length - 1] - curStock;
        }
        return profit;
    }
}
