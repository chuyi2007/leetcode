public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        
        dp[0][0] = true;
        
        for (int i = 0; i < n; ++i) {
            if (checkDp(dp, i)) {
                for (int j = i + 1; j <= n; ++j) {
                    if (dict.contains(s.substring(i, j))) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        
        return getWordList(s, dp, 0);
    }
    
    public ArrayList<String> getWordList(String s, boolean[][] dp, int index) {
        ArrayList<String> result = new ArrayList<String>();
        int n = s.length();
        if (index == n) {
            result.add("");
            return result;
        }
        else {
            for (int i = index + 1; i <= n; ++i) {
                if (dp[index][i]) {
                    for (String r : getWordList(s, dp, i)) {
                        if (r.length() > 0) {
                            r = s.substring(index, i) + " " + r;
                        }
                        else {
                            r = s.substring(index, i);
                        }
                        result.add(r);
                    }
                }
            }
        }
        return result;
    }
    
    public boolean checkDp(boolean[][] dp, int j) {
        for (int i = 0; i < dp.length; ++i) {
            if (dp[i][j]) {
                return true;
            }
        }
        return false;
    }
}