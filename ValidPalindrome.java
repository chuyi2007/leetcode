public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = s.length();
        if(size == 0)
            return true;
        s = s.toLowerCase();
        boolean result = true;
        for(int i = 0, j = size - 1; i <= j;){
            while(i < size - 1 && !validChar(s.charAt(i)))
                ++i;
            while(j > 0 && !validChar(s.charAt(j)))
                --j;
            if(i > j)
                break;
            if(s.charAt(i) != s.charAt(j)){
                result = false;
                break;
            }
            ++i;
            --j;
        }
        return result;
    }
    
    public boolean validChar(char c){
        if(c >= 'a' && c <= 'z' || c >= '0' && c <= '9'){
            return true;
        } 
        else
            return false;
    }
}