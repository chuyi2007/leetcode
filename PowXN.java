public class Solution {
    public double myPow(double x, int n) {
        boolean positive = n > 0;
        n = Math.abs(n);
        double odd = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                odd *= x;
            }
            x *= x;
            n >>= 1;
        }
        return positive ? odd : 1 / odd;
    }
}
