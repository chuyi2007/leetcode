public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        permute(allPermutations, new ArrayList<Integer>(), nums, new boolean[nums.length], 0);
        return allPermutations;
    }
    
    public void permute(
        List<List<Integer>> allPermutations, 
        List<Integer> current, 
        int[] nums, 
        boolean[] visited,
        int level
    ) {
        if (level == nums.length) {
            allPermutations.add(new ArrayList<Integer>(current));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (!visited[i]) {
                    visited[i] = true;
                    current.add(nums[i]);
                    permute(allPermutations, current, nums, visited, level + 1);
                    current.remove(current.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}
