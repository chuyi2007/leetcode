public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int start = 0, max = 0;
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '(')
		st.push(i);
            else{
                if(st.isEmpty())    
                    start = i + 1;
                else{
                    st.pop();
                    if(st.isEmpty())
                        max = Math.max(max, i - start + 1);
                    //st.pop() pops out previous ( which matches this )
                    //so it is still valid and needs to look for max
                    else    
                        max = Math.max(max, i - st.peek());
                }
            }
        }
        return max;
    }
}