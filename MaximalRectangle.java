public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length == 0)  return 0;
        Stack<Integer> st = new Stack<Integer>();
        int[] lengths = new int[matrix[0].length];
        int max = 0, t = 0;
        for(int i = 0; i < matrix.length; ++i){
            int[] area = new int[matrix[i].length];
            for(int j = 0; j < matrix[i].length; ++j)
                if(matrix[i][j] == '1')
                    lengths[j] += 1;
                else
                    lengths[j] = 0;
            for(int j = 0; j < matrix[i].length; ++j){
                while(!st.isEmpty() && lengths[j] <= lengths[st.peek()])
                    st.pop();
                //add the current column inside
                t = st.isEmpty()?0:st.peek() + 1;
                area[j] = j - t + 1;
                st.push(j);
            }
            while(!st.isEmpty())
                st.pop();
            for(int j = matrix[i].length - 1; j >= 0; --j){
                while(!st.isEmpty() && lengths[j] <= lengths[st.peek()])
                    st.pop();
                //exclude the current column
                t = st.isEmpty()?matrix[i].length - 1:st.peek() - 1;
                area[j] += t - j;
                //calculate area
                area[j] *= lengths[j];
                st.push(j);
            }
            while(!st.isEmpty())
                    st.pop();
            for(int j = 0; j < area.length; ++j)
                if(max < area[j])
                    max = area[j];
        }
        return max;
    }
}