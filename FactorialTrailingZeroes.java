public class Solution {
    public int trailingZeroes(int n) {
        int q = n / 5;
        if (q == 0) {
            return 0;
        }
        return q + trailingZeroes(q);
    }
}
