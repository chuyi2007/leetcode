//O(N)
public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char a = s.charAt(i);
            if (a == '(' || a == '{' || a == '[') {
                st.push(i);
            }
            else if (!st.isEmpty()) {
                char b = s.charAt(st.pop());
                if (!(a == ')' && b == '(') && 
                    !(a == '}' && b == '{') && 
                    !(a == ']' && b == '[')) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return st.isEmpty();
    }
}