//O(M*N)
public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p.length() == 0)
            return s.length() == 0;
        if(p.charAt(0) != '*')
            if(s.length() > 0 && (s.charAt(0) == p.charAt(0) 
            || p.charAt(0) == '?'))
                return isMatch(s.substring(1), p.substring(1));
            else
                return false;
        int index = 1;
        while(index <= s.length()){
            if(isMatch(s.substring(index), p.substring(1)))
                return true;
            ++index;
        }
        return isMatch(s, p.substring(1));
    }
}