public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; ++i) {
            reversed += n & 1;
            n >>>= 1;
            if (i < 31) {
                reversed <<= 1;
            }
        }
        return reversed;
    }
}
