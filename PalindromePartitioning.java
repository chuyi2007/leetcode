public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int j = 1; j <= n; ++j) {
            dp[j][j] = true;
            for (int i = j; i > 0; --i) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = j - i < 2 || dp[i + 1][j - 1];
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> bt = new ArrayList<>();
        partition(res, bt, s, dp, 1);
        return res;
    }
    
    public void partition(
        List<List<String>> res,
        List<String> bt,
        String s,
        boolean[][] dp,
        int index
    ) {
        if (index == s.length() + 1) {
            res.add(new ArrayList<>(bt));
            return;
        }
        for (int i = index; i <= s.length(); ++i) {
            if (dp[index][i]) {
                bt.add(s.substring(index - 1, i));
                partition(res, bt, s, dp, i + 1);
                bt.remove(bt.size() - 1);
            }
        }
    }
}
