public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (s3.length() != m + n) {
            return false;
        }
        if (m == 0) {
            return s3.equals(s2);
        }
        if (n == 0) {
            return s3.equals(s1);
        }
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; ++i) {
            dp[i][0] = s3.substring(0, i).equals(s1.substring(0, i));
        }
        for (int j = 1; j <=n; ++j) {
            dp[0][j] = s3.substring(0, j).equals(s2.substring(0, j));
        }
        
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1] [j] && s3.charAt(i + j - 1) == s1.charAt(i - 1)
                        || dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);
            }
        }
        return dp[m][n];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len3 != len1 + len2) {
	       return false;
        }
        if (len1 == 0 || len2 == 0) {
	       return s1.equals(s3) || s2.equals(s3);
        }
        if (s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)) {
            return isInterleave(s1.substring(1), s2, s3.substring(1))
            || isInterleave(s1, s2.substring(1), s3.substring(1));
        }
        else if (s2.charAt(0) == s3.charAt(0)) {
            return isInterleave(s1, s2.substring(1), s3.substring(1));
        }
        else if (s1.charAt(0) == s3.charAt(0)) {
            return isInterleave(s1.substring(1), s2, s3.substring(1));
        }
        else {
	       return false;
       }
    }
}