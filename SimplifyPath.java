public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<String> st = new Stack<String>();
        String tmp = "";
        for(int i = 0; i < path.length(); ++i){
            if(path.charAt(i) == '.'){
                if(tmp.equals(".") && !st.isEmpty())
                    st.pop();
                else
                    tmp = ".";
            }
            else if(path.charAt(i) == '/'){
                if(tmp.equals("."))
                    tmp = "";
            }
            else{
                int j = i;
                while(j < path.length()){
                    if(path.charAt(j) == '/')
                        break;
                    ++j;
                }
                tmp = path.substring(i, j);
                st.push(tmp);
                i = j;
            }
        }
        tmp = "";
        while(!st.isEmpty())
            tmp = "/" + st.pop() + tmp;
        if(tmp.length() == 0)
            return "/";
        return tmp;
    }
}