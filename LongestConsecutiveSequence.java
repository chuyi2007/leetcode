public class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : num) {
            set.add(i);
        }
        int max = 0;
        while (!set.isEmpty()) {
            int val = set.iterator().next();
            int start = val;
            while (set.contains(start - 1)) {
                set.remove(start);
                --start;
            }
            int end = val;
            while (set.contains(end + 1)) {
                set.remove(end);
                ++end;
            }
            max = Math.max(end - start + 1, max);
            set.remove(val);
        }
        return max;
    }
}