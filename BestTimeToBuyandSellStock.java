public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int min = Integer.MAX_VALUE, max = 0;
        for(int i = 0; i < prices.length; ++i){
            if(min > prices[i]) min = prices[i];
            int sale = prices[i] - min;
            if(max < sale) max = sale;
        }
        return max;
    }
}