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
            String a1 = s1.substring(0, i);
            String b1 = s1.substring(i, n);
            String a2 = s2.substring(0, i);
            String b2 = s2.substring(i, n);
            String x1 = s2.substring(0, n - i);
            String y1 = s2.substring(n - i, n);
            
            if (isScramble(a1, a2) && isScramble(b1, b2)) {
                return true;
            }
            else if (isScramble(a1, y1) && isScramble(b1, x1)) {
                return true;
            }
        }
        
        return false;
    }
}