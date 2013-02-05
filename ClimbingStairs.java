public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        int f0 = 1, f1 = 1, f2 = 0;
        for(int i = 2; i <= n; i++){
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }
}