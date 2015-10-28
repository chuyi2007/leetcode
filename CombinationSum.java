public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> possibleCombination = new ArrayList<>();
        Arrays.sort(candidates);
        combinationsSum(combinations, possibleCombination, candidates, target, 0);
        return combinations;
    }
    
    public void combinationsSum(
        List<List<Integer>> combinations,
        List<Integer> possibleCombination,
        int[] candidates,
        int target,
        int level
    ) {
        if (target == 0) {
            combinations.add(new ArrayList<Integer>(possibleCombination));
        } else if (target > 0) {
            for (int i = level; i < candidates.length; ++i) {
                possibleCombination.add(candidates[i]);
                combinationsSum(combinations, possibleCombination, candidates, target - candidates[i], i);
                possibleCombination.remove(possibleCombination.size() - 1);
            }
        }
    }
}
