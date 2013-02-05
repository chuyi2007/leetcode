public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int marker = A.length - 1;
        for(int i = A.length - 1; i >= 0; --i){
            if(i + A[i] >= marker)
                marker = i;
        }
        return marker == 0;
    }
}