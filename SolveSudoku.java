public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoKu(board, 0);
    }
    
    public boolean solveSudoKu(char[][] board, int index) {
        int n = board.length;
        int x = index / n;
        int y = index % n;
            
        if (index == n * n) {
            return true;
        }
        else if (board[x][y] == '.') {
            for (int i = 1; i <= n; ++i) {
                char c = (char) (i + 48);
                if (validSudoku(board, x, y, c)) {
                    board[x][y] = c;
                    
                    if (solveSudoKu(board, index + 1)) {
                        return true;
                    }
                    else {
                        board[x][y] = '.';
                    }
                }
            }
            return false;
        }
        else {
            return solveSudoKu(board, index + 1);
        }
    }
    
    public boolean validSudoku(char[][] board, int x, int y, char val) {
        int n = board.length;
        for (int i = 0; i < n; ++i) {
            if (board[i][y] == val) {
                return false;
            }
        }
        
        for (int j = 0; j < n; ++j) {
            if (board[x][j] == val) {
                return false;
            }
        }
        
        int m = (int) Math.sqrt(n);
        
        int k = x / m;
        int l = y / m;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[k * m + i][l * m + j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}