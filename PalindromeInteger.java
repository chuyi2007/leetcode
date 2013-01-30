public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //Compare number by number, never overflow, in constant space
        if(x < 0)   return false;
        int div = 1;
        //find largest divisor
        while(x/div >= 10)
            div *= 10;
        while(div > 1){
            int l = x / div;
            int r = x % 10;
            if(l != r)  return false;
            x = (x % div)/10;
            div /= 100;
        }
        return true;
    }
    
    //Reverse first, then compare, might overflow
    public boolean reverseIntMain(int x){
        if(x < 0)
            return false;
        int y = reverseInt(x, 0);
        if(x == y)
            return true;
        return false;
    }
    
    public int reverseInt(int x, int remain){
        if(x / 10 == 0)
            return remain * 10 + x;
        else{
            remain = remain * 10 + x %10;
            return reverseInt(x / 10, remain);
        }
    }
    
    //Easy, short, use Extra Space
    public boolean convertToString(int x){
        String xs = String.valueOf(x);
        for(int i = 0, j = xs.length() - 1; i < j; ++i, --j)
            if(xs.charAt(i) != xs.charAt(j))
                return false;
        return true;
    }
}