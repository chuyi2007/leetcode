public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return result;
        }
        int m = matrix.length, n = matrix[0].length;
        for (int x = 0; x * 2 < Math.min(m, n); ++x) {
            for (int j = x; j < n - x; ++j) {
                result.add(matrix[x][j]);
            }
            for (int i = x + 1; i < m - x; ++i) {
                result.add(matrix[i][n - x - 1]);
            }
            if (m - 2 * x > 1) {
                for (int j = n - x - 2; j >= x; --j) {
                    result.add(matrix[m - x - 1][j]);
                }
            }
            if (n - 2 * x > 1) {
                for (int i = m - x - 2; i > x; --i) {
                    result.add(matrix[i][x]);
                }
            }
        }
        return result;
    }
}