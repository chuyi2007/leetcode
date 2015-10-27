public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] tokens1 = version1.split("\\.");
        String[] tokens2 = version2.split("\\.");
        
        for (int i = 0; i < Math.max(tokens1.length, tokens2.length); ++i) {
            int v1 = i < tokens1.length ? Integer.parseInt(tokens1[i]) : 0;
            int v2 = i < tokens2.length ? Integer.parseInt(tokens2[i]) : 0;
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }
        return 0;
    }
}
