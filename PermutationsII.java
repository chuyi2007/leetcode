public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> possiblePermutation = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUnique(permutations, possiblePermutation, nums, visited, 0);
        return permutations;
    }
    
    public void permuteUnique(
        List<List<Integer>> permutations,
        List<Integer> possiblePermutation,
        int[] nums,
        boolean[] visited,
        int level
    ) {
        if (level == nums.length) {
            permutations.add(new ArrayList<>(possiblePermutation));
        } else if (level < nums.length) {
            for (int i = 0; i < nums.length; ++i) {
                if (!visited[i]) {
                    visited[i] = true;
                    possiblePermutation.add(nums[i]);
                    permuteUnique(permutations, possiblePermutation, nums, visited, level + 1);
                    possiblePermutation.remove(possiblePermutation.size() - 1);
                    visited[i] = false;
                    while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                        ++i;
                    }
                }
            }
        }
    }
}
