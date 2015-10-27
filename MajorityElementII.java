public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, count1 = 0, candidate2 = 1, count2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (candidate1 == nums[i]) {
                ++count1;
            } else if (candidate2 == nums[i]) {
                ++count2;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                --count1;
                --count2;
            }
        }
        List<Integer> result = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int num: nums) {
            if (num == candidate1) {
                ++count1;
            }
            if (num == candidate2) {
                ++count2;
            }
        }
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }
        return result;
    }
}
