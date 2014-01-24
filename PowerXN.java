public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        double odd = 1;
        boolean flag = n > 0;
        n = Math.abs(n);
        while (n > 0) {
            if (n % 2 == 1) {
                odd *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return flag ? odd : 1/odd;
    }
}