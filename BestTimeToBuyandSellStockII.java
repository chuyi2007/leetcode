public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int cur = -1;
        int val = 0;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i] < prices[i + 1] && cur == -1){
                cur = prices[i];
            }
            if(prices[i] > prices[i + 1] && cur != -1){
                val += prices[i] - cur;
                cur = -1;
            }
        }
        if(cur != -1)
	    val += prices[prices.length - 1] - cur;
        return val;
    }
}