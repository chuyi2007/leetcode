public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s.length() == 0 || dict.contains(s)) {
            return true;
        }
        
        //s.substring(i, j) found in dict
        boolean[] dp = new boolean[s.length() + 1];
        
        dp[0] = true;
        
        for (int i = 0; i <= s.length(); ++i) {
            if (dp[i]) {
                for (int j = i + 1; j <= s.length(); ++j) {
                    if (dict.contains(s.substring(i, j))) {
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0 || dict.contains(s))
            return true;
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            if (checkDP(dp, i)) {
                for (int j = i + 1; j <= n; ++j) {
                    if (dict.contains(s.substring(i, j))) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return checkDP(dp, n);
    }
    
    public boolean checkDP(boolean[][] dp, int j) {
        for (int i = 0; i <= j; ++i) {
            if (dp[i][j]) {
                return true;
            }
        }
        return false;
    }
}