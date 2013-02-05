import java.util.HashMap;
 
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //straight forward O(N^2) method
        int max = 0;
        for(int i = 0; i < s.length(); ++i){  
            String sub = s.substring(i, i+1);
            for(int j = i + 1; j < s.length(); ++j){
                if(!sub.contains(s.substring(j, j+1)))
                    sub += s.substring(j, j+1);
                else
		    break;
            }
            if(max < sub.length())
                max = sub.length();
        }
        return max;
    }
}

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int start = 0, end = 0;
        int max = 0;
        if(s.length() < 1)
            return max;
        HashSet<Character> set = new HashSet<Character>();
        
        while(end < s.length() && start <= end){
            char c = s.charAt(end);
            if(!set.contains(c)){
                set.add(c);
                ++end;
            }
            else{
                if(set.size() > max)
                    max = set.size();
                while(start < end && set.contains(c)){
                    set.remove(s.charAt(start));
                    ++start;
                }
            }
        }
        if(end - start > max)
            max = end - start;
        return max;
    }
}