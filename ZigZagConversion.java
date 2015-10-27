//O(N)
public class Solution {
    public String convert(String s, int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = s.length();
        if (n < 1 || numRows == 1) {
            return s;
        }
        int block = 2 * numRows - 2;
        int col = n % block == 0 ? n / block : n / block + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < col; ++j) {
                int k = j * block + i;
                if (k < n) {
                    sb.append(s.charAt(k));
                }
                if (i > 0 && i < numRows - 1) {
                    k = (j + 1) * block - i;
                    if (k < n) {
                        sb.append(s.charAt(k));
                    }
                }
            }
        }
        return sb.toString();
    }
}
