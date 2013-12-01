public class Solution {
    public int candy(int[] ratings) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = ratings.length;
        int[] A = new int[n];
        int[] B = new int[n];
        
        A[0] = 1;
        B[n - 1] = 1;
        
        int current = 1;
        for (int i = 1; i <= n - 1; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                ++current;
            }
            else {
                current = 1;
            }
            A[i] = current;
        }
        
        current = 1;
        for (int i = n - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                ++current;
            }
            else {
                current = 1;
            }
            B[i] = current;
        }
        
        int count = 0;
        for (int i = 0; i < n; ++i) {
            count += Math.max(A[i], B[i]);    
        }
        return count;
    }
}