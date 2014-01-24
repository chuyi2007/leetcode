public class Solution {
    public String getPermutation(int n, int k) {
        int[] A = new int[n];
        for (int i = 0; i < A.length; ++i) {
            A[i] = i + 1;
        }
        for (int i = 1; i < k; ++i) {
            nextPermutation(A);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; ++i) {
            sb.append(A[i]);
        }
        return sb.toString();
    }
    
    public void nextPermutation(int[] A) {
        int index = -1;
        for (int i = A.length - 1; i > 0; --i) {
            if (A[i - 1] < A[i]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            for (int i = 0; i < A.length; ++i) {
                A[i] = i + 1;
            }
        }
        else {
            for (int i = A.length - 1; i >= 0; --i) {
                if (A[i] > A[index]) {
                    swap(A, i, index);
                    break;
                }
            }
            for (int j = A.length - 1, i = index + 1; i < j;) {
                swap(A, j--, i++);
            }
        }
    }
    
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}