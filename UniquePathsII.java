//O(M * N)
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] memory = new int[m][n];
        return uniquePathsWithObstacles(obstacleGrid, memory, m - 1, n - 1);
    }
    
    public int uniquePathsWithObstacles(
        int[][] obstacleGrid, 
        int[][] memory, 
        int i, 
        int j
    ) {
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (memory[i][j] != 0) {
            return memory[i][j];
        }
        int count = 0;
        if (i > 0) {
            count += uniquePathsWithObstacles(obstacleGrid, memory, i - 1, j);
        }
        if (j > 0) {
            count += uniquePathsWithObstacles(obstacleGrid, memory, i, j - 1);
        }
        memory[i][j] = count;
        return count;
    }
}
