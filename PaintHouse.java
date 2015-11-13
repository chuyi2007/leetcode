public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int k = 3;
        int[] dp = new int[k];
        dp[0] = costs[0][0];
        dp[1] = costs[0][1];
        dp[2] = costs[0][2];
        for (int i = 1; i < costs.length; ++i) {
            int[] tmp = new int[k];
            for (int j = 0; j < k; ++j) {
                tmp[j] = costs[i][j] + Math.min(dp[(j + 1) % k], dp[(j + 2) % k]);
            }
            dp = tmp;
        }
        return Math.min(Math.min(dp[0], dp[1]), dp[2]);
    }
}
