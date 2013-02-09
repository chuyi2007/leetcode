//O(N)
public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0;
        for(int i = 0, j = height.length - 1; i < j;){
            int area = Math.min(height[i], height[j]) * (j - i);
            if(area > max)  
		max = area;
            if(height[j] >= height[i])
		++i;
            else
	        --j;
        }
        return max;
    }
}