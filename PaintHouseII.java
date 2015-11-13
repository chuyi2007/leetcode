public class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int n = costs.length, k = costs[0].length;
        int[] dp = new int[k];
        int min1 = -1, min2 = -1;
        for (int i = 0; i < n; ++i) {
            // save the last min1 and min2
            int last1 = min1, last2 = min2;
            // save the last min1 and min2's dp values
            int t1 = last1 < 0 ? -1 : dp[last1], t2 = last2 < 0 ? -1 : dp[last2];
            min1 = -1;
            min2 = -1;
            for (int j = 0; j < k; ++j) {
                if (j != last1) {
                    dp[j] = (last1 < 0 ? 0 : t1) + costs[i][j];
                } else {
                    dp[j] = (last2 < 0 ? 0 : t2) + costs[i][j];
                }
                
                if (min1 < 0 || dp[j] < dp[min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || dp[j] < dp[min2]) {
                    min2 = j;
                }
            }
        }
        return dp[min1];
    }
}
