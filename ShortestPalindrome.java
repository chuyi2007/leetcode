public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String result = null;
        int mid = (int) Math.ceil(s.length() / 2.0);
        for (int i = mid; i >= 0; --i) {
            if ((result = findLongestPalindrome(s, i - 1, i)) != null) {
                return result;
            }
            if ((result = findLongestPalindrome(s, i - 1, i - 1)) != null) {
                return result;
            }
        }
        return result;
    }
    
    public String findLongestPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            --l;
            ++r;
        }
        if (l >= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(s.substring(r));
        return sb.reverse().toString() + s;
    }
}
