public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] matrix = new int[n][n];
        generateMatrix(matrix, 0, n, 0);
        return matrix;
    }
    
    public void generateMatrix(int[][] matrix, int x, int n, int count){
        if(n > 0){
            //top
            for(int j = x; j < n + x; ++j)
                matrix[x][j] = ++count;
            //right
            for(int i = x + 1; i < n + x; ++i)
                matrix[i][n + x - 1] = ++count;
            if(n > 1){
                //bottom
                for(int j = n + x - 2; j >=x; --j)
                    matrix[n + x - 1][j] = ++count;
                //left
                for(int i = n + x - 2; i > x; --i)
                    matrix[i][x] = ++count;
            }
            generateMatrix(matrix, x + 1, n - 2, count);
        }
    }
}

public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] matrix = new int[n][n];
        generateMatrix(matrix, 0, 1);
        return matrix;
    }
    
    public void generateMatrix(int[][] matrix, int x, int offset){
        int n = matrix.length;
        for(int j = x; j < n - x; ++j)
            matrix[x][j] = offset++;
        for(int i = x + 1; i < n - x; ++i)
            matrix[i][n - x - 1] = offset++;
        for(int j = n - x - 2; j >= x; --j)
            matrix[n - x - 1][j] = offset++;
        for(int i = n - x - 2; i >= x + 1; --i)
            matrix[i][x] = offset++;
        if(n > x)
            generateMatrix(matrix, x + 1, offset);
    }
}