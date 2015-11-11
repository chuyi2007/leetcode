public class Solution {
    public boolean canWin(String s) {
        if (s.length() < 2) {
            return false;
        }
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.startsWith("++", i)) {
                String next = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(next)) {
                    return true;
                }
            }
        }
        return false;
    }
}
