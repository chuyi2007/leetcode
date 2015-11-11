public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        int n = s.length();
        int[] len = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            len[i] = i - 1;
        }
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int j = 1; j <= n; ++j) {
            dp[j][j] = true;
            for (int i = j; i > 0; --i) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    len[j] = Math.min(len[i - 1] + 1, len[j]);
                }
            }
        }
        return len[n];
    }
}
