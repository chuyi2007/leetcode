000
public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
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