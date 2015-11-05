public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] len = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            len[i] = n - i - 1;
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    len[i] = Math.min(len[i], len[j + 1] + 1);
                }
            }
        }
        return len[0];
    }
}
