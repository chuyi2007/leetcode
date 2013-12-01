public class Solution {
    public int minCut(String s) {
        int[] len = new int[s.length() + 1];
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i <= s.length(); ++i) {
            len[i] = s.length() - i - 1;
        }
        
        for (int i = s.length() - 2; i >= 0; --i) {
            for (int j = i; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j) && (j - i<= 2 || dp[i + 1] [j - 1])) {
                    dp[i][j] = true;
                    len[i] = Math.min(len[i], len[j + 1] + 1);
                }
            }
        }
        
        return len[0];
    }
}