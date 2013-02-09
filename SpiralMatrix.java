//O(M*N)
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length < 1)
            return new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        spiralOrder(matrix, 0, result);
        return result;
    }
    
    public void spiralOrder(int[][] matrix, int x, ArrayList<Integer> result){
        int m = matrix.length, n = matrix[0].length;
        for(int j = x; j < n - x; ++j)
            result.add(matrix[x][j]);
        for(int i = x + 1; i < m - x; ++i)
            result.add(matrix[i][n - x - 1]);
        if(m - x > 1)
            for(int j = n - x - 2; j >= x; --j)
                result.add(matrix[m - x - 1][j]);
        if(n - x > 1)
            for(int i = m - x - 2; i >= x + 1; --i)
                result.add(matrix[i][x]);
        if(m - 2 > x && n - 2 > x)
            spiralOrder(matrix, x + 1, result);
    }
}