public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        
        if (p.length() == 1) {
            return s.length() == 1 
                && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }
        
        if(p.charAt(1) == '*') {
            int index = 0;
            while (index < s.length() && (s.charAt(index) == p.charAt(0)
            || p.charAt(0) == '.')) {
                if (isMatch(s.substring(++index), p.substring(2))) {
                    return true;
                }
            }
            return isMatch(s, p.substring(2));
        }
        
        return s.length() >= 1 
            && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') 
            && isMatch(s.substring(1), p.substring(1));
    }
}