public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0) return 0;
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        for(int i = 2; i < num.length; ++i)
            for(int j = 0; j < i; ++j)
                num[i] += num[j] * num[i - j - 1];
        return num[n];
    }
}