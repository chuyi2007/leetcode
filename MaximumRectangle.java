public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int rowNum = matrix.length;
        if(matrix.length < 1)
            return 0;
        int colNum = matrix[0].length;
        int max = 0;
        
        int[] lengths = new int[colNum];
        for(int i = 0; i < rowNum; i++){
            Stack<Integer> st = new Stack<Integer>();
            int[] areas = new int[colNum];
            
            for(int j = 0; j < colNum; j++){
                if(matrix[i][j] == '1')
                    lengths[j] += 1;
                else
                    lengths[j] = 0;
            }
            
            int left, right;
            
            for(int j = 0; j < colNum; j++){
                while(!st.isEmpty()){
                    if(lengths[j] <= lengths[st.peek()])
                        st.pop();
                    else
                        break;
                }
                if(!st.isEmpty())
                    left = st.peek() + 1;
                else
                    left = 0;
                areas[j] = j - left + 1;
                st.push(j);
            }
            
            while(!st.isEmpty())
                st.pop();
            for(int j = colNum - 1; j >= 0; j--){
                while(!st.isEmpty()){
                    if(lengths[j] <= lengths[st.peek()])
                        st.pop();
                    else
                        break;
                }
                if(!st.isEmpty())
                    right = st.peek() - 1;
                else
                    right = colNum - 1;
                areas[j] += right - j;
                st.push(j);
            }
            
            for(int j = 0; j < colNum; j++)
                max = Math.max(areas[j] * lengths[j],max);
        }
        return max;
    }
}