//O(N)
public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //O(N) time, extra space
        int size = A.length;
        int[] L = new int[size];
        int max = 0;
        for(int i = 0; i < size; ++i){
            if(A[i] > max)
                max = A[i];
            L[i] = max;
        }
        int[] R = new int[size];
        max = 0;
        for(int i = size - 1; i >= 0; --i){
            if(A[i] > max)
                max = A[i];
            R[i] = max;
        }
        int result = 0;
        for(int i = 0; i < size; ++i){
            result += Math.min(L[i], R[i]) - A[i];
        }
        return result;
    }
}