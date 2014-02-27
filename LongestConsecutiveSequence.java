public class Solution {
    public int longestConsecutive(int[] num) {
        int max = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < num.length; ++i) {
            set.add(num[i]);
        }
        while (!set.isEmpty()) {
            int val = set.iterator().next();
            set.remove(val);
            int start = val - 1;
            while (set.contains(start)) {
                set.remove(start--);
            }
            int end = val + 1;
            while (set.contains(end)) {
                set.remove(end++);
            }
            max = Math.max(end - start - 1, max);
        }
        return max;
    }
}