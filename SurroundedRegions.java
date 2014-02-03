public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i) {
            DFS(board, i, 0);
            DFS(board, i, n - 1);
        }
        for (int j = 1; j < n - 1; ++j) {
            DFS(board, 0, j);
            DFS(board, m - 1, j);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void DFS(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        if (board[i][j] == 'O') {
            board[i][j] = '#';
            if (i < m - 1) {
                DFS(board, i + 1, j);
            }
            if (i > 0) {
                DFS(board, i - 1, j);
            }
            if (j < n - 1) {
                DFS(board, i, j + 1);
            }
            if (j > 0) {
                DFS(board, i, j - 1);
            }
        }
    }
}

public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board.length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O') {
                BFS(board, i, 0);
            }
        }
        for (int j = 1; j < n; ++j) {
            if (board[m - 1][j] == 'O') {
                BFS(board, m - 1, j);
            }
        }
        for (int i = m - 2; i >= 0; --i) {
            if (board[i][n - 1] == 'O') {
                BFS(board, i, n - 1);
            }
        }
        for (int j = n - 2; j > 0; --j) {
            if (board[0][j] == 'O') {
                BFS(board, 0, j);
            }
        }
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    class Position {
        public int x, y;
        
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    //over time limit
    public void BFS(char[][] board, int i, int j) {
        Position p = new Position(i, j);
        Queue<Position> q = new LinkedList<Position>();
        q.offer(p);
        while (!q.isEmpty()) {
            Position t = q.poll();
            board[t.x][t.y] = '#';
            if (t.x - 1 >= 0 && board[t.x - 1][t.y] == 'O') {
                q.offer(new Position(t.x - 1, t.y));
            }
            if (t.x + 1 < board.length && board[t.x + 1][t.y] == 'O') {
                q.offer(new Position(t.x + 1, t.y));
            }
            if (t.y - 1 >= 0 && board[t.x][t.y - 1] == 'O') {
                q.offer(new Position(t.x, t.y - 1));
            }
            if (t.y + 1 < board[0].length && board[t.x][t.y + 1] == 'O') {
                q.offer(new Position(t.x, t.y + 1));
            }
        }
    }
    
    //stack overflow
    public void DFS(char[][] board, int i, int j) {
        board[i][j] = '#';
        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
            DFS(board, i - 1, j);
        }
        if (i + 1 < board.length && board[i + 1][j] == 'O') {
            DFS(board, i + 1, j);
        }
        if (j - 1 >= 0 && board[i][j - 1] == 'O') {
            DFS(board, i, j - 1);
        }
        if (j + 1 < board[0].length && board[i][j + 1] == 'O') {
            DFS(board, i, j + 1);
        }
    }
}