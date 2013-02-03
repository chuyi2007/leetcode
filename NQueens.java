public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> results = new ArrayList<String[]>();
        int[] board = new int[n];
        backTracking(results, board, 0, n);
        return results;
    }
    
    public void backTracking(ArrayList<String[]> results, 
    int[] board, int index, int n){
        if(index == n){
            String[] result = new String[n];
            for(int i = 0; i < n; ++i){
                result[i] = "";
                for(int j = 0; j < n; ++j)
                    result[i] += (board[i] == j)?"Q":".";
            }
            results.add(result);
        }
        else{
            for(int i = 0; i < n; ++i){
                if(checkOK(board, index, i)){
                    board[index] = i;
                    backTracking(results, board, index + 1, n);
                }
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

public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> result = new ArrayList<String[]>();
        int[] board = new int[n];
        solveQueens(0, board, result);
        return result;
    }
    
    public void solveQueens(int index, int[] board, ArrayList<String[]> result){
        int n = board.length;
        if(index == n){
            String[] row = new String[n];
            for(int i = 0; i < n; ++i){
                StringBuffer sb = new StringBuffer();
                for(int j = 0; j < n; ++j)
                    if(board[i] == j)
                        sb.append('Q');
                    else
                        sb.append('.');
                row[i] = sb.toString();
            }
            result.add(row);
        }
        else{
            for(int i = 0; i < n; ++i){
                if(checkBoard(board, index, i)){
                    board[index] = i;
                    solveQueens(index + 1, board, result);
                }
            }
        }
    }
    
    public boolean checkBoard(int[] board, int index, int val){
        for(int i = 0; i < index; ++i){
            if(board[i] == val 
            || Math.abs(i - index) == Math.abs(board[i] - val))
                return false;
        }
        return true;
    }
}