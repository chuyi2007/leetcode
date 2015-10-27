public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<Integer>();
        while (n != 1) {
            n = squareSum(n);
            if (visited.contains(n)) {
                return false;
            } else {
                visited.add(n);
            }
        }
        return true;
    }
    
    public int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
