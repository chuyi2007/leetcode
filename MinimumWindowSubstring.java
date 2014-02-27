public class Solution {
    public String minWindow(String S, String T) {
        int m = S.length(), n = T.length();
        int[] match = new int[256];
        int[] count = new int[256];
        int mc = 0;
        for (int i = 0; i < n; ++i) {
            ++match[(int)T.charAt(i)];
            ++mc;
        }
        
        int start = 0, end = m + 1;
        for (int i = 0, j = 0; i <= j && j <= m;) {
            if (mc > 0 && j < m) {
                char ce = S.charAt(j);
                if (match[(int)ce] > 0) {
                    ++count[(int)ce];
                    if (count[(int)ce] <= match[(int)ce]) {
                        --mc;
                    }
                }
                ++j;
            }
            else {
                if (mc == 0 && j - i < end - start) {
                    end = j;
                    start = i;
                }
                //for special case where m = 1 && n = 1
                if (i >= m) {
                    break;
                }
                char cs = S.charAt(i);
                if (match[(int)cs] > 0) {
                    --count[(int)cs];
                    if (count[(int)cs] < match[(int)cs]) {
                        ++mc;
                    }
                }
                ++i;
            }
        }
        if (end == m + 1) {
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
        for (int i = 0; i < S.length(); ++i) {
            for (int j = i + T.length(); j <= S.length(); ++j) {
                String tmp = new String(T);
                for (int k = i; k < j; ++k) {
                    String cur = S.substring(k, k + 1);
                    if (tmp.contains(cur))
                        tmp = tmp.substring(0, tmp.indexOf(cur)) 
                        + tmp.substring(tmp.indexOf(cur) + 1);
                }
                if (tmp.length() == 0 && j - i < min) {
                    min = j - i;
                    start = i;
                    end = j;
                    //if found one, no need to increase j, because must be larger
                    break;
                }
            }
        }
        if (start == -1)
            return "";
        else
            return S.substring(start, end);
    }
}