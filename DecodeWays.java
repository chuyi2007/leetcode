public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int f0 = validCode(s.substring(0, 1)) ? 1 : 0;
        if (s.length() == 1) {
            return f0;
        }
        int f1 = (validCode(s.substring(1, 2)) ? f0 : 0) + (validCode(s.substring(0, 2)) ? 1 : 0);
        
        for (int i = 2; i < s.length(); ++i) {
            int f2 = (validCode(s.substring(i, i + 1)) ? f1 : 0) + (validCode(s.substring(i - 1, i + 1)) ? f0 : 0);
            f0 = f1;
            f1 = f2;
        }
        
        return f1;
    }
    
    public boolean validCode(String str) {
        if (str.charAt(0) == '0') {
            return false;
        }
        int val = Integer.parseInt(str);
        return val >= 1 && val <= 26;
    }
}
