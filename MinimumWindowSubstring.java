//O(N) solution
public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int min = S.length() + 1;
        int[] match = new int[256];
        int[] target = new int[256];
        
        for(int i = 0; i < T.length(); ++i){
            ++target[(int)T.charAt(i)];
        }
        
        int count = T.length();
        int start = -1, end = -1;
        //i as start index, j as end index
        for(int i = 0, j = 0; i <= j && j <= S.length();){
            if(count > 0){
                if(j == S.length())
                    break;
                char ce = S.charAt(j);
                if(T.contains(String.valueOf(ce))){
                    ++match[(int)ce];
                    if(match[(int)ce] <= target[(int)ce])
                        --count;
                }
                ++j;
            }
            
            if(count == 0){
                char cs = S.charAt(i);
                int len = j - i;
                if(len < min){
                    min = len;
                    start = i;
                    end = j;
                }
                if(T.contains(String.valueOf(cs))){
                    --match[(int)cs];
                    if(match[(int)cs] < target[(int)cs])
                        ++count;
                }
                ++i;
            }
        }
        if(start == -1)
            return "";
        else
            return S.substring(start, end);
    }
}

//O(N * N * M) solution
public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int min = S.length() + 1;
        int start = -1, end = -1;
        for(int i = 0; i < S.length(); ++i){
            for(int j = i + T.length(); j <= S.length(); ++j){
                String tmp = new String(T);
                for(int k = i; k < j; ++k){
                    String cur = S.substring(k, k + 1);
                    if(tmp.contains(cur))
                        tmp = tmp.substring(0, tmp.indexOf(cur)) 
                        + tmp.substring(tmp.indexOf(cur) + 1);
                }
                if(tmp.length() == 0 && j - i < min){
                    min = j - i;
                    start = i;
                    end = j;
                    //if found one, no need to increase j, because must be larger
                    break;
                }
            }
        }
        if(start == -1)
            return "";
        else
            return S.substring(start, end);
    }
}