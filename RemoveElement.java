public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = A.length;
        for(int i = 0; i < size;){
            if(A[i] == elem)    --size;
            else    ++i;
            if(i == size)   return size;
            A[i] = A[i + A.length - size];
        }
        return size;
    }
}