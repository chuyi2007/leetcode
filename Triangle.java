public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = triangle.size();
        if(size == 0)
            return 0;
        int[] dp = new int[size];
        for(int i = 0; i < size; ++i)
            dp[i] = triangle.get(size - 1).get(i);
        for(int i = size - 2; i >= 0; --i){
            for(int j = 0; j < i + 1; ++j){
                dp[j] = Math.min(dp[j],dp[j+1]) 
                + triangle.get(i).get(j); 
            }
        }
        return dp[0];
    }
}