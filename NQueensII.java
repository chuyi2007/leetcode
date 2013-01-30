public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] board = new int[n];
        //much better than a new class
        int[] count = new int[1];
        backTracking(count, board, 0, n);
        return count[0];
    }
    
    public void backTracking(int[] count, int[] board, int index, int n){
        if(index == n)
            ++count[0];
        else{
            for(int i = 0; i < n; ++i)
                if(checkOK(board, index, i)){
                    board[index] = i;
                    backTracking(count, board, index + 1, n);
                }
        }
    }
    
    public boolean checkOK(int[] board, int index, int val){
        for(int i = 0; i < index; ++i)
            if(board[i] == val || Math.abs(board[i] - val) == Math.abs(index - i))
                return false;
        return true;
    }
}