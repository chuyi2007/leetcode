public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = A.length;
        int max = 0;
        for(int i : A)
            if(max < i)
                max = i;
        //bucket sort, put i to A[i - 1]
        for(int i = 0; i < size; i++){
            while(A[i] != i+1){
                if(A[i] <=0 || A[i] > size || A[i] == A[A[i] - 1]) break;
                int tmp = A[i];
                A[i] = A[tmp-1];
                A[tmp - 1] = tmp;
            }
        }
        
        for(int i = 0; i < size; i++)
            if(A[i] != i+1)
                return i+1;
        return max + 1;
    }
}

public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        while(i < A.length){
            if(A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] - 1])
                ++i;
            else {
                int tmp = A[i];
                A[i] = A[tmp - 1];
                A[tmp - 1] = tmp;
            }
        }
        
        for(int j = 0; j < A.length; ++j)
            if(A[j] != j + 1)
                return j + 1;

        return A.length + 1;
    }
}