public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] board = new int[n];
        return totalNQueens(0, board);
    }
    
    public int totalNQueens(int index, int[] board){
        if(index == board.length)
            return 1;
        else{
            int total = 0;
            for(int i = 0; i < board.length; ++i){
                if(checkBoard(board, index, i)){
                    board[index] = i;
                    total += totalNQueens(index + 1, board);
                }
            }
            return total;
        }
    }
    
    public boolean checkBoard(int[] board, int index, int val){
        for(int i = 0; i < index; ++i)
            if(board[i] == val || Math.abs(i - index) == Math.abs(board[i] - val))
                return false;
        return true;
    }
}