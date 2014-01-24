//O((M*N)^2)
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) {
            return false;
        }
        int m = board.length, n = board[0].length;
        boolean[][] map = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (wordSearch(board, word, map, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean wordSearch(char[][] board, String word, boolean[][] map, 
    int index, int i, int j) {
        if (index == word.length() - 1) {
            return word.charAt(index) == board[i][j];
        }
        int m = board.length, n = board[0].length;
        if (word.charAt(index) == board[i][j]) {
            map[i][j] = true;
            if (i + 1 < m && !map[i + 1][j] 
            && wordSearch(board, word, map, index + 1, i + 1, j)) {
                return true;
            }
            if (i - 1 >= 0 && !map[i - 1][j] 
            && wordSearch(board, word, map, index + 1, i - 1, j)) {
                return true;
            }
            if (j + 1 < n && !map[i][j + 1] 
            && wordSearch(board, word, map, index + 1, i, j + 1)) {
                return true;
            }
            if (j - 1 >= 0 && !map[i][j - 1] 
            && wordSearch(board, word, map, index + 1, i, j - 1)) {
                return true;
            }
            map[i][j] = false;
        }
        return false;
    }
}