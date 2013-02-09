//O((M*N)^2)
public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board.length < 1)
            return false;
        int m = board.length, n = board[0].length;
        boolean[][] walked = new boolean[m][n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(exist(board, word, walked, i, j))
                    return true;
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word, boolean[][] walked, int i, int j){
        if(word.charAt(0) != board[i][j])
            return false;
        else
            word = word.substring(1);
        if(word.length() == 0)
            return true;
        int m = board.length, n = board[0].length;
        walked[i][j] = true;
        if(i + 1 < m && !walked[i + 1][j] && exist(board, word, walked, i + 1, j))
            return true;
        if(j + 1 < n && !walked[i][j + 1] && exist(board, word, walked, i, j + 1))
            return true;
            
        if(i > 0 && !walked[i - 1][j] && exist(board, word, walked, i - 1, j))
            return true;
            
        if(j > 0 && !walked[i][j - 1] && exist(board, word, walked, i, j - 1))
            return true;
       walked[i][j] = false;
       return false;
    }
}