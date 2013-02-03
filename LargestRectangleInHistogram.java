public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n= height.length;
        Stack<Integer> st = new Stack<Integer>();
        int[] areas = new int[n];
        for(int i = 0; i < n; ++i){
            while(!st.isEmpty() && height[i] <= height[st.peek()])
                st.pop();
            areas[i] = i - (st.isEmpty()?-1:st.peek());
            st.push(i);
        }
        st.clear();
        for(int i = n - 1; i >=0; --i){
            while(!st.isEmpty() && height[i] <= height[st.peek()])
                st.pop();
            areas[i] += (st.isEmpty()?n:st.peek()) - i - 1;
            st.push(i);
        }
        int max = 0;
        for(int i = 0; i < n; ++i){
            areas[i] *= height[i];
            if(areas[i] > max)
                max = areas[i];
        }
        return max;
    }

    public int naiveBrutalSearch(int[] height){
        int[] maxes = new int[height.length];
        int previous = 0;
        for(int i = 0; i < height.length; i++){
            if(height[i] > previous){
                int max = -1;
                int min = height[i];
                for(int j = i; j < height.length; j++){
                    if(min > height[j])
                        min = height[j];
                    int area = min * (j - i + 1);
                    if(area > max)
                        max = area;
                }
                maxes[i] = max;
            }
            previous = height[i];
            
        }
        
        int result = 0;
        for(int i = 0; i < maxes.length; i++)
            if(result < maxes[i])
                result = maxes[i];
        return result;
    }
}