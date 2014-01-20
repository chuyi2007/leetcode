public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int uni = -1;
        for (int i = 0; i < A.length; ++i) {
            while (i < A.length - 1 && A[i] == A[i + 1]) {
                ++i;
            }
            A[++uni] = A[i];
        }
        return uni + 1;
    }
}

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }
        int len = 0;
        for (int i = 0; i < A.length; ++i) {
            if (i == A.length - 1) {
                ++len;
            }
            else if (A[i] != A[i + 1]) {
                A[++len] = A[i + 1];
            }
        }
        return len;
    }
}