public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = A.length;
        for(int i = 0; i < size; ++i)
            if(A[i] == elem){
                A[i] = A[--size];
                --i;
            }
        return size;
    }
}