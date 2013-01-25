public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] f = new int[T.length() + 1];
        f[T.length()] = 1;
        for(int i = S.length() - 1; i >= 0; --i){
            for(int j = 0; j < T.length(); ++j){
                f[j] += S.charAt(i) == T.charAt(j)?f[j + 1]:0;
            }
        }
        return f[0];
    }
}