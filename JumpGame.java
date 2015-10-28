public class Solution {
    public boolean canJump(int[] nums) {
        int mark = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            int jumpDist = i + nums[i];
            if (jumpDist >= mark) {
                mark = i;
            }
        }
        return mark == 0;
    }
}
