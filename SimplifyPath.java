public class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<String>();
        String word = "";
        for (int i = 0; i <= path.length(); ++i) {
            if (i == path.length() || path.charAt(i) == '/') {
                if (word.length() > 0) {
                    if (word.equals("..")) {
                        if (!st.isEmpty()) {
                            st.pop();
                        }
                    }
                    else if (!word.equals(".")) {
                        st.push(word);
                    }
                    word = "";
                }
            }
            else {
                word += String.valueOf(path.charAt(i));
            }
        }
        if (st.isEmpty()) {
            return "/";
        }
        String sb = "";
        while (!st.isEmpty()) {
            sb = "/" + st.pop() + sb;   
        }
        return sb.toString();
    }
}