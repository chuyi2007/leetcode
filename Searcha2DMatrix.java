public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int min = 0, max = m * n - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return false;
    }
}
