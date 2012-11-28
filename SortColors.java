public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        onePass(A);
    }
    
    public void onePass(int[] A){
        int li = 0, ri = A.length - 1;
        for(int mi = 0; mi <= ri; ++mi){
            if(A[mi] == 2){
                swap(A, mi, ri);
                --mi;
                --ri;
            }
            else if(A[mi] == 0){
                swap(A, mi, li);
                ++li;
            }
        }
    }
    
    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public void twoPass(int[] A){
        int[] counts = new int[3];
        for(int i = 0; i < A.length; i++){
            ++counts[A[i]];
        }
        for(int i = 0; i < A.length; i++){
            if(i < counts[0])
                A[i] = 0;
            else if ( i < counts[0] + counts[1])
                A[i] = 1;
            else
                A[i] = 2;
        }
    }
    public void brutalSearch(int[] A){
        int n = A.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(A[i] < A[j]){
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
        }
    }
}