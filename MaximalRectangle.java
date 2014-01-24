public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] histogram = new int[n];
        int max = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '0') {
                    histogram[j] = 0;
                }
                else {
                    histogram[j] += 1;
                }
            }
            
            Stack<Integer> st = new Stack<Integer>();
            int[] lens = new int[n];
            for (int j = 0; j < n; ++j) {
                while (!st.isEmpty() && histogram[j] <= histogram[st.peek()]) {
                    st.pop();
                }
                
                lens[j] = j - (st.isEmpty() ? -1 : st.peek()); 
                st.push(j);
            }
            
            st.clear();
            for (int j = n - 1; j >= 0; --j) {
                while (!st.isEmpty() && histogram[j] <= histogram[st.peek()]) {
                    st.pop();
                }
                lens[j] += (st.isEmpty() ? n: st.peek()) - j - 1; 
                st.push(j);
            }
            
            for (int j = 0; j < n; ++j) {
                max = Math.max(max, histogram[j] * lens[j]);
            }
        }
        
        return max;
    }
}