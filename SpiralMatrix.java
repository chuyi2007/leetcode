public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length == 0)
            return new ArrayList<Integer>();
        return spiralOrder(matrix, 0, 0, matrix.length, matrix[0].length);
    }
    
    public ArrayList<Integer> spiralOrder(
        int[][] matrix, int x, int y, int m, int n){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(m <= 0 || n <= 0)
            return result;
        //top
        for(int j = y; j < n + y; ++j)
            result.add(matrix[x][j]);
        //right
        for(int i = x + 1; i < m + x; ++i)
            result.add(matrix[i][y + n - 1]);
        //bottom
        if(m > 1)
            for(int j = y + n - 2; j >= y; --j)
                result.add(matrix[x + m - 1][j]);
        //left
        if(n > 1)
            for(int i = x + m - 2; i > x; --i)
                result.add(matrix[i][y]);
        result.addAll(spiralOrder(matrix, x + 1, y + 1, m - 2, n - 2));
        return result;
    }
}