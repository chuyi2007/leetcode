public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        if(len < nRows || nRows == 1)
            return s;
        int d = 2 * nRows - 2;
        int nCols = len%d==0?len/d:len/d + 1;
        String result = "";
        for(int i = 0; i < nRows; ++i)
            for(int j = 0; j < nCols; ++j){
                int k = i + j * d;
                if(k < len && result.length() < len)
                    result += s.substring(k, k+1);
                if(i > 0 && i < nRows-1 && result.length() < len){
                    k += d - 2 * i;
                    if(k < len)
                        result += s.substring(k, k+1);
                }
            }
        return result;
    }
}