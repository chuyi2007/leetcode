import java.util.HashMap;
 
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //straight forward O(N^2) method
        /*
        int max = 0;
        for(int i = 0; i < s.length(); ++i){  
            String sub = s.substring(i, i+1);
            for(int j = i + 1; j < s.length(); ++j){
                if(!sub.contains(s.substring(j, j+1)))
                    sub += s.substring(j, j+1);
                else    break;
            }
            if(max < sub.length())
                max = sub.length();
        }
        return max;
        */
        
        //O(N) method with extra space
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0, len = 0, start = 0;
        for(int i = 0; i < s.length(); ++i){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
                ++len;
            }
            else{
                if(max < len)   max = len;
                int duplicate = map.get(s.charAt(i));
                for(int j = duplicate; j >= start; --j){
                    map.remove(s.charAt(j));
                    --len;
                }
                ++len;
                start = duplicate + 1;
                map.put(s.charAt(i), i);
            }
        }
        return Math.max(max, len);
    }
}