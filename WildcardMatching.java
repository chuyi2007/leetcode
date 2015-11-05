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
        if (p.charAt(0) == '?') {
            if (s.length() == 0) {
                return false;
            } else if (!isMatch(s.substring(1), p.substring(1), notMatch)) {
                notMatch[s.length() - 1][p.length() - 1] = true;
                return false;
            }
            return true;
        }
        if (p.charAt(0) == '*') {
            int index = 0;
            while (index < s.length()) {
                if (isMatch(s.substring(index), p.substring(1), notMatch)) {
                    return true;
                } else {
                    notMatch[s.length() - index][p.length() - 1] = true;
                }
                ++index;
            }
            return false;
        }
        if (s.length() < 1 || s.charAt(0) != p.charAt(0)) {
            return false;
        } else if (!isMatch(s.substring(1), p.substring(1), notMatch)) {
            notMatch[s.length() - 1][p.length() - 1] = true;
            return false;
        }
        return true;
    }
}
