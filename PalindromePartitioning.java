public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
        }
        for (int i = 1; i < s.length(); ++i) {
            dp[i][i - 1] = s.charAt(i) == s.charAt(i - 1);
            for (int j = i - 2; j >= 0; --j) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i - 1][j + 1];
            }
        }
        
        return partitionHelper(s, dp, s.length() - 1);
    }
    
    public ArrayList<ArrayList<String>> partitionHelper(
        String s, boolean[][] dp, int index) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (index < 0) {
            result.add(new ArrayList<String>());
            return result;
        }
        
        for (int i = index; i >= 0; --i) {
            if (dp[index][i]) {
                for (ArrayList<String> sentence: partitionHelper(s, dp, i - 1)) {
                    sentence.add(s.substring(i, index + 1));
                    result.add(new ArrayList<String>(sentence));
                }
            }
        }
        return result;
    }
}