//O(N^4)
public class Solution {
    //Can not pass the large test case
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s1.length();
        if(len == 1)
            return s1.equals(s2);
        for(int i = 1; i < len; ++i){
            String a1 = s1.substring(0, i);
            String a2 = s2.substring(0, i);
            
            String b1 = s1.substring(i, len);
            String b2 = s2.substring(i, len);
            
            String x1 = s1.substring(0, len - i);
            String x2 = s2.substring(0, len - i);
            
            String y1 = s1.substring(len - i, len);
            String y2 = s2.substring(len - i, len);
            
            if(isScramble(a1, a2) && isScramble(b1, b2))
                return true;
            if(isScramble(a1, y2) && isScramble(b1, x2))
                return true;
            if(isScramble(x1, b2) && isScramble(y1, a2))
                return true;
            if(isScramble(x1, x2) && isScramble(y1, y2))
                return true;
        }
        return false;
    }
}