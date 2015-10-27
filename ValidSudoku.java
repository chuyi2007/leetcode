public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!isPartialValid(board, i, i, 0, n - 1)) {
                    return false;
                }
                if (!isPartialValid(board, 0, m - 1, j, j)) {
                    return false;
                }
            }
        }
        for (int i = 0; i * i < m; ++i) {
            for (int j = 0; j * j < n; ++j) {
                if (!isPartialValid(board, i * 3, i * 3 + 2, j * 3, j * 3 + 2)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isPartialValid(char[][] board, int x1, int x2, int y1, int y2) {
        Set<Character> validation = new HashSet<>();
        for (int i = x1; i <= x2; ++i) {
            for (int j = y1; j <= y2; ++j) {
                if (board[i][j] != '.') {
                    if (!validation.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
