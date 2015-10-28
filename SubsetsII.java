public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> possibleSubset = new ArrayList<>();
        subsetsWithDup(subsets, possibleSubset, nums, 0);
        return subsets;
    }
    
    public List<List<Integer>> subsetsWithDup(
        List<List<Integer>> subsets,
        List<Integer> possibleSubset,
        int[] nums, 
        int index
    ) {
        if (index <= nums.length) {
            subsets.add(new ArrayList<>(possibleSubset));
        }
        for (int i = index; i < nums.length; ++i) {
            possibleSubset.add(nums[i]);
            subsetsWithDup(subsets, possibleSubset, nums, i + 1);
            possibleSubset.remove(possibleSubset.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
        return subsets;
    }
}
