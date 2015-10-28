public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        return subsets(nums, 0);
    }
    
    public List<List<Integer>> subsets(int[] nums, int level) {
        List<List<Integer>> listOfSubsets = new ArrayList<>();
        if (level == nums.length) {
            listOfSubsets.add(new ArrayList<>());
            return listOfSubsets;
        }
        for (List<Integer> tmp: subsets(nums, level + 1)) {
            listOfSubsets.add(new ArrayList<>(tmp));
            tmp.add(0, nums[level]);
            listOfSubsets.add(new ArrayList<>(tmp));
        }
        return listOfSubsets;
    }
}
