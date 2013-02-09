//O(M * N)
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean blocked = false;
        for(int i = 0; i < m; ++i)
            if(!blocked && obstacleGrid[i][0] == 0)
                dp[i][0] = 1;
            else
                blocked = true;
        
        blocked = false;
        for(int j = 0; j < n; ++j)
            if(!blocked && obstacleGrid[0][j] == 0)
                dp[0][j] = 1;
            else
                blocked = true;
        
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                dp[i][j] = obstacleGrid[i][j] == 0?dp[i][j - 1]+dp[i - 1][j]:0;
            }
        }
        return dp[m - 1][n - 1];
    }
}