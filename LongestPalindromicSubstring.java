public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); ++i) {
            String s1 = getLongestString(s, i, i);
            res = s1.length() > res.length() ? s1 : res;
            if (i < s.length()  - 1 && s.charAt(i) == s.charAt(i + 1)) {
                String s2 = getLongestString(s, i, i + 1);
                res = s2.length() > res.length() ? s2 : res;
            }
        }
        return res;
    }
    
    public String getLongestString(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            --i;
            ++j;
        }
        return s.substring(i + 1, j);
    }
}
