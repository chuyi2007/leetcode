public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] notMatch = new boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, notMatch);
    }
    
    public boolean isMatch(String s, String p, boolean[][] notMatch) {
        if (notMatch[s.length()][p.length()]) {
            return false;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1) {
            return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }
        if (p.charAt(1) == '*') {
            int index = 0;
            while (index < s.length() && (s.charAt(index) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s.substring(++index), p.substring(2))) {
                    return true;
                } else {
                    notMatch[s.length() - index][p.length() - 2] = true;
                }
            }
            return isMatch(s, p.substring(2));
        }
        return s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && 
            isMatch(s.substring(1), p.substring(1));
    }
}
