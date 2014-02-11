public class Solution {
    public int divide(int dividend, int divisor) {
        long result = 0L;
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor);
        while (a >= b) {
            long tmpDividend = a >> 1;
            long tmpDivisor = b;
            int count = 1;
            while (tmpDivisor <= tmpDividend) {
                tmpDivisor = tmpDivisor << 1;
                count = count << 1;
            }
            result += count;
            a -= tmpDivisor;
        }
        return dividend > 0 && divisor > 0
                || dividend < 0 && divisor < 0 ? (int)result : (int)-result;
    }
}