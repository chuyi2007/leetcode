public class Solution {
    public int divide(int dividend, int divisor) {
        boolean isPositive = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0 ? true : false;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long res = 0L;
        while (a >= b) {
            // very important, for edge cases
            long tmpDividend = a >> 1;
            long tmpDivisor = b;
            int count = 1;
            while (tmpDividend >= tmpDivisor) {
                tmpDivisor <<= 1;
                count <<= 1;
            }
            res += count;
            a -= tmpDivisor;
        }
	// for Integer.MIN_VALUE / -1
        if (isPositive && -res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return isPositive ? (int) res : (int) -res;
    }
}
