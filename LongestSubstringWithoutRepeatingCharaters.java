public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int i = 0, j = 0;
        int max = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (set.contains(c)) {
                max = Math.max(j - i, max);
                set.clear();
                ++i;
                j = i;
            }
            else {
                set.add(c);
                ++j;
            }
        }
        max = Math.max(j - i, max);
        return max;
    }
}