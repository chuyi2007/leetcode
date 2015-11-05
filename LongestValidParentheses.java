public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (st.isEmpty()) {
                start = i + 1;
            } else {
                st.pop();
                if (!st.isEmpty()) {
                    max = Math.max(max, i - st.peek());
                } else {
                    max = Math.max(max, i - start + 1);
                }
            }
        }
        return max;
    }
}
