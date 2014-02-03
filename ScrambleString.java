public class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n == 0) {
            return true;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!(new String(c1)).equals(new String(c2))) {
            return false;
        }
        else if (n == 1) {
            return true;
        }
        for (int i = 1; i < n; ++i) {
            if (isScramble(s1.substring(0, i), 
                           s2.substring(0, i)) 
                && isScramble(s1.substring(i, n), 
                              s2.substring(i, n))) {
                return true;
            }
            else if (isScramble(s1.substring(0, i), 
                                s2.substring(n - i, n)) 
                    && isScramble(s1.substring(i, n), 
                                  s2.substring(0, n - i))) {
                return true;
            }
        }
        return false;
    }
}