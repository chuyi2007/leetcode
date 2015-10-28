public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0, end = 0;
        int max = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (set.contains(c)) {
                ++start;
                end = start;
                set.clear();
            } else {
                set.add(c);
                ++end;
            }
            max = Math.max(max, end - start);
        }
        max = Math.max(max, end - start);
        return max;
    }
}
