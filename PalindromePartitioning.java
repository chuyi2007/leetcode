public class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
        }
        for (int i = 1; i < s.length(); ++i) {
            dp[i][i - 1] = s.charAt(i) == s.charAt(i - 1);
            for (int j = i - 2; j >= 0; --j) {
                dp[i][j] = dp[i - 1][j + 1] && s.charAt(i) == s.charAt(j);
            }
        }
        return constructPalindromes(dp, s, s.length() - 1);
    }
    
    public List<List<String>> constructPalindromes(
        boolean[][] dp, 
        String s,
        int index
    ) {
        List<List<String>> palindromes = new ArrayList<>();
        if (index < 0) {
            palindromes.add(new ArrayList<>());
        }
        for (int i = index; i >= 0; --i) {
            if (dp[index][i]) {
                for (List<String> tmp: constructPalindromes(dp, s, i - 1)) {
                    tmp.add(s.substring(i, index + 1));
                    palindromes.add(new ArrayList<>(tmp));
                }       
            }
        }
        return palindromes;
    }
}
