public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int one = 0, two = 0, three = 0;
        int n = A.length;
        while (--n >= 0) {
            two |= one & A[n];
            one ^= A[n];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}