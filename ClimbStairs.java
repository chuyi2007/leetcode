public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] f = new int[2];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i <= n; i++){
            int tmp = f[0] + f[1];
            f[0] = f[1];
            f[1] = tmp;
        }
        return f[1];
    }
}