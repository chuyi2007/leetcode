public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = board.length, n = board[0].length;
        boolean[][] table = new boolean[m][n];
        for(int i = 0; i < m; ++i)
            for(int j = 0; j < n; ++j){
                if(exist(board, word, table, i, j, 0))
                    return true;
            }
        return false;
    }
    
    public boolean exist(char[][] board, String word, boolean[][] table, int i, int j, int index){
        if(word.charAt(index) != board[i][j])
            return false;
        if(index + 1 == word.length())
            return true;
        int m = board.length, n = board[0].length;
        table[i][j] = true;
        if(i < m - 1 && !table[i+1][j] && exist(board, word, table, i + 1, j, index + 1))
            return true;
        if(i > 0 && !table[i-1][j] && exist(board, word, table, i - 1, j, index + 1))
            return true;
        if(j < n - 1 && !table[i][j + 1] && exist(board, word, table, i, j + 1, index + 1))
            return true;
        if(j > 0 && !table[i][j - 1] && exist(board, word, table, i, j - 1, index + 1))
            return true;
        table[i][j] = false;
        return false;
    }
}