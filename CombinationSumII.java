public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> possibleCombination = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(combinations, possibleCombination, candidates, target, 0);
        return combinations;
    }
    
    public void combinationSum2(
        List<List<Integer>> combinations, 
        List<Integer> possibleCombination, 
        int[] candidates, 
        int target,
        int index
    ) {
        if (target == 0) {
            combinations.add(new ArrayList<>(possibleCombination));
        } else if (target > 0) {
            for (int i = index; i < candidates.length; ++i) {
                possibleCombination.add(candidates[i]);
                combinationSum2(combinations, possibleCombination, candidates, target - candidates[i], i + 1);
                possibleCombination.remove(possibleCombination.size() - 1);
                while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                    ++i;
                }
            }
        }
    }
}
