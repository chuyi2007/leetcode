public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String result = "1";
        for(int i = 1; i < n; ++i){
            String tmp = "";
            
            int curCount = 1;
            for(int j = 0; j < result.length(); ++j){
                char curChar = result.charAt(j);
                if(j == result.length() - 1 
                || curChar != result.charAt(j + 1)){
                    tmp += String.valueOf(curCount)
                    + Character.toString(curChar);
                    curCount = 1;
                }
                else{
                    curCount++;
                }
            }
            result = tmp;
        }
        return result;
    }
}