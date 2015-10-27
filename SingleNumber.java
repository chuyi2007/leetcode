public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0;
        for (int i : nums) {
            one ^= i;
        }
        return one;
    }
}
