public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; j > i;) {
            max = Math.max((j - i) * Math.min(height[i], height[j]), max);
            if (height[i] > height[j]) {
                --j;
            } else {
                ++i;
            }
        }
        return max;
    }
}
