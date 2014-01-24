//Compare number by number, never overflow, in constant space
public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 0) {
            return false;
        }
        int div = 1;
        //find largest divisor
        while (x / div >= 10) {
            div *= 10;
        }
        while (div > 1) {
            int l = x / div;
            int r = x % 10;
            if(l != r) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}