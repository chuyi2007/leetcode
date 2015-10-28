public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int numOfNeighbors = neighbors(board, i, j);
                if (board[i][j] == 0 && numOfNeighbors == 3) {
                    board[i][j] = 3;
                } else if (board[i][j] == 1 && (numOfNeighbors < 2 || numOfNeighbors > 3)) {
                    board[i][j] = 2;
                }
            }
        }
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] %= 2;
            }
        }
    }
    
    public int neighbors(int[][] board, int i, int j) {
        int numberOfLives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, board.length - 1); ++x) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, board[0].length - 1); ++y) {
                if ((x != i || y != j) && (board[x][y] == 2 || board[x][y] == 1)) {
                    numberOfLives++;
                }
            }
        }
        return numberOfLives;
    }
}
