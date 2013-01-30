public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int total = 0;
        for(int i = 0; i < prices.length; ++i){
            int max1 = 0, max2 = 0;
            int low = Integer.MAX_VALUE;
            for(int j = 0; j <=i; ++j){
                if(prices[j] < low)
                    low = prices[j];
                int val = prices[j] - low;
                if(val > max1)
                    max1 = val;
            }
            low = Integer.MAX_VALUE;
            for(int j = i; j < prices.length; ++j){
                if(prices[j] < low)
                    low = prices[j];
                int val = prices[j] - low;
                if(val > max2)
                    max2 = val;
            }
            if(total < max1 + max2)
                total = max1 + max2;
        }
        return total;
    }
}