public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //O(N^2) solution
        /*
        if(A.length == 0 || A.length == 1)
            return A.length;
        int size = A.length;
        for(int i = 0, j = 1; j < size;){
            if(A[i] == A[j]){
                for(int k = j; k < size; ++k)
                    A[k - 1] = A[k];
                --size;
            }
            else{
                ++i;
                ++j;
            }
        }
        return size;
        */
        int j = 0, n = A.length;
        if(n < 1)   return 0;
        for(int i = 0; i < n;){
            while(i < n && A[i] == A[j])
                ++i;
            if(i < n)
                A[++j] = A[i];
        }
        return j + 1;
    }
}