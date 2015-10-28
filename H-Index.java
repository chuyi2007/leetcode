public class Solution {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length + 1];
        for (int i = 0; i < citations.length; ++i) {
            count[Math.min(citations[i], citations.length)]++;
        }
        int countRight = citations.length;
        for (int i = 0; i <= citations.length; ++i) {
            if (i > countRight) {
                return countRight;
            }
            countRight -= count[i];
            if (i > countRight) {
                return i;
            }
        }
        return 0;
    }
}
