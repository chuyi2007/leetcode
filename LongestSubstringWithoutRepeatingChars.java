public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return naiveSearch(s);
    }
    
    public int naiveSearch(String s){
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            String sub = s.substring(i, i+1);
            for(int j = i + 1; j < s.length(); j++){
                if(!sub.contains(s.substring(j, j+1))){
                    sub += s.substring(j, j+1);
                }
                else{
                    break;
                }
            }
            if(max < sub.length())
                max = sub.length();
        }
        return max;
    }
}