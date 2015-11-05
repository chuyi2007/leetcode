public class Solution {
    class Position {
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; ++i) {
            BFS(board, i, 0);
            BFS(board, i, board[0].length - 1);
        }
        for (int j = 0; j < board[0].length; ++j) {
            BFS(board, 0, j);
            BFS(board, board.length - 1, j);
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void BFS(char[][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(i, j));
        board[i][j] = '#';
        while (!q.isEmpty()) {
            Position cur = q.poll();
            if (cur.x > 0 && board[cur.x - 1][cur.y] == 'O') {
                q.offer(new Position(cur.x - 1, cur.y));
                board[cur.x - 1][cur.y] = '#';
            }
            if (cur.x < board.length - 1 && board[cur.x + 1][cur.y] == 'O') {
                q.offer(new Position(cur.x + 1, cur.y));
                board[cur.x + 1][cur.y] = '#';
            }
            if (cur.y > 0 && board[cur.x][cur.y - 1] == 'O') {
                q.offer(new Position(cur.x, cur.y - 1));
                board[cur.x][cur.y - 1] = '#';
            }
            if (cur.y < board[0].length - 1 && board[cur.x][cur.y + 1] == 'O') {
                q.offer(new Position(cur.x, cur.y + 1));
                board[cur.x][cur.y + 1] = '#';
            }
        }
    }
    
    //stack overflow
    public void DFS(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || 
            j < 0 || j >= board[0].length || 
            board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        DFS(board, i - 1, j);
        DFS(board, i + 1, j);
        DFS(board, i, j - 1);
        DFS(board, i, j + 1);
    }
}
