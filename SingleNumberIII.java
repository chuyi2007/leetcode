public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i : nums) {
            diff ^= i;
        }
        // one bit difference
        diff &= (-diff);
        int[] result = {0, 0};
        for (int i : nums) {
            if ((diff & i) == 0) {
                result[0] ^= i;
            } else {
                result[1] ^= i;
            }
        }
        return result;
    }
}
