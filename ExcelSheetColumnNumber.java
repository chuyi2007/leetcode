public class Solution {
    public int titleToNumber(String s) {
        char base = 'A';
        int result = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            int cur = s.charAt(i) - base + 1;
            result += (int) cur * Math.pow(26, s.length() - i - 1);
        }
        return result;
    }
}
