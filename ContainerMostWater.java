//import java.util.Arrays;
public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //Arrays.sort(height);
        int max = 0;
        int size = height.length;
        for(int i = 0, j = size - 1; i < j;){
                int h = Math.min(height[i], height[j]);
                int w = j - i;
                int vol = h * w;
                if(vol > max){
                    max = vol;
                }
                if(height[i] > height[j])
                    j--;
                else{
                    i++;
                }
            
        }
        return max;
    }
}