public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = strs.length;
        if(size == 0)   return "";
        if(size == 1)   return strs[0];
        String prefix = strs[0];
        for(int i = 1; i < size; ++i){
            if(!strs[i].startsWith(prefix)){
                String localPrefix = "";
                for(int j = prefix.length() - 1; j >= 0; --j)
                    if(strs[i].startsWith(prefix.substring(0, j))){
                        localPrefix = prefix.substring(0, j);
                        break;
                    }
                prefix = localPrefix;
            }
        }
        return prefix;
    }
}