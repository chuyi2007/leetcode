public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return result;
        }
        spiralOrder(matrix, 0, result);
        return result;
    }
    
    public void spiralOrder(int[][] matrix, int x, ArrayList<Integer> result) {
        int m = matrix.length, n = matrix[0].length;
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
        if (m - x > 2 && n - x > 2) {
            spiralOrder(matrix, x + 1, result);
        }
    }
}