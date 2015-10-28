public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] isInDict = new boolean[s.length() + 1];
        isInDict[0] = true;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = s.length(); j > i; --j) {
                if (isInDict[i] && wordDict.contains(s.substring(i, j))) {
                    isInDict[j] = true;
                }
            }
        }
        return isInDict[s.length()];
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
