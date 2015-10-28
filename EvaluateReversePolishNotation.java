//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; ++i) {
            if (tokens[i].equals("+")) {
                st.push(st.pop() + st.pop());
            }
            else if (tokens[i].equals("-")) {
                int right = st.pop(), left = st.pop();
                st.push(left - right);
            }
            else if (tokens[i].equals("*")) {
                st.push(st.pop() * st.pop());
            }
            else if (tokens[i].equals("/")) {
                int right = st.pop(), left = st.pop();
                st.push(left / right);
            }
            else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}
