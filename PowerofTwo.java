public class Solution {
    public boolean isPowerOfTwo(int n) {
        while (n > 0) {
            if ((n & 1) == 1) {
                n >>= 1;
                return n == 0;
            } else {
                n >>= 1;
            }
        }
        return false;
    }
}
