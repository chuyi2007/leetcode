public class Solution {
    //O(N^2)
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = board.length;
        int n = (int)Math.sqrt(m);
        HashSet<Character> set = new HashSet<Character>();
        //row
        for(int i = 0; i < m; ++i){
            set.clear();
            for(int j = 0; j < m; ++j){
                if(board[i][j] != '.'){
                    if(!set.contains(board[i][j]))
                        set.add(board[i][j]);
                    else return false;
                }
            }
        }
        //col
        for(int j = 0; j < m; ++j){
            set.clear();
            for(int i = 0; i < m; ++i){
                if(board[i][j] != '.'){
                    if(!set.contains(board[i][j]))
                        set.add(board[i][j]);
                    else return false;
                }
            }
        }
        //small square
        
        for(int i = 0; i < m; i += n){
            for(int j = 0; j < m; j += n){
                set.clear();
                for(int l = 0; l < n; ++l){
                    for(int k = 0; k < n; ++k){
                        char c = board[i + l][j + k];
                        if(c != '.'){
                            if(!set.contains(c))
                                set.add(c);
                            else
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    //This elegant solution is from a sudoku solver
    public boolean solutionAsSolver(char[][] board){
        int n = board.length;
        int m = (int)Math.sqrt(n);
        //available integer for each slot
        ArrayList<HashSet<Integer>> aMap = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++){
                HashSet<Integer> set = new HashSet<Integer>();
                for(int k = 1; k <= n; k++)
                    set.add(k);
                aMap.add(set);
            }
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - 48;
                    HashSet<Integer> tmp = aMap.get(i * n + j);
                    if(!tmp.contains(num))  return false;
                    //row
                    for(int k = 0; k < n; k++){
                        if(k != j){
                            HashSet<Integer> set = aMap.get(i * n + k);
                            //if(!set.contains(num))  return false;
                            //else
                            if(set.contains(num))  set.remove(num);
                        }
                    }
                    //col
                    for(int k = 0; k < n; k++){
                        if(k != i){
                            HashSet<Integer> set = aMap.get(k * n + j);
                            //if(!set.contains(num))  return false;
                            //else
                            if(set.contains(num))  set.remove(num);
                        }
                    }
                    //small square
                    
                    int rs = i/m;
                    int cs = j/m;
                    int re = (rs + 1) * m;
                    int ce = (cs + 1) * m;
                    rs *= m;
                    cs *= m;
                    for(int k = rs; k < re; k++)
                        for(int l = cs; l < ce; l++){
                            if(k != i || j != l){
                                HashSet<Integer> set = aMap.get(k * n + l);
                                //if(!set.contains(num))  return false;
                                //else
                                if(set.contains(num))   set.remove(num);
                            }
                        }
                        
                }
            }
        return true;
    }
}