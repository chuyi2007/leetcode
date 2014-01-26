public class Solution {
    //binary search O(log(M*N))
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        int n = matrix[0].length;
        int max = m * n - 1;
        int min = 0;
        while (max >= min) {
            int mid = (max + min) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] < target) {
                min = mid + 1;
            }
            else if (matrix[i][j] > target) {
                max = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
    
    //O(M+N)
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        //remove overhead computing
        boolean flag1 = true, flag2 = true;
        while (i < m && j >= 0 && flag2) {
            if (matrix[i][j] > target) {
                --j;
                flag1 = false;
            }
            else if (matrix[i][j] < target) {
                ++i;
                if (!flag1) {
                    flag2 = false;
                }
            }
            else {
                return true;
            }
        }
        return false;
    }
}