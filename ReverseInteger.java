public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean flag = x >= 0 ? true : false;
        x = Math.abs(x);
        int result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return flag ? result : -result;
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
        }
        else {
            y = y * 10 + x % 10;
            x = x / 10;
            return reverseHelper(x, y);
        }
    }
}