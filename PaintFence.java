public class Solution {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int sameColorCount = k;
        int diffColorCount = k * (k - 1);
        for (int i = 2; i < n; ++i) {
            int tmp = diffColorCount;
            diffColorCount = (sameColorCount + diffColorCount) * (k - 1);
            sameColorCount = tmp;
        }
        return diffColorCount + sameColorCount;
    }
}
