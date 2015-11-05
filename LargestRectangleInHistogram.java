public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> st = new Stack<>();
        int[] len = new int[height.length];
        for (int i = 0; i < height.length; ++i) {
            // the equal case is for things like [1, 1]
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }
            // add itself
            len[i] = i - (st.isEmpty() ? -1 : st.peek());
            st.push(i);
        }
        st.clear();
        for (int i = height.length - 1; i >= 0; --i) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }
            // don't add itself, that's why for the -1
            len[i] += (st.isEmpty() ? height.length : st.peek()) - i - 1;
            st.push(i);
        }
        int max = 0;
        for (int i = 0; i < height.length; ++i) {
            max = Math.max(max, len[i] * height[i]);
        }
        return max;
    }
}
