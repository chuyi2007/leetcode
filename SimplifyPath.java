//O(N)
public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<String> st = new Stack<String>();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < path.length(); ++i){
            char a = path.charAt(i);
            if(a == '/'){
                if(sb.length() > 0 && !sb.toString().equals("."))
                    st.push(sb.toString());
                sb = new StringBuffer();
            }
            else if(a == '.'){
                if(!sb.toString().equals("."))
                    sb.append('.');
                else if(!st.isEmpty()){
                    sb = new StringBuffer();
                    st.pop();
                }
            }
            else{
                sb.append(a);
            }
        }
        if(sb.length() > 0 && !sb.toString().equals("."))
            st.push(sb.toString());
        if(st.isEmpty())
            return "/";
        else{
            String result = "";
            while(!st.isEmpty()){
                result = "/" + st.pop() + result;
            }
            return result;
        }
    }
}