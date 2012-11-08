public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = s.length();
        if(size < 2)    return s;
        String max = "";
        for(int i = 0; i < s.length(); ++i){
            String l = findLongest(i - 1, i + 1, s);
            if(max.length() < l.length()) max = l;
            l = findLongest(i, i+1, s);
            if(max.length() < l.length())   max = l;
        }
        return max;
    }
    
    public String findLongest(int j, int k, String s){
        while(j >= 0 && k <= s.length() - 1)
            if(s.charAt(j) == s.charAt(k)){
                --j;
                ++k;
            }
            else    break;
        return s.substring(j+1, k);    
    }
}