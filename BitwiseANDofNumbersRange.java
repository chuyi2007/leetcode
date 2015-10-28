public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int steps = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            ++steps;
        }
        return m << steps;
    }
}
