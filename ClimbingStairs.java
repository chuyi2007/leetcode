public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
            int fn1 = 1, fn2 = 2, fn3 = 0;
            for(int i = 3; i <= n; i++){
                fn3 = fn1 + fn2;
                fn1 = fn2;
                fn2 = fn3;
            }
            return fn3;
        
    }
}