public class Solution {
    // A xor A = 0, so A^B^A = B
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int index = A.length;
        while (--index > 0) {
            A[index - 1] ^= A[index];
        }
        return A[0];
    }
}