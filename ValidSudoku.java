public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<Character>();
        int n = board.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] != '.') {
                    if (!set.contains(board[i][j])) {
                    set.add(board[i][j]);
                    }
                    else {
                        return false;
                    }
                }
            }
            set.clear();
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[j][i] != '.') {
                    if (!set.contains(board[j][i])) {
                        set.add(board[j][i]);
                    }
                    else {
                        return false;
                    }
                }
            }
            set.clear();
        }
        
        int d = (int)Math.sqrt(n);
        for (int i = 0; i < d; ++i) {
            for (int j = 0; j < d; ++j) {
                for (int k = 0; k < d; ++k) {
                    for (int l = 0; l < d; ++l) {
                        int x = i * d + k, y = j * d + l;
                        if (board[x][y] != '.') {
                            if (!set.contains(board[x][y])) {
                                set.add(board[x][y]);
                            }
                            else {
                                return false;
                            }
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}