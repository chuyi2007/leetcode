public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int uni = 0;
        int dupCount = 0;
        for (int i = 0; i < A.length; ++i) {
            while (i < A.length - 1 && A[i] == A[i + 1]) {
                ++i;
                ++dupCount;
                if (dupCount < 2) {
                    A[uni++] = A[i];
                }
            }
            A[uni++] = A[i];
            dupCount = 0;
        }
        return uni;
    }
}