//O(log(M+N)), careful about overflow
public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = x, min = 1;
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        while (max >= min) {
            int mid = min + (max - min) / 2;
            int diff = mid - x / mid;
            if (diff <= 0 && -diff < minDiff) {
                minDiff = -diff;
                result = mid;
            }
            if (diff > 0) {
                max = mid - 1;
            }
            else if (diff < 0) {
                min = mid + 1;
            }
            else {
                return result;
            }
        }
        return result;
    }
}