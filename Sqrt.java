public class Solution {
    public int mySqrt(int x) {
        // return binarySearch(x);
        return newtonMethod(x);
    }
    
    public int newtonMethod(int x) {
        double eps = 10e-6;
        double sqrt = x;
        while (sqrt * sqrt - x > eps) {
            sqrt = sqrt - (sqrt * sqrt - x) / (2 * sqrt);
        }
        return (int)sqrt;
    }
    
    public int binarySearch(int x) {
        int min = 1, max = x;
        int minDiff = Integer.MAX_VALUE;
        int result = 0;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int diff = mid - x / mid;
            if (diff < 0 && -diff < minDiff) {
                result = mid;
                minDiff = -diff;
            } 
            if (diff > 0) {
                max = mid - 1;
            } else if (diff < 0) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return result;
        
    }
}
