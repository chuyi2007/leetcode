public class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int pos = 0;
	// Alwyas try to jump to furthest position
        while (pos < nums.length - 1) {
            int dist = nums[pos] + pos;
            int maxDist = 0;
            int nextPos = 0;
            for (int i = pos + 1; i <= dist; ++i) {
                if (i >= nums.length - 1) {
                    nextPos = i;
                    break;
                }
                if (maxDist < nums[i] + i) {
                    maxDist = nums[i] + i;
                    nextPos = i;
                }
            }
            pos = nextPos;
            ++step;
        }
        return step;
    }
}
