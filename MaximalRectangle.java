public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length < 1)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] lens = new int[n];
        int max = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == '1')
                    ++lens[j];
                else
                    lens[j] = 0;
            }
            
            Stack<Integer> st = new Stack<Integer>();
            int[] areas = new int[n];
            
            for(int j = 0; j < n; ++j){
                while(!st.isEmpty() && lens[j] <= lens[st.peek()])
                    st.pop();
                areas[j] = j - (st.isEmpty()?-1:st.peek());
                st.push(j);
            }
            
            st.clear();
            
            for(int j = n - 1; j >= 0; --j){
                while(!st.isEmpty() && lens[j] <= lens[st.peek()])
                    st.pop();
                areas[j] += (st.isEmpty()?n:st.peek()) - j - 1;
                st.push(j);
            }
            
            for(int j = 0; j < n; ++j){
                areas[j] *= lens[j];
                if(areas[j] > max)
                    max = areas[j];
            }
        }
        
        return max;
    }
}

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length < 1)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] lens = new int[n];
        int max = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == '1')
                    ++lens[j];
                else
                    lens[j] = 0;
            }
            
            for(int k = 0; k < n; ++k){
                int min = Integer.MAX_VALUE;
                for(int l = k; l < n; ++l){
                    if(min > lens[l])
                        min = lens[l];
                    int area = (l - k + 1) * min;
                    if(area > max)
                        max = area;
                }
                
                
                while(k < n - 1 && lens[k] > lens[k + 1])
                    ++k;
            }
        }
        
        return max;
    }
}