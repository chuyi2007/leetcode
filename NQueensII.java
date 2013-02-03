public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] board = new int[n];
        return maxCount(0, board);
    }
    
    public int maxCount(int index, int[] board){
        int n = board.length;
        if(index == n){
            return 1;
        }
        else{
            int count = 0;
            for(int i = 0; i < n; ++i){
                if(checkBoard(board, index, i)){
                    board[index] = i;
                    count += maxCount(index + 1, board);
                }
            }
            return count;
        }
    }
    
    public boolean checkBoard(int[] board, int index, int val){
        for(int i = 0; i < index; ++i){
            if(board[i] == val || Math.abs(board[i] - val) == Math.abs(i - index))
                return false;
        }
        return true;
    }
}