public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sl = S.length();
        int tl = T.length();
        
        int[] knownTable = new int[256];
        int[] searchTable = new int[256];
        
        for(int i = 0; i < T.length(); ++i)
            ++knownTable[(int)T.charAt(i)];
        int count = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
        // i as start pointer, j as end pointer, i < j
        for(int i = 0, j = 0; j <= sl;){
            //move j to right if not found a substring in S contains T
            if(count != tl && j != sl){
                char c = S.charAt(j);
                if(T.contains(String.valueOf(c))){
                    ++searchTable[(int)c];
                    if(searchTable[(int)c] <= knownTable[(int)c])
                        ++count;
                    if(count == tl){
                        int len = j - i + 1;
                        if(min > len){
                            min = len;
                            result = S.substring(i, j + 1);
                        }
                    }
                }
                ++j;
            }
            //move i to right if found a substring in S contains T
            else{
                char c = S.charAt(i);
                if(count == tl){
                    int len = j - i;
                    if(min > len){
                        min = len;
                        result = S.substring(i, j);
                    }
                }
                if(T.contains(String.valueOf(c))){
                    --searchTable[(int)c];
                    if(searchTable[(int)c] < knownTable[(int)c])
                        --count;
                }
                ++i;
                
                //important to avoid infinite loop
                if(i > j - tl)
                    break;
            }
        }
        return result;
    }
    
    //Can not pass large test
    public String naiveSearch(String S, String T){
        int sl = S.length();
        int tl = T.length();
        int min = Integer.MAX_VALUE;
        String result = "";
        for(int i = 0; i < sl; i++){
            for(int j = i + tl - 1; j < sl; j++){
                String tmpT = T;
                for(int k = i; k <= j; k++){
                    char c = S.charAt(k);
                    if(tmpT.contains(String.valueOf(c))){
                        int start = tmpT.indexOf(c);
                        tmpT = tmpT.substring(0, start) + tmpT.substring(start + 1);
                    }
                }
                if(tmpT.length() == 0){
                    if(min > j - i + 1){
                        result = S.substring(i,j + 1);
                        min = j - i + 1;
                    }
                }
            }
        }
        return result;
    }
}