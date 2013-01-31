public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //First solution, use O(n) space
        /*
        int[] min = new int[A.length];
        int marker = A.length - 1;
        for(int i = A.length - 2; i >= 0; --i){
            if(marker - i <= A[i]){        
                int maxJump = Math.min(A.length, A[i] + i + 1);
                int thisMin = A.length;
                for(int j = i + 1; j < maxJump; ++j)
                    if(min[j] < thisMin)
                        thisMin = min[j];
                    min[i] = thisMin + 1;
                    marker = i;
            }
            else
                min[i] = A.length;
        }
        return min[0];
        */
        //Greedy Algorithm, always jump to max distance
        int max = A[0];
        int min = 1;
        int step = 0;
        if(A.length == 1)   return 0;
        while(max < A.length - 1){
            int m = max;
            for(int i = min; i <= max; ++i)
                if(m < A[i] + i)
                    m = A[i] + i;
            min = max + 1;
            max = m;
            ++step;
        }
        return step + 1;
    }
}