public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> st = new Stack<Integer>();
        int n = height.length;
        int[] lens = new int[n];
        
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }
            lens[i] = i - (st.isEmpty() ? -1 : st.peek());
            st.push(i);
        }
        st.clear();
        
        for (int i = n - 1; i >= 0; --i) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }
            lens[i] += (st.isEmpty() ? n : st.peek()) - i - 1;
            st.push(i);
        }
        
        int max = 0;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, lens[i] * height[i]);
        }
        return max;
    }
}