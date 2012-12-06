public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean flag = true;
        for(int i = 0; i < m; ++i){
            if(flag && obstacleGrid[i][0] == 0)
                dp[i][0] = 1;
            else{
                dp[i][0] = 0;
                flag = false;
            }
        }
        flag = true;
        for(int j = 0; j < n; ++j){
            if(flag && obstacleGrid[0][j] == 0)
                dp[0][j] = 1;
            else{
                dp[0][j] = 0;
                flag = false;
            }
        }
        
        for(int i = 1; i < m; ++i)
            for(int j = 1; j < n; ++j)
                if(obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else
                    dp[i][j] = 0;
                    
        return dp[m-1][n-1];
    }
}