//O(N)
public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0) return false;
        int start = 0, end = s.length() - 1;
        while(start < s.length() 
            && Character.isWhitespace(s.charAt(start)))  
            ++start;
        while(end >= 0 
            && Character.isWhitespace(s.charAt(end)))    
            --end;
        if(start > end)
            return false;
        if(start < s.length() 
            && (s.charAt(start) == '+'||s.charAt(start) == '-')) 
            ++start;
        boolean num = false;
        boolean exp = false;
        boolean dot = false;
        while(start <= end){
            char c = s.charAt(start);
            if(Character.isDigit(c))
                num = true;
            else if(c == '.'){
                if(exp || dot)
                    return false;
                dot = true;
            }
            else if(c == 'e'){
                if(exp || !num || start == end)
                    return false;
                exp = true;
            }
            else if(c == '+' || c == '-'){
                if(s.charAt(start - 1) != 'e')
                    return false;
            }
            else{
                return false;
            }
            ++start;
        }
        return num;
    }
}