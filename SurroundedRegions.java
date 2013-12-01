public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board.length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O')
                DFS(board, i, 0);
        }
        for (int j = 1; j < n; ++j) {
            if (board[m - 1][j] == 'O')
                DFS(board, m - 1, j);
        }
        for (int i = m - 2; i >= 0; --i) {
            if (board[i][n - 1] == 'O')
                DFS(board, i, n - 1);
        }
        for (int j = n - 2; j > 0; --j) {
            if (board[0][j] == 'O')
                DFS(board, 0, j);
        }
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    
    public void DFS(char[][] board, int i, int j) {
        board[i][j] = '#';
        if (i - 1 >= 0 && board[i - 1][j] == 'O')
            DFS(board, i - 1, j);
        if (i + 1 < board.length && board[i + 1][j] == 'O')
            DFS(board, i + 1, j);
        if (j - 1 >= 0 && board[i][j - 1] == 'O')
            DFS(board, i, j - 1);
        if (j + 1 < board[0].length && board[i][j + 1] == 'O')
            DFS(board, i, j + 1);
    }
}