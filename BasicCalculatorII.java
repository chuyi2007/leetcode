public class Solution {
    public int calculate(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (int) (c - '0');
            } 
            if (!Character.isDigit(c) && c != ' ' || i == len - 1) {
                if (sign == '+') {
                    st.push(num);
                } else if (sign == '-') {
                    st.push(-num);
                } else if (sign == '*') {
                    st.push(st.pop() * num);
                } else if (sign == '/') {
                    st.push(st.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        for (int val: st) {
            res += val;
        }
        return res;
    }
}
