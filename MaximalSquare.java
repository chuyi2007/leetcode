public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] maxLengths = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;
        for (int i = 1; i <= matrix.length; ++i) {
            for (int j = 1; j <= matrix[0].length; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    maxLengths[i][j] = Math.min(Math.min(maxLengths[i - 1][j], maxLengths[i][j - 1]), maxLengths[i - 1][j - 1]) + 1;
                }
                max = Math.max(maxLengths[i][j], max);
            }
        }
        return max * max;
    }
}
