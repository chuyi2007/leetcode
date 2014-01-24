public class Solution {
    public String longestPalindrome(String s) {
        String r = "";
        for (int i = 0; i < s.length(); ++i) {
            String l1 = findLongest(s, i, i);
            if (r.length() < l1.length()) {
                r = l1;
            }
            if (i < s.length() -1 && s.charAt(i) == s.charAt(i + 1)) {
                String l2 = findLongest(s, i, i + 1);
                if (r.length() < l2.length()) {
                    r = l2;
                }
            }
        }
        return r;
    }
    
    public String findLongest(String s, int i, int j) {
        while (i > 0 && j < s.length() - 1) {
            if (s.charAt(i - 1) != s.charAt(j + 1)) {
                break;
            }
            ++j;
            --i;
        }
        return s.substring(i, j + 1);
    }
}