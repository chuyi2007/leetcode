public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n - i; ++j) {
                matrix[i][j] = count++;
            }
            for (int j = i + 1; j < n - i; ++j) {
                matrix[j][n - i - 1] = count++;
            }
            for (int j = n - i - 2; j >= i; --j) {
                matrix[n - i - 1][j] = count++;
            }
            for (int j = n - i - 2; j > i; --j) {
                matrix[j][i] = count++;
            }
        }
        return matrix;
    }
}