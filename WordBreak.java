public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s.length() == 0 || dict.contains(s)) {
            return true;
        }
        
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