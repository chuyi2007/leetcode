public class Solution {
    public int totalNQueens(int n) {
        int[] board = new int[n];
        return totalNQueens(board, 0);
    }
    
    public int totalNQueens(int[] board, int index) {
        if (index == board.length) {
            return 1;
        }
        else {
            int sum = 0;
            for (int i = 0; i < board.length; ++i) {
                if (checkBoard(board, index, i)) {
                    board[index] = i;
                    sum += totalNQueens(board, index + 1);
                }
            }
            return sum;
        }
    }
    
    public boolean checkBoard(int[] board, int index, int val) {
        for (int i = 0; i < index; ++i) {
            if (board[i] == val
                || Math.abs(i - index) == Math.abs(board[i] - val)) {
                return false;
            }
        }
        return true;
    }
}