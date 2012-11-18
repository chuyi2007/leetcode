public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length <= 1)   return 0;
        int marker = A.length - 1;
        int count = 0;
        int[] min = new int[A.length];
        for(int i = A.length -2; i>=0; i--){
            if(A[i] >= marker - i){
                int tmpLength= Math.min(min.length, A[i] + i + 1);
                int tmpMin = A.length;
                for(int j = i + 1; j < tmpLength; j++)
                    if(min[j] < tmpMin)
                        tmpMin = min[j];
                min[i] = tmpMin + 1;
                marker = i;
            }
            else
                min[i] = A.length;
        }
        return min[0];
    }
}