//O(N) solution
public class Solution {
    public String minWindow(String S, String T) {
        int[] count = new int[256];
        int[] match = new int[256];
        int total = 0;
        for (char c : T.toCharArray()) {
            ++match[(int)c];
            ++total;
        }
        int start = -1, end = -1, min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i <= j && j <= S.length();) {
            if (total > 0) {
                if (j == S.length()) {
                    break;
                }
                char ce= S.charAt(j);
                ++count[(int)ce];
                if (count[(int)ce] <= match[(int)ce]) {
                    --total;
                }
                ++j;
            }
            if (total == 0) {
                if (j - i< min) {
                    min = j - i;
                    start = i;
                    end = j;
                }
                char cs = S.charAt(i);
                if (T.contains(String.valueOf(cs))) {
                    if (count[(int)cs] <= match[(int)cs]) {
                        ++total;
                    }
                    --count[(int)cs];
                }
                ++i;
            }
        }
        if (start == -1) {
            return "";
        }
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