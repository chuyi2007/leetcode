public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        int[] board = new int[n];
        solveNQueens(result, board, 0);
        return result;
    }
    
    public void solveNQueens(ArrayList<String[]> result, int[] board, int index) {
        if (index == board.length) {
            String[] one = new String[board.length];
            for (int i = 0; i < board.length; ++i) {
                String line = "";
                for (int j = 0; j < board.length; ++j) {
                    if (board[i] == j) {
                        line += "Q";
                    }
                    else {
                        line += ".";
                    }
                }
                one[i] = line;
            }
            result.add(one);
        }
        else {
            for (int i = 0; i < board.length; ++i) {
                if (checkBoard(board, index, i)) {
                    board[index] = i;
                    solveNQueens(result, board, index + 1);
                }
            }
        }
    }
    
    public boolean checkBoard(int[] board, int index, int val) {
        for (int i = 0; i < index; ++i) {
            if (board[i] == val 
                || Math.abs(board[i] - val) == Math.abs(i - index)) {
                return false;
            }
        }
        return true;
    }
}