public class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        int j = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == s.charAt(j)) {
                ++j;
            }
        }
        if (j == s.length()) {
            return s;
        }
        String suffix = s.substring(j);
        return new StringBuilder(suffix).reverse().toString() + 
            shortestPalindrome(s.substring(0, j)) +
            suffix;
    }
}
