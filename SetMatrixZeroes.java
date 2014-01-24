//O(M*N)
public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length, n = matrix[0].length;
        int row = -1, col = -1;
        //find a flag row and col
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    row = i;
                    col = j;
                    i = m;
                    j = n;
                }
            }
        }
        //not found
        if (row == -1) {
	       return;
        }
        //set row and col as zero flags
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[row][j] = 0;
                    matrix[i][col] = 0;
                }
            }
        }
        //set zeroes of matrix
        for (int i = 0; i < m; ++i) {
            if (i != row && matrix[i][col] == 0) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; ++j) {
            if (j != col && matrix[row][j] == 0) {
                for (int i = 0; i < m; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
        //set the flag row and col
        for (int i = 0; i < m; ++i) {
            matrix[i][col] = 0;
        }
        for (int j = 0; j < n; ++j) {
            matrix[row][j] = 0;
        }
    }
}