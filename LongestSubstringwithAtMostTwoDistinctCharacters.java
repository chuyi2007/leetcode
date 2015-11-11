public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.size() == 2 && !map.containsKey(c)) {
                max = Math.max(i - left, max);
                int leftMost = Integer.MAX_VALUE;
                for (int val : map.values()) {
                    leftMost = Math.min(leftMost, val);
                }
                left = leftMost + 1;
                map.remove(s.charAt(leftMost));
            }
            map.put(c, i);
        }
        max = Math.max(s.length() - left, max);
        return max;
    }
}
