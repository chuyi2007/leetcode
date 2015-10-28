public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (exist(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean exist(
        char[][] board, 
        boolean[][] visited, 
        String word, 
        int i, 
        int j,
        int index
    ) {
        if (word.length() == index) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (exist(board, visited, word, i + 1, j, index + 1) ||
            exist(board, visited, word, i - 1, j, index + 1) ||
            exist(board, visited, word, i, j + 1, index + 1) ||
            exist(board, visited, word, i, j - 1, index + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
