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

public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = A.length;
        for(int i = 0; i < size; ++i){
            if(A[i] == elem){
                swap(A, i, --size);
                --i;
            }
        }
        return size;
    }
    
    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}