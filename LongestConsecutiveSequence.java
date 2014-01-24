public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> clusters = new HashMap<Integer, Integer>();
        
        int max = 1;
        for (int i : num) {
            if (clusters.containsKey(i)) {
                continue;
            }
            clusters.put(i, 1);
            
            if (clusters.containsKey(i + 1)) {
                max = Math.max(updateCluster(clusters, i, i + 1), max);
            }
            
            if (clusters.containsKey(i - 1)) {
                max = Math.max(updateCluster(clusters, i - 1, i), max);
            }
        }
        return max;
    }
    
    public int updateCluster(HashMap<Integer, Integer> clusters, int left, int right) {
        int upper = right + clusters.get(right) - 1;
        int lower = left - clusters.get(left) + 1;
        int len = upper - lower + 1;
        clusters.put(upper, len);
        clusters.put(lower, len);
        return len;
    }
}