public class Solution {
    //binary search
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        int n = matrix[0].length;
        int max = m * n - 1;
        int min = 0;
        while(max >= min){
            int mid = (max + min) / 2;
            int i = mid / n;
            int j = mid % n;
            if(matrix[i][j] == target)  return true;
            else if(matrix[i][j] < target)   min = mid + 1;
            else max = mid - 1;
        }
        return false;
    }
    
    //O(M*N)
    public boolean naiveSearch(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}