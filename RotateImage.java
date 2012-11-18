public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //extraSpace(matrix);
        constantSpace(matrix);
    }
    
    public void constantSpace(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n; ++i)
            for(int j = i; j < n - i - 1; ++j){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
    }
    
    public void extraSpace(int[][] matrix){
        int[][] newMatrix = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                newMatrix[j][matrix.length-i - 1] = matrix[i][j];
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }
}