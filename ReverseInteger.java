public class Solution {
    public int reverse(int x) {
        boolean negative = x < 0;
        x = Math.abs(x);
        int y = 0;
        while (x > 0) {
            if ((Integer.MAX_VALUE - x % 10) / 10 < y) {
                return 0;
            }
            y = y * 10 + x % 10;
            x /= 10;
        }
        return negative ? -y : y;
    }
}

public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return reverseHelper(x, 0);
    }
    
    public int reverseHelper(int x, int y){
        if (x == 0) {
            return y;
        } else {
            y = y * 10 + x % 10;
            x = x / 10;
            return reverseHelper(x, y);
        }
    }
}
