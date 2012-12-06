public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = A.length;
        if(size == 0 || size == 1)
            return size;
        int count = 1;
        for(int i = 0, j = 1; j < size;){
            if(A[i] == A[j]){
                ++count;
                if(count > 2){
                    for(int k = j; k < size; ++k)
                        A[k - 1] = A[k];
                    --size;
                }
                else
                    ++j;
            }
            else{
                i = j - 1;
                ++i;
                ++j;
                count = 1;
            }
        }
        return size;
    }
}