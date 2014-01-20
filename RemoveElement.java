public class Solution {
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        for (int i = 0; i < len; ++i) {
            if (A[i] == elem) {
                A[i--] = A[--len];
            }
        }
        return len;
    }
}