public class Solution {
    public int calculate(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int num = 0;
        int sign = 1;
        int result = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (int) (c - '0');
            } else if (c == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                st.push(result);
                st.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= st.pop();
                result += st.pop();
            }
        }
        if (num != 0) {
            result += sign * num;
        }
        return result;
    }
}
